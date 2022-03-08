package com.example.tmpproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEAVE_TYPE")
public class LeaveType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LT_ID")
    private int leavetypeId;
    @Column(name = "NAME")
    private String leaveName;
    @Column(name = "DESCRIPTION")
    private String leaveDescription;
    @Column(name = "DAYS_ALLOWED")
    private int leaveDaysAllowed;
}
