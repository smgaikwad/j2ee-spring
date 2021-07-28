package com.aop.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.aop.example.demo")
public class AOPConfig {

    @Bean
    public Scanner getScannerObject() {
        return new Scanner(System.in);
    }
}


