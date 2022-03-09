package com.example.tmpproject.repository;

import com.example.tmpproject.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepositry extends JpaRepository<Designation,Integer>
{
}
