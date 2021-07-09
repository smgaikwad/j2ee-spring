package com.jpa.demo;

import com.jpa.demo.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Persistence;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
//
//        var emf =
//                Persistence.createEntityManagerFactory("my-persistent");
//        var entityManager = emf.createEntityManager();
//
//        //Student sooraj = entityManager.find(Student.class, 1);
//
//        entityManager.getTransaction().begin();
//        Student sooraj = new Student(1, "Sooraj Gaikwad");
//
//
//
//        entityManager.persist(sooraj);
//        entityManager.getTransaction().commit();
    }

}
