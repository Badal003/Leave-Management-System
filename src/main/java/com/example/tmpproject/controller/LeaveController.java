package com.example.tmpproject.controller;

import com.example.tmpproject.Module.Leavemodule;
import com.example.tmpproject.model.Employee;
import com.example.tmpproject.model.LeaveApply;
import com.example.tmpproject.model.LeaveType;
import com.example.tmpproject.service.EmployeeService;
import com.example.tmpproject.service.LeaveService;
import com.example.tmpproject.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaveController
{
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveTypeService leaveTypeService;

    public LeaveApply addLeave(@RequestBody Leavemodule leavemodule)
    {
        LeaveApply leaveApply=null;
        leaveApply.setApplydate(CurrentDate.findCurrentDate());
        leaveApply.setFromDate(leavemodule.getFromDate());
        leaveApply.setToDate(leavemodule.getToDate());
        leaveApply.setStatus(leavemodule.getStatus());
        leaveApply.setEmployee(employeeService.findEmployee(leavemodule.getEmployeeId()));
        leaveApply.setLeaveType(leaveTypeService.findLeaveType(leavemodule.getLeaveapplyId()));
        return leaveService.saveLeave(leaveApply);
    }
    public List<LeaveApply> findAllLeave()
    {
        return leaveService.findAllLeave();
    }
    public Leavemodule findLeaveByID(@RequestBody Leavemodule leavemodule)
    {
        Leavemodule leavemodule1=null;
        LeaveApply leaveApply=leaveService.findLeave(leavemodule.getLeaveapplyId());
        leavemodule1.setLeaveapplyId(leaveApply.getLeaveapplyId());
        leavemodule1.setApplydate(leaveApply.getApplydate());
        leavemodule1.setFromDate(leaveApply.getFromDate());
        leavemodule1.setToDate(leaveApply.getToDate());
        leavemodule1.setStatus(leaveApply.getStatus());
        Employee employee=leaveApply.getEmployee();
        leavemodule1.setEmployeeId(employee.getEmployeeId());
        LeaveType leaveType=leaveApply.getLeaveType();
        leavemodule1.setLeavetypeId(leaveType.getLeavetypeId());
        return leavemodule1;
    }
    public LeaveApply updateLeaveStatusById(Leavemodule leavemodule)
    {
        LeaveApply leaveApply=null;
        leaveApply=leaveService.findLeave(leavemodule.getLeaveapplyId());
        leaveApply.setStatus(leavemodule.getStatus());
        return leaveService.saveLeave(leaveApply);
    }
}
