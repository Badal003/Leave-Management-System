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
    //Insert Department
    @PostMapping("/adddepartment")
    @CrossOrigin(origins = "http://localhost:4200")
    public Department AddDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    //Update Department
    @PostMapping("/updatedepartment")
    @CrossOrigin(origins = "http://localhost:4200")
    public Department UpdateDepartment(@RequestBody Department department)
    {
        Department department1=departmentService.findByDepartment(department.getDepartmentId());
        department1.setDepartmentFullName(department.getDepartmentFullName());
        department1.setDepartmentShortName(department.getDepartmentShortName());
        return departmentService.saveDepartment(department1);
   }

   //Find Department By Department ID
   @PostMapping("/finddepartment")
   @CrossOrigin(origins = "http://localhost:4200")
   public Department findDepartment(@RequestBody Department department)
   {
       return departmentService.findByDepartment(department.getDepartmentId());
   }

   //All Departments Show
   @PostMapping("/displayalldepartment")
   @CrossOrigin(origins = "http://localhost:4200")
   public List<Department> DisplayDepartments()
   {
       return departmentService.findAllDepartment();
   }

   //Delete Department By DepartmentID
   @PostMapping("/deletedepartment")
   @CrossOrigin(origins = "http://localhost:4200")
   public Department deleteDepartment(@RequestBody Department department)
   {
       return departmentService.deleteDepartmentById(department.getDepartmentId());
   }

   //Count of Departments
   @PostMapping("/deshboard")
   @CrossOrigin(origins = "http://localhost:4200")
   public Long departmentCount()
   {
       return departmentService.count();
   }
}
