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
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.ImgbbService;
import com.example.cinema.service.QRCodeService;
import com.example.cinema.service.TicketService;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private UserRepository userRepository;

    private QRCodeService qrCodeService;
    private ImgbbService uploadService;
    private PasswordEncoder hashFunction;

    private ModelMapper modelMapper;

    @Override
    public boolean isSeatAvailable(Long scheduleId, Long seatId) {
        return ticketRepository.findTickets_IdByBill_StatusAndSchedule_IdAndSeat_Id(
                Arrays.asList(BillStatus.PENDING, BillStatus.COMPLETE),
                scheduleId, seatId).isEmpty();
    }

    @Override
    public List<TicketDto> getAllTicketByBill(Long id) {
        billRepository.findById(id)
                .orElseThrow(() -> new CinemaException(ExceptionCode.BILL_NOT_FOUND));
        return ticketRepository.findTicketsByBill_Id(id).stream()
                .map(this::mapToDTO).toList();
    }

    @Override
    public List<TicketDto> create(BookingRequest bookingRequest, Bill bill) throws RuntimeException {
        List<TicketDto> tickets = new ArrayList<>();

        bookingRequest.getListSeatIds().stream().forEach(seatId -> {
            Seat seat = seatRepository.findById(seatId)
                    .orElseThrow(() -> new CinemaException(ExceptionCode.SEAT_NOT_FOUND));

            Ticket ticketToCreate = Ticket.builder()
                    .bill(bill)
                    .seat(seat)
                    .build();

            Ticket ticketCreated = ticketRepository.save(ticketToCreate);

            // QR code integrity
            String UID = bill.getUser().getId().toString();
            int TID = ticketCreated.getId();
            String message = UID + TID;

            String hash = hashFunction.encode(message);
            // generate and upload QR code
            String qrContext = UID + "$" + TID + "$" + hash;
            try {
                byte[] imageBytes = qrCodeService.generateQRCodeImage(qrContext, 240, 240);
                HttpResponse<String> response = uploadService.upload(imageBytes);
                if (response.statusCode() == 200) {
                    String qrImageUrl = uploadService.getDisplayUrl(response.body());
                    System.out.println("Image uploaded successfully.\n");

                    ticketCreated.setQrContext(qrContext);
                    ticketCreated.setQrImageURL(qrImageUrl);
                    ticketCreated.setQrExpiration(bill.getSchedule().getStartDate().plusHours(2));

                    ticketRepository.save(ticketCreated);
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

    @Override
    public TicketDto getTicketByQRcode(String token) {
        String[] parts = token.split("\\$");

        Long userId = Long.parseLong(parts[0]);
        userRepository.findById(userId)
                .orElseThrow(() -> new CinemaException(ExceptionCode.USER_NOT_FOUND));

        Integer ticketId = Integer.parseInt(parts[1]);
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new CinemaException(ExceptionCode.TICKET_NOT_FOUND));

        if (ticket.getBill().getUser().getId() != userId) {
            // thông tin của QR không chính xác
            throw new CinemaException(ExceptionCode.INVALID_QR_CODE);
        }

        int firstIndex = token.indexOf("$");
        int secondIndex = token.indexOf("$", firstIndex + 1);
        String hash = token.substring(secondIndex + 1);

        String message = parts[0] + parts[1];
        if (!hashFunction.matches(message, hash)) {
            // thông tin của QR không đảm bảo tính toàn vẹn
            throw new CinemaException(ExceptionCode.QR_CODE_COMPROMISED);
        }

        return mapToDTO(ticket);
    }

    private TicketDto mapToDTO(Ticket ticket) {
        return modelMapper.map(ticket, TicketDto.class);
    }
}
