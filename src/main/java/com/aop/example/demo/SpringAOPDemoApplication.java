package com.aop.example.demo;

import com.aop.example.demo.services.AOPController;
import com.aop.example.demo.services.InitialServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
public class SpringAOPDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAOPDemoApplication.class, args);
        AOPController controller = new AOPController();
        controller.initCall();
    }

}
