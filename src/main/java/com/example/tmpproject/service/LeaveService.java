package com.example.tmpproject.service;

import com.example.tmpproject.model.LeaveApply;
import com.example.tmpproject.repository.LeaveRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService
{
    @Autowired
    private LeaveRepositry leaveRepositry;

    public LeaveApply saveLeave(LeaveApply leaveApply){return leaveRepositry.save(leaveApply);}
    public LeaveApply findLeave(int id){return leaveRepositry.findById(id);}
    public List<LeaveApply> findAllLeave(){return leaveRepositry.findAllBy();}
}
