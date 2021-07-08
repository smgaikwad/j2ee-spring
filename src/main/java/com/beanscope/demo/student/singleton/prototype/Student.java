package com.beanscope.demo.student.singleton.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public abstract class Student {
    @Value("${student.name}")
    private String studentName;

    @Value("${student.id}")
    private Integer studentId;

    @Autowired
    public
    Address address;


    @Override
    public String toString() {
        return "Student: " +
                "Student Name = '" + studentName + '\'' +
                ", Student Id = " + studentId +
                ", Address = " + address;
    }

    public Student(String studentName, Integer studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public Student() {
    }

    public Address getAddress() {
        return getAddressObject();
    }

    @Lookup
    public abstract Address getAddressObject();

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
