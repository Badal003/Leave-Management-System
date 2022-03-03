package com.example.tmpproject.service;

import com.example.tmpproject.repository.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepositry employeeRepositry;
}
