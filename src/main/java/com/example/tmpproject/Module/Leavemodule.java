package com.example.tmpproject.Module;

import lombok.Data;

import java.util.Date;

@Data
public class Leavemodule
{
    private int leaveapplyId;
    private Date fromDate;
    private Date toDate;
    private Date applydate;
    private int status;
    private int leavetypeId;
    private int employeeId;
    private int managerId;
}
