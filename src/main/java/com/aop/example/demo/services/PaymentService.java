package com.aop.example.demo.services;

import com.aop.example.demo.Exceptions.PaymentNotInitializedException;

public interface PaymentService {
    public String makePayment() throws PaymentNotInitializedException;
}
