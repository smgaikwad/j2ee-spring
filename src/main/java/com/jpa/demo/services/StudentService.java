package com.jpa.demo.services;

import com.jpa.demo.entities.Student;
import com.jpa.demo.entities.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        student.setRegistrationDate(LocalDateTime.now());
        student.setLastModifiedDate(LocalDateTime.now());
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Student student) {

        Student existedStudent = studentRepository.findById(student.getStudentId()).orElseThrow(()->
                new
                IllegalStateException("Student with id: "+ student.getStudentId() + "does not exist")
        );

        existedStudent.setStudentName(student.getStudentName());
        existedStudent.setLastModifiedDate(LocalDateTime.now());

    }

    public void deleteStudent(Integer studentId) {
        if (studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }else
            throw new IllegalStateException("student id: "+ studentId +" does not exists..");
    }
}
