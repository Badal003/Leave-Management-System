package com.example.tmpproject.repository;

import com.example.tmpproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositry extends JpaRepository<Department,Integer>
{
}
