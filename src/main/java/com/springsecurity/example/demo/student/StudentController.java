package com.springsecurity.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private static List<Student> STUDENTS = Arrays.asList(
     new Student(1, "Sooraj gaikwad"),
     new Student(2, "Dhiraj Gaikwad gaikwad"),
     new Student(3, "Avani gaikwad")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId)
    {
        return STUDENTS.stream().
                filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId +" does not exist"));
    }

}
