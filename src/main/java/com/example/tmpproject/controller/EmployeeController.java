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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/addemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee AddEmployee(@RequestBody Employee employee)
    {
        employee.setPassword(GeneratePassword.generateRandomPassword());
//        employee.setDepartment(departmentService.findByDepartment(17));
//        employee.setDesignation(designationService.findDesination(2));
//        employee.setUserRole(userRoleService.findUserRole(2));
        System.out.println(employee.getDepartment());
        System.out.println(employee.getDesignation());
        System.out.println(employee.getUserRole());
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/findemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee FindEmployee(@RequestBody Employee employee){return employeeService.findEmployee(employee.getEmployeeId());}
    @PostMapping("/findallemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Employee> FindAllEmployee(){return employeeService.findAllEmployee();}
    @PostMapping("/updateemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee UpdateEmployee(@RequestBody Employee employee)
    {
        Employee employee1=employeeService.findEmployee(employee.getEmployeeId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setMiddleName(employee.getMiddleName());
        employee1.setLastName(employee.getLastName());
        employee1.setGender(employee.getGender());
        employee1.setMobileNumber(employee.getMobileNumber());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        employee1.setDateOfJoin(employee.getDateOfJoin());
        employee1.setDepartment(employee.getDepartment());
        employee1.setDesignation(employee.getDesignation());
        employee1.setUserRole(employee.getUserRole());
        return employeeService.saveEmployee(employee1);
    }
    @PostMapping("/deleteemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee DeleteEmployee(@RequestBody Employee employee){return employeeService.deleteEmployee(employee.getEmployeeId());}
}
