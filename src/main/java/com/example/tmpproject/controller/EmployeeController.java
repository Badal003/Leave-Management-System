package com.example.tmpproject.controller;

import com.example.tmpproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

}
