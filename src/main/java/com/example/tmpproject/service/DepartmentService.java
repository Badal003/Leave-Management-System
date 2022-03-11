package com.example.tmpproject.service;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.repository.DepartmentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService
{
    @Autowired
    private DepartmentRepositry departmentRepositry;

    public Department saveDepartment(Department department)
    {
        return departmentRepositry.save(department);
    }
    public Department findByDepartment(int did)
    {
        return departmentRepositry.findById(did);
    }
    public List<Department> findAllDepartment(){return departmentRepositry.findAllBy();};

}
