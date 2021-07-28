package com.aop.example.demo;

import com.aop.example.demo.Exceptions.PaymentNotInitializedException;
import com.aop.example.demo.services.PaymentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAOPDemoApplication {

    private static PaymentServicesImpl paymentServices;

    @Autowired
    public SpringAOPDemoApplication(PaymentServicesImpl paymentServices) {
        this.paymentServices = paymentServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAOPDemoApplication.class, args);

        try {
            paymentServices.makePayment();
        } catch (PaymentNotInitializedException e) {

        }
    }

}
