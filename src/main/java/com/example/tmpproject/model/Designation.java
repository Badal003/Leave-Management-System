package com.example.tmpproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DESIGNATION")
public class Designation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESIGN_ID")
    private int designationId;
    @Column(name = "NAME")
    private String designationName;
    @Column(name = "DESCRIPTION")
    private String designationDescription;
}
