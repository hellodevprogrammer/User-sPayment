package com.example.userpaymentapi.Controllers;

import com.example.userpaymentapi.Entity.Payment;
import com.example.userpaymentapi.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.userpaymentapi.utils.CardHandler.maskCardNumber;

@RestController
@RequestMapping("/users/{userId}/payments")
public class PaymentController {



    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> addPayment(@PathVariable Long userId, @RequestBody Payment payment) {
        Payment pay =  paymentService.addPayment(userId, payment);
        pay.setCardNo(maskCardNumber(pay.getCardNo()));
        return new ResponseEntity<>(pay, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Payment> getPayments(@PathVariable Long userId) {
        return paymentService.getPaymentsByUser(userId);
    }
}
