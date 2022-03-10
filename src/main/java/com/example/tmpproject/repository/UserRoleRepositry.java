package com.example.tmpproject.repository;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepositry extends JpaRepository<UserRole,Integer>
{
    public UserRole findById(int ur_id);
}
