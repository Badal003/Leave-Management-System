package com.example.tmpproject.controller;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.Designation;
import com.example.tmpproject.model.Employee;
import com.example.tmpproject.model.UserRole;
import com.example.tmpproject.service.DepartmentService;
import com.example.tmpproject.service.DesignationService;
import com.example.tmpproject.service.EmployeeService;
import com.example.tmpproject.service.UserRoleService;
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
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DesignationService designationService;
    @Autowired
    private UserRoleService userRoleService;
    @PostMapping("/addEmployee")
    public Employee AddEmployee(@RequestBody Employee employee)
    {
        employee.setPassword(GeneratePassword.generateRandomPassword());
        employee.setDepartment(departmentService.findByDepartment(1));
        employee.setDesignation(designationService.findDesination(3));
        employee.setUserRole(userRoleService.findUserRole(1));
        return employeeService.saveEmployee(employee);
    }

}
