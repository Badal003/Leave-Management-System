package com.example.tmpproject.controller;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/adddepartment")
    @CrossOrigin(origins = "http://localhost:4200")
    public Department AddDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }
    @PostMapping("/updatedepartment")
    public Department UpdateDepartment(@RequestBody Department department)
    {
        Department department1=departmentService.findByDepartment(department.getDepartmentId());
        department1.setDepartmentFullName(department.getDepartmentFullName());
        department1.setDepartmentShortName(department.getDepartmentShortName());
        return departmentService.saveDepartment(department1);
   }
   @PostMapping("/displayalldepartment")
   public List<Department> DisplayDepartments()
   {
       return departmentService.findAllDepartment();
   }
}
