package com.aop.example.demo.services;

import org.springframework.stereotype.Component;

@Component("init")
public class InitialServices {
    public void start(){
        System.out.println("Initial Service Started...");
    }

    public void stop(){
        System.out.println("Initial Service stopped...");
    }
}
