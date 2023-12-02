package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.dto.TicketDto;
import com.example.cinema.pojo.entity.Bill;
import com.example.cinema.pojo.entity.BillStatus;
import com.example.cinema.pojo.entity.Seat;
import com.example.cinema.pojo.entity.Ticket;
import com.example.cinema.pojo.requests.BookingRequest;
import com.example.cinema.repository.BillRepository;
import com.example.cinema.repository.SeatRepository;
import com.example.cinema.repository.TicketRepository;
import com.example.cinema.service.ImgbbService;
import com.example.cinema.service.QRCodeService;
import com.example.cinema.service.TicketService;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;
    private BillRepository billRepository;

    private QRCodeService qrCodeService;
    private ImgbbService uploadService;

    private ModelMapper modelMapper;

    @Override
    public boolean isSeatAvailable(Long scheduleId, Long seatId) {
        return ticketRepository.findTickets_IdByBill_StatusAndSchedule_IdAndSeat_Id(
                Arrays.asList(BillStatus.PENDING, BillStatus.COMPLETE),
                scheduleId, seatId).isEmpty();
    }

    public List<TicketDto> create(BookingRequest bookingRequest, Long billId) throws RuntimeException {
        List<TicketDto> tickets = new ArrayList<>();

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new CinemaException(ExceptionCode.BILL_NOT_FOUND));

        bookingRequest.getListSeatIds().stream().forEach(seatId -> {
            Seat seat = seatRepository.findById(seatId)
                    .orElseThrow(() -> new CinemaException(ExceptionCode.SEAT_NOT_FOUND));

            // generate and upload QR code
            String qrContext = "UserID_" + bookingRequest.getUserId() +
                    ".BillID_" + billId +
                    ".SeatID_" + seatId;
            try {
                byte[] imageBytes = qrCodeService.generateQRCodeImage(qrContext, 240, 240);
                HttpResponse<String> response = uploadService.upload(imageBytes);
                if (response.statusCode() == 200) {
                    String qrImageUrl = uploadService.getDisplayUrl(response.body());
                    System.out.println("Image uploaded successfully.\n");

                    // save ticket
                    Ticket ticketToCreate = Ticket.builder()
                            .bill(bill)
                            .seat(seat)
                            .qrImageURL(qrImageUrl)
                            .build();
                    ticketRepository.save(ticketToCreate);
                    tickets.add(modelMapper.map(ticketToCreate, TicketDto.class));
                } else {
                    System.err.println("Failed to upload image. Status code: " + response.statusCode());
                }
            } catch (WriterException | IOException | InterruptedException e) {
                System.err.println(e.getMessage());
                throw new CinemaException(ExceptionCode.INTERNAL_SERVER_ERROR);
            }
        });
        return tickets;
    }
}
