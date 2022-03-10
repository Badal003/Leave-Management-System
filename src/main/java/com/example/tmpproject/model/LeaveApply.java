package com.example.tmpproject.model;

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
@Table(name = "LEAVE_APPLY")
public class LeaveApply
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LA_ID")
    private int leaveapplyId;
    @Column(name = "FROM_DATE")
    private Date fromDate;
    @Column(name = "TO_DATE")
    private Date toDate;
    @Column(name = "STATUS")
    private int status;
    //private int leavetypeId;
    @ManyToOne
    @JoinColumn(name = "LT_ID")
    private LeaveType leaveType;
    //private int employeeId;
    @OneToOne
    @JoinColumn(name = "EMP_ID")
    private Employee employee;
}
