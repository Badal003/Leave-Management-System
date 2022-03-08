package com.example.tmpproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private int departmentId;
    @Column(name = "SHORTNAME")
    private String departmentShortName;
    @Column(name = "FULLNAME")
    private String departmentFullName;
}


