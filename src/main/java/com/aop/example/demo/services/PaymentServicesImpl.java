package com.aop.example.demo.services;

import com.aop.example.demo.Exceptions.PaymentNotInitializedException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Data
public class PaymentServicesImpl implements PaymentService {

    @Override
    public String makePayment() throws PaymentNotInitializedException {

        if (LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
            throw new PaymentNotInitializedException("Payment Failed Due to Weekly Holiday..!");
        } else {

            System.out.println("Amount Debited from Bank Account..!");


            System.out.println("Amount Credited in Bank Account..!");
            return "Done";
        }
    }
}
