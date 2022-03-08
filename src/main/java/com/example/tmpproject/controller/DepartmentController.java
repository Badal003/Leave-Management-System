package com.example.tmpproject.controller;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department AddDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

}