package com.beanscope.demo;

import com.beanscope.demo.student.singleton.prototype.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {

       SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);

//        System.out.println(student1);
//        System.out.println(student2);

        student1.setStudentName("Dhiraj Gaikwad");
        student1.setStudentId(14);

        System.out.println(student1);
        System.out.println(student2);

        System.out.println();
        student1.address.setCity("Solapur");

        System.out.println(student1);
        System.out.println(student2);

        System.out.println(student1.getAddressObject());

//        Employee employee = context.getBean(Employee.class);
//        System.out.println(employee);
    }
}
