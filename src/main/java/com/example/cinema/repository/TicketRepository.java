package com.example.cinema.repository;

import com.example.cinema.pojo.entity.BillStatus;
import com.example.cinema.pojo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t.id FROM Ticket t " +
            "WHERE t.seat.id=:seatId " +
            "AND t.bill.id IN " +
            "(SELECT b.id FROM Bill b " +
            "WHERE b.schedule.id=:scheduleId " +
            "AND b.status IN :status)")
    List<Integer> findTickets_IdByBill_StatusAndSchedule_IdAndSeat_Id(@Param("status") List<BillStatus> status,
                                                                      @Param("scheduleId") Long scheduleId,
                                                                      @Param("seatId") Long seatId);
    List<Ticket> findTicketsByBill_Id(Long billId);
}
