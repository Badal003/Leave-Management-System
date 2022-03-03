package com.example.tmpproject.repository;

import com.example.tmpproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee,Integer>
{

}
