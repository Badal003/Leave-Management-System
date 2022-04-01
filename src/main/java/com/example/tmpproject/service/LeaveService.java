package com.example.tmpproject.service;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.Employee;
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
    public List<LeaveApply> findByEmployee(Employee employee){return leaveRepositry.findAllByEmployee(employee);}
    public List<LeaveApply>findEmployeeLeaveByDepartment(int dept_id){return leaveRepositry.findEmployeeLeaveByDepartment(dept_id);}
    public List<LeaveApply> findLeaveByDepartment(int status,int dept_id){return  leaveRepositry.findLeaveByDepartment(status,dept_id);}
    public long countBystatus(int s,int dept_id){return  leaveRepositry.countBystatus(s,dept_id);}
}
