package com.example.tmpproject.repository;

import com.example.tmpproject.model.Department;
import com.example.tmpproject.model.Employee;
import com.example.tmpproject.model.LeaveApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepositry extends JpaRepository<LeaveApply,Integer>
{
    public LeaveApply findById(int lt_id);
    public List<LeaveApply> findAllBy();
    public List<LeaveApply> findAllByEmployee(Employee employee);
    @Query(value = " select * from leave_apply where leave_apply.emp_id IN(select emp_id from employee where dept_id=:dept_id);",nativeQuery = true)
    public List<LeaveApply> findEmployeeLeaveByDepartment(int dept_id);
    @Query(value = " select * from leave_apply where status=:status and leave_apply.emp_id IN(select emp_id from employee where dept_id=:dept_id);",nativeQuery = true)
    public List<LeaveApply> findLeaveByDepartment(int status,int dept_id);
    @Query(value = "select count(*) from leave_apply where status=:status and leave_apply.emp_id IN(select emp_id from employee where dept_id=:dept_id);",nativeQuery = true)
    public long countBystatus(int status,int dept_id);
}
