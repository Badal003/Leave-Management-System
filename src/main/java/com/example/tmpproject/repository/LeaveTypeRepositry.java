package com.example.tmpproject.repository;

import com.example.tmpproject.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LeaveTypeRepositry extends JpaRepository<LeaveType,Integer>
{
    public LeaveType findById(int lt_id);
    public List<LeaveType> findAllBy();
    public LeaveType deleteById(int lt_id);
}
