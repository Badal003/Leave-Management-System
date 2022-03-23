package com.example.tmpproject.controller;

import com.example.tmpproject.model.LeaveType;
import com.example.tmpproject.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaveTypeController
{
    @Autowired
    private LeaveTypeService leaveTypeService;

    @PostMapping("/addleavetype")
    @CrossOrigin(origins = "http://localhost:4200")
    public LeaveType AddLeaveType(@RequestBody LeaveType leaveType)
    {
        return leaveTypeService.saveLeaveType(leaveType);
    }

    //Update Leave Type
    @PostMapping("/updateleavetype")
    @CrossOrigin(origins = "http://localhost:4200")
    public LeaveType UpdateLeaveType(@RequestBody LeaveType leaveType)
    {
        LeaveType leaveType1=leaveTypeService.findLeaveType(leaveType.getLeavetypeId());
        leaveType1.setLeaveName(leaveType.getLeaveName());
        leaveType1.setLeaveDescription(leaveType.getLeaveDescription());
        return leaveTypeService.saveLeaveType(leaveType1);
    }

    //Find LeaveType By LeaveType ID
    @PostMapping("/findleavetype")
    @CrossOrigin(origins = "http://localhost:4200")
    public LeaveType findLeaveType(@RequestBody LeaveType leaveType)
    {
        return leaveTypeService.findLeaveType(leaveType.getLeavetypeId());
    }

    //All LeaveTypes Show
    @PostMapping("/displayallleavetype")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LeaveType> DisplayLeaveTypes()
    {
        return leaveTypeService.findAllLeaveType();
    }

    //Delete LeaveType By LeaveTypeID
    @PostMapping("/deleteleavetype")
    @CrossOrigin(origins = "http://localhost:4200")
    public LeaveType deleteLeaveType(@RequestBody LeaveType leaveType)
    {
        return leaveTypeService.deleteLeaveType(leaveType.getLeavetypeId());
    }

    //Count of LeaveTypes
    @PostMapping("/deshboardleave")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long leavetypeCount()
    {
        return leaveTypeService.count();
    }
}
