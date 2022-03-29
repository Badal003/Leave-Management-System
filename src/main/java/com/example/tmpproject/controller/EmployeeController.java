package com.example.tmpproject.controller;

import com.example.tmpproject.Module.Employeemodule;
import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.Designation;
import com.example.tmpproject.model.Employee;
import com.example.tmpproject.model.UserRole;
import com.example.tmpproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
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
    public Employee AddEmployee(@RequestBody Employeemodule employeemodule) throws MessagingException, IOException {
        Employee employee=new Employee();
        employee.setFirstName(employeemodule.getFirstName());
        employee.setMiddleName(employeemodule.getMiddleName());
        employee.setLastName(employeemodule.getLastName());
        employee.setGender(employeemodule.getGender());
        employee.setEmailId(employeemodule.getEmailId());
        String password=GeneratePassword.generateRandomPassword();
        String subject="Welcome to LMS";
        String text="Hi" +employee.getFirstName()+
                "your password"+password;

        employee.setPassword(password);
        employee.setMobileNumber(employeemodule.getMobileNumber());
        employee.setDateOfBirth(employeemodule.getDateOfBirth());
        employee.setDateOfJoin(employeemodule.getDateOfJoin());
        employee.setDepartment(departmentService.findByDepartment(employeemodule.getDepartmentId()));
        employee.setDesignation(designationService.findDesination(employeemodule.getDesignationId()));
        employee.setUserRole(userRoleService.findUserRole(2));
        //employee.setPassword(GeneratePassword.generateRandomPassword());
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/findemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employeemodule FindEmployee(@RequestBody Employeemodule employeemodule)
    {
        Employeemodule employeemodule1=new Employeemodule();
        Employee employee=employeeService.findEmployee(employeemodule.getId());
        employeemodule1.setId(employee.getEmployeeId());
        employeemodule1.setFirstName(employee.getFirstName());
        employeemodule1.setMiddleName(employee.getMiddleName());
        employeemodule1.setLastName(employee.getLastName());
        employeemodule1.setGender(employee.getGender());
        employeemodule1.setEmailId(employee.getEmailId());
        employeemodule1.setPassword(GeneratePassword.generateRandomPassword());
        employeemodule1.setMobileNumber(employee.getMobileNumber());
        employeemodule1.setDateOfBirth(employee.getDateOfBirth());
        employeemodule1.setDateOfJoin(employee.getDateOfJoin());
        Designation designation=employee.getDesignation();
        Department department=employee.getDepartment();
        UserRole userRole=employee.getUserRole();
        employeemodule1.setDepartmentId(department.getDepartmentId());
        employeemodule1.setDesignationId(designation.getDesignationId());
        employeemodule1.setUserroleId(userRole.getUserroleId());
        return employeemodule1;
    }
    @PostMapping("/findallemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Employee> FindAllEmployee()
    {
        return employeeService.findAllEmployee();
    }

    @PostMapping("/updateemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee UpdateEmployee(@RequestBody Employeemodule employeemodule)
    {
        Employee employee=employeeService.findEmployee(employeemodule.getId());
        employee.setFirstName(employeemodule.getFirstName());
        employee.setMiddleName(employeemodule.getMiddleName());
        employee.setLastName(employeemodule.getLastName());
        employee.setGender(employeemodule.getGender());
        employee.setEmailId(employeemodule.getEmailId());
        employee.setMobileNumber(employeemodule.getMobileNumber());
        employee.setDateOfBirth(employeemodule.getDateOfBirth());
        employee.setDateOfJoin(employeemodule.getDateOfJoin());
        employee.setDepartment(departmentService.findByDepartment(employeemodule.getDepartmentId()));
        employee.setDesignation(designationService.findDesination(employeemodule.getDesignationId()));
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/deleteemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee DeleteEmployee(@RequestBody Employee employee)
    {
        Employee employee1=new Employee();
        employee1=employeeService.findEmployee(employee.getEmployeeId());
        employee1.setDepartment(null);
        employee1.setDesignation(null);
        employee1.setUserRole(null);
        employee1=employeeService.saveEmployee(employee1);
        return employeeService.deleteEmployee(employee1.getEmployeeId());
    }

    @PostMapping("/findemployeebydepartment")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Employee> findEmployeeByDepartment(@RequestBody Employeemodule employeemodule)
    {
        Department department=departmentService.findByDepartment(employeemodule.getDepartmentId());
        return employeeService.findEmployeeByDepartment(department);
    }

    @PostMapping("/updateEmployeeByUserrole")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee updateEmployeeByUserRole(@RequestBody Employeemodule employeemodule)
    {
        System.out.println(employeemodule);
        Employee employee=employeeService.findEmployee(employeemodule.getId());
        UserRole userRole=userRoleService.findUserRole(employeemodule.getUserroleId());
        employee.setUserRole(userRole);
        return employeeService.saveEmployee(employee);
    }


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employeemodule employeeLogin(@RequestBody Employeemodule employeemodule)
    {
        Employeemodule employeemodule1=new Employeemodule();
        System.out.println(employeemodule);
        System.out.println(employeemodule.getEmailId()+" "+employeemodule.getPassword());
        Employee employee=employeeService.findEmployeeByEmailandPassword(employeemodule.getEmailId(),employeemodule.getPassword());
        System.out.println(employee);
        employeemodule1.setId(employee.getEmployeeId());
        employeemodule1.setFirstName(employee.getFirstName());
        employeemodule1.setMiddleName(employee.getMiddleName());
        employeemodule1.setLastName(employee.getLastName());
        employeemodule1.setGender(employee.getGender());
        employeemodule1.setEmailId(employee.getEmailId());
        employeemodule1.setPassword(GeneratePassword.generateRandomPassword());
        employeemodule1.setMobileNumber(employee.getMobileNumber());
        employeemodule1.setDateOfBirth(employee.getDateOfBirth());
        employeemodule1.setDateOfJoin(employee.getDateOfJoin());
        Designation designation=employee.getDesignation();
        Department department=employee.getDepartment();
        UserRole userRole=employee.getUserRole();
        employeemodule1.setDepartmentId(department.getDepartmentId());
        employeemodule1.setDesignationId(designation.getDesignationId());
        employeemodule1.setUserroleId(userRole.getUserroleId());
        return employeemodule1;
    }
    @PostMapping("/updatepassword")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee updatePassword(@RequestBody Employeemodule employeemodule)
    {
        Employee employee=employeeService.findEmployee(employeemodule.getId());
        employee.setPassword(employeemodule.getPassword());
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/forgetpassword")
    @CrossOrigin(origins = "http://localhost:4200")
    public Employee forgetPassword(@RequestBody Employeemodule employeemodule) throws MessagingException {
        Employee employee=employeeService.findEmployeeByEmail(employeemodule.getEmailId());
        String password=GeneratePassword.generateRandomPassword();
        String subject="New Generate Password from LMS";
        String text="Hi" +employee.getFirstName()+
                "New password"+password;

        employee.setPassword(password);
        return employeeService.saveEmployee(employee);
    }
}
