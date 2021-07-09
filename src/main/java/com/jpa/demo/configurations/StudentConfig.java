package com.jpa.demo.configurations;

import com.jpa.demo.entities.Student;
import com.jpa.demo.entities.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {

            studentRepository.saveAll(List.of());
        };
    }

//    @Bean
//    Student getStudent(){
//        return new Student();
//    }
}
