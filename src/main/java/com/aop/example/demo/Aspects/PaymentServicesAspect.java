package com.aop.example.demo.Aspects;

import com.aop.example.demo.Exceptions.PaymentNotInitializedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PaymentServicesAspect {

    @Before("execution(* com.aop.example.demo.services.PaymentServicesImpl.makePayment())")
    public void start() {
        System.out.println("Your Payment Service is Started..!");
    }

    @After("execution(* com.aop.example.demo.services.PaymentServicesImpl.makePayment())")
    public void stop() {
        System.out.println("Your Transaction Ended..!");
    }

    @AfterReturning(value = "execution(* com.aop.example.demo.services.PaymentServicesImpl.makePayment())", returning = "status")
    public void afterReturning(String status) {
        System.out.println("Transaction Status: " + status);
    }

    @AfterThrowing(value = "execution(* com.aop.example.demo.services.PaymentServicesImpl.makePayment())", throwing = "exception")
    public void afterThrowing(PaymentNotInitializedException exception) {
        System.out.println("TRANSACTION STATUS: FAILED");
        System.out.println("EXCEPTION CODE: " + exception.exceptionId);
        System.out.println("EXCEPTION MESSAGE: " + exception.getMessage());
    }

//    @Around("execution(* com.aop.example.demo.services.PaymentServicesImpl.makePayment())")
//    public void around(ProceedingJoinPoint jp){
//        //Object arr[] = jp.getArgs();
//        System.out.println("Site is under Construction, will be back soon..!" +
//                "\nThank You for using our PaymentService..!");
//
//    }
}
