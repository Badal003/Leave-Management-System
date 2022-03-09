package com.example.tmpproject.controller;

import com.example.tmpproject.model.Employee;
import com.example.tmpproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee AddEmployee(@RequestBody Employee employee)
    {
        employee.setPassword(GeneratePassword.generateRandomPassword());
        return employeeService.saveEmployee(employee);
    }

}
