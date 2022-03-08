package com.example.tmpproject.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RoleAllocation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RA_ID")
    private int roleallocationId;
    private int employeeId;
    private int userroleId;
}
