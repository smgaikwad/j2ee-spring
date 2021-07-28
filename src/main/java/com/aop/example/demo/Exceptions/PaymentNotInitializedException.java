package com.aop.example.demo.Exceptions;

public class PaymentNotInitializedException extends Exception {
    public final long exceptionId = 12345678910111213L;

    public PaymentNotInitializedException(String msg) {
        super(msg);
    }
}
