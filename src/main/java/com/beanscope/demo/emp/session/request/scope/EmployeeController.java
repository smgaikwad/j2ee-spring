package com.beanscope.demo.emp.session.request.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final Employee employee;

    @Autowired
    public EmployeeController(Employee employee) {
        this.employee = employee;
    }

    @GetMapping("/emp")
    public String getEmployee(){
        employee.setEmployeeName("Sooraj Gaikwad");

        return "Name: " + employee.getEmployeeName() + "  Salary: "+ employee.getSalary();
    }

    @GetMapping("/emp1")
    public String getEmployee1(){
        return "Name: " + employee.getEmployeeName() + "  Salary: "+ employee.getSalary();
    }
}