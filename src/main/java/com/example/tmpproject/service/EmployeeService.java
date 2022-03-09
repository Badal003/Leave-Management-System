package com.example.tmpproject.service;

import com.example.tmpproject.model.Employee;
import com.example.tmpproject.repository.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepositry employeeRepositry;

    public Employee saveEmployee(Employee employee)
    {
        return employeeRepositry.save(employee);
    }
}
