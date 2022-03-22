package com.example.tmpproject.service;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.Employee;
import com.example.tmpproject.repository.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepositry employeeRepositry;

    public Employee saveEmployee(Employee employee){return employeeRepositry.save(employee);}
    public Employee findEmployee(int id){return employeeRepositry.findById(id);}
    public List<Employee> findAllEmployee(){return employeeRepositry.findAllBy();}
    public Employee deleteEmployee(int id){return employeeRepositry.deleteById(id);}
    public Long count(){return employeeRepositry.count();}
    public List<Employee> findEmployeeByDepartment(Department department){return employeeRepositry.findByDepartment(department);}
}
