package com.example.tmpproject.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEAVE_TYPE")
public class LeaveType {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LT_ID")
    private int leavetypeId;
    @Column(unique = true, nullable = false,name = "NAME")
    private String leaveName;
    @Column(unique = true, nullable = false,name = "DESCRIPTION")
    private String leaveDescription;
}
