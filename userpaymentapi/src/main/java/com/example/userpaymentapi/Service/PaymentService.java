package com.example.userpaymentapi.Service;

import com.example.userpaymentapi.Entity.Payment;
import com.example.userpaymentapi.Entity.User;
import com.example.userpaymentapi.Repo.PaymentRepository;
import com.example.userpaymentapi.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.userpaymentapi.utils.CardHandler.isValidCardNumber;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    public Payment addPayment(Long userId, Payment payment) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        payment.setUser(user);
        payment.setCreatedAt(LocalDateTime.now());
        payment.setCardCvc("XXX");

        if (!isValidCardNumber(payment.getCardNo())) {
            throw new IllegalArgumentException("Invalid card number: Failed Luhn check");
        }


        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByUser(Long userId) {
        if(paymentRepository.findByUserId(userId) ==null){
            return new ArrayList<>();
        }

        return paymentRepository.findByUserId(userId);
    }





}
