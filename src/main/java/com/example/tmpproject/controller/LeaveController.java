package com.example.tmpproject.controller;

import com.example.tmpproject.Module.Leavemodule;
import com.example.tmpproject.Module.TempLeave;
import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.Employee;
import com.example.tmpproject.model.LeaveApply;
import com.example.tmpproject.model.LeaveType;
import com.example.tmpproject.service.DepartmentService;
import com.example.tmpproject.service.EmployeeService;
import com.example.tmpproject.service.LeaveService;
import com.example.tmpproject.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @Autowired
    private DepartmentService departmentService;

    //employee can apply a leave
    @PostMapping("/addleave")
    @CrossOrigin(origins = "http://localhost:4200")
    public LeaveApply addLeave(@RequestBody Leavemodule leavemodule)
    {
        LeaveApply leaveApply=new LeaveApply();
        leaveApply.setApplydate(CurrentDate.findCurrentDate());
        leaveApply.setFromDate(leavemodule.getFromDate());
        leaveApply.setToDate(leavemodule.getToDate());
        leaveApply.setStatus(0);
        leaveApply.setEmployee(employeeService.findEmployee(leavemodule.getEmployeeId()));
        leaveApply.setLeaveType(leaveTypeService.findLeaveType(leavemodule.getLeavetypeId()));
        return leaveService.saveLeave(leaveApply);
    }
    @PostMapping("/findallleave")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LeaveApply> findAllLeave()
    {
        return leaveService.findAllLeave();
    }
    @PostMapping("/findleave")
    @CrossOrigin(origins = "http://localhost:4200")
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
    //Hr or manager can Approved or not Approved
    @PostMapping("/applyleave")
    @CrossOrigin(origins = "http://localhost:4200")
    public LeaveApply updateLeaveStatusById(@RequestBody Leavemodule leavemodule)
    {
        LeaveApply leaveApply=null;
        leaveApply=leaveService.findLeave(leavemodule.getLeaveapplyId());
        leaveApply.setStatus(leavemodule.getStatus());
        return leaveService.saveLeave(leaveApply);
    }
    @PostMapping("/leaveofemployee")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TempLeave> findLeaveByEmployee(@RequestBody Leavemodule leavemodule)
    {
        List<LeaveApply> leaveApplies=new ArrayList<>();
        List<TempLeave> tempLeaveList=new ArrayList<>();
        Employee employee=employeeService.findEmployee(leavemodule.getEmployeeId());
        LeaveType leaveType=new LeaveType();
        leaveApplies= leaveService.findByEmployee(employee);
        for(LeaveApply e:leaveApplies)
        {
            TempLeave tempLeave=new TempLeave();
            tempLeave.setLeaveapplyId(e.getLeaveapplyId());
            tempLeave.setFromDate(e.getFromDate());
            tempLeave.setToDate(e.getToDate());
            tempLeave.setApplydate(e.getApplydate());
            tempLeave.setStatus(e.getStatus());
            employee=e.getEmployee();
            String name=employee.getFirstName()+" "+employee.getLastName();
            tempLeave.setEmployeeName(name);
            leaveType=e.getLeaveType();
            tempLeave.setLeaveName(leaveType.getLeaveName());
            tempLeaveList.add(tempLeave);
        }
        return tempLeaveList;
    }
    @PostMapping("/findemployeeleavebydepartment")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LeaveApply>findEmployeeLeaveByDepartment(@RequestBody Employee employee)
    {
        Employee employee1=new Employee();
        employee1=employeeService.findEmployee(employee.getEmployeeId());
        Department department=employee1.getDepartment();
        return leaveService.findEmployeeLeaveByDepartment(department.getDepartmentId());
    }
    @PostMapping("/findleavebydepartment")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LeaveApply> findLeaveByDepartment(@RequestBody Leavemodule leavemodule)
    {
        Employee employee1=new Employee();
        employee1=employeeService.findEmployee(leavemodule.getEmployeeId());
        Department department=employee1.getDepartment();
        return leaveService.findLeaveByDepartment(1,department.getDepartmentId());
    }
    @PostMapping("/countpendingleave")
    @CrossOrigin(origins = "http://localhost:4200")
    public long countBystatus(@RequestBody Leavemodule leavemodule)
    {
        return leaveService.countBystatus(leavemodule.getStatus());
    }
}
