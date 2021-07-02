package com.aop.example.demo.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class AOPController {
    public void initCall(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        InitialServices initialServices = context.getBean(InitialServices.class);
        initialServices.start();
        initialServices.stop();
    }
}
