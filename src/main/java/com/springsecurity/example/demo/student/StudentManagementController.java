package com.springsecurity.example.demo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/student")
public class StudentManagementController {

    private static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Sooraj gaikwad"),
            new Student(2, "Dhiraj Gaikwad gaikwad"),
            new Student(3, "Avani gaikwad")
    );

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public List<Student> getStudent()
    {
        return STUDENTS;
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAuthority('student:write')")
    public String addStudent(@RequestBody Student student){
        return "student " + student.getStudentName() + " added successfully...";
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public Student deleteStudent(@PathVariable Integer studentId)
    {
       return STUDENTS.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student " + studentId + " does not exist"));
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public Student updateStudent(@PathVariable Integer studentId)
    {
        return STUDENTS.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student " + studentId + " does not exist"));

    }
}
