package com.example.tmpproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
public class Department
{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private int departmentId;
    @Column(unique = true, nullable = false,name = "SHORTNAME")
    private String departmentShortName;
    @Column(unique = true, nullable = false,name = "FULLNAME")
    private String departmentFullName;



}


