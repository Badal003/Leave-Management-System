package com.example.tmpproject.model;

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
    private Date dateOfBirth;
    @Column(name = "DOJ")
    private Date dateOfJoin;

    //private int departmentId;
    @OneToOne
    @JoinColumn(name = "DEPT_ID")
    private Department department;
    //private int designationId;
    @OneToOne
    @JoinColumn(name = "DESIGN_ID")
    private Designation designation;
    //private int userroleId;
    @OneToOne
    @JoinColumn(name = "UR_ID")
    private UserRole userRole;
}
