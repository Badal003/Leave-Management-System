package com.example.tmpproject.service;

import com.example.tmpproject.model.LeaveType;

import com.example.tmpproject.repository.LeaveTypeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeService
{
    @Autowired
    private LeaveTypeRepositry leaveTypeRepositry;

    public LeaveType saveLeaveType(LeaveType leaveType){return leaveTypeRepositry.save(leaveType);}
    public LeaveType findLeaveType(int id){return leaveTypeRepositry.findById(id);}
    public List<LeaveType> findAllLeaveType(){return leaveTypeRepositry.findAllBy();}
    public LeaveType deleteLeaveType(int id){return leaveTypeRepositry.deleteById(id);}
    public Long count(){return leaveTypeRepositry.count();}
}
