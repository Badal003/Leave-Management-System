package com.example.tmpproject.repository;

import com.example.tmpproject.model.LeaveApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepositry extends JpaRepository<LeaveApply,Integer>
{
    public LeaveApply findById(int lt_id);
    public List<LeaveApply> findAllBy();
}
