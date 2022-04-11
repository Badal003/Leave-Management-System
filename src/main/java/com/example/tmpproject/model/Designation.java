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
@Table(name = "DESIGNATION")
public class Designation {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESIGN_ID")
    private int designationId;
    @Column(name = "NAME")
    private String designationName;
    @Column(name = "DESCRIPTION")
    private String designationDescription;

}
