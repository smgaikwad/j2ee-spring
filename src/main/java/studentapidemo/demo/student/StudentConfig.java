package studentapidemo.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    //CommandLineRunner is an interface used to indicate that
        // a bean should run when it is contained within a
        // SpringApplication.
        // A Spring Boot application can have multiple beans implementing CommandLineRunner
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student sooraj = new Student(
                    "Sooraj gaikwad",
                    "sooraj@gmail.com",
                    LocalDate.of(1998, 12, 23));

            Student dhiraj = new Student(
                    "dhiraj gaikwad",
                    "dhiraj@gmail.com",
                    LocalDate.of(2000, 11, 19));

            repository.saveAll(
                    List.of(sooraj, dhiraj)
            );
        };
    }
}
