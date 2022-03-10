package com.example.tmpproject.repository;

import com.example.tmpproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepositry extends JpaRepository<Department,Integer>
{
    public Department findById(int dest_id);

}
