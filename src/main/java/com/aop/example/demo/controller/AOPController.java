package com.aop.example.demo.controller;

import com.aop.example.demo.Exceptions.PaymentNotInitializedException;
import com.aop.example.demo.services.PaymentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/makePayment")
public class AOPController {

    @Autowired
    PaymentServicesImpl paymentServices;

    @GetMapping
    public void initCall() {
        try {
            paymentServices.makePayment();
        } catch (PaymentNotInitializedException e) {

        }
    }
}