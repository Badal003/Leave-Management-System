package com.example.tmpproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "TO_DATE")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(name="APPLY_DATE")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date applydate;

    @Column(name="REMARK_DATE")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date remarkdate;

    @Column(name = "STATUS")
    private int status;
    //private int leavetypeId;

    @Column(name = "REMARK")
    private String remark;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "LT_ID",referencedColumnName = "LT_ID")
    private LeaveType leaveType;
    //private int employeeId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID",referencedColumnName = "EMP_ID")
    private Employee employee;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "MGR_ID",referencedColumnName = "EMP_ID")
    private Employee manager;

}
