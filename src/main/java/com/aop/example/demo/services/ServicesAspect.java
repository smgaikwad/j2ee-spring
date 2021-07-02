package com.aop.example.demo.services;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class ServicesAspect {

    @Before("execution(* com.aop.example.demo.services.InitialServices.start())")
    public void start()
    {
        System.out.println("Initial Service is going to start...please wait");
    }

    @After("execution(* com.aop.example.demo.services.InitialServices.stop()))")
    public void stop(){
        System.out.println("Initial service is ended...now you can go home...!");
    }
}
