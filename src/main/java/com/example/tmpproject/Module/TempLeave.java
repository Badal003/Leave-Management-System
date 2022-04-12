package com.example.tmpproject.Module;

import lombok.Data;

import java.util.Date;

@Data
public class TempLeave {
    private int leaveapplyId;
    private Date fromDate;
    private Date toDate;
    private Date applydate;
    private int status;
    private String remark;
    private Date remarkdate;
    private String leaveName;
    private String employeeName;
    private String managerName;
}
