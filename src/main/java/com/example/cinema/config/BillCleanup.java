package com.example.cinema.config;

import com.example.cinema.pojo.entity.Bill;
import com.example.cinema.pojo.entity.BillStatus;
import com.example.cinema.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling
@AllArgsConstructor
public class BillCleanup {
    private BillRepository billRepository;

    @Scheduled(fixedRate = 2 * 60000)
    public void billCleanupTask() {
        System.out.println("BillCleanup: Cleanup Bill running...");
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(30);
        List<Bill> expiredBills = billRepository.findByCreatedTimeBeforeAndStatus(fiveMinutesAgo, BillStatus.PENDING.ordinal());
        for (Bill bill : expiredBills) {
            bill.setStatus(BillStatus.CANCEL);
        }
        billRepository.saveAll(expiredBills);
    }
}
