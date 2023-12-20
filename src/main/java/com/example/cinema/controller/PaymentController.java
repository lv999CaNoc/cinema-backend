package com.example.cinema.controller;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.entity.Bill;
import com.example.cinema.pojo.entity.BillStatus;
import com.example.cinema.pojo.requests.OrderRequest;
import com.example.cinema.repository.BillRepository;
import com.example.cinema.service.BillService;
import com.example.cinema.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class PaymentController {
    private PaypalService paypalService;
    private BillService billService;

    private BillRepository billRepository;

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<String> payment(@NotNull @RequestBody OrderRequest order) {
        try {
            Payment payment = paypalService.createPayment(order.getPrice(), "USD", "paypal",
                    "sale", order.getDescription(),
                    "http://sandbox/payment/cancel",
                    "http://sandbox/payment/success?bid=" + order.getBillId());
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return ResponseEntity.ok(link.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
    }


    @GetMapping("/success")
    public ResponseEntity<String> success(@RequestParam("bid") Long billId,
                                          @RequestParam("paymentId") String paymentId,
                                          @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                Bill bill = billRepository.findById(billId)
                        .orElseThrow(() -> new CinemaException(ExceptionCode.BILL_NOT_FOUND));
                bill.setStatus(BillStatus.COMPLETE);
                bill.setPaymentTime(LocalDateTime.now());
                bill.setPaymentId(paymentId);
                bill.setPayerID(payerId);

                billRepository.save(bill);
                System.out.println("success + " + paymentId);
            }
            return ResponseEntity.ok("success payment");
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
