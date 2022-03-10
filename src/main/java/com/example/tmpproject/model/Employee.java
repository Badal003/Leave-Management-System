package com.example.tmpproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee
{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private int employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String emailId;
    @Column(name = "MOBILENO")
    private long mobileNumber;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "DOB")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "DOJ")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoin;

    //private int departmentId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID",referencedColumnName = "DEPT_ID")
    private Department department;
    //private int designationId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DESIGN_ID",referencedColumnName = "DESIGN_ID")
    private Designation designation;
    //private int userroleId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "UR_ID",referencedColumnName = "UR_ID")
    private UserRole userRole;
}
