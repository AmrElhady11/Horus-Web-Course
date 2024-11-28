package com.Employees.app.repository.impl;

import com.Employees.app.model.Employee;
import com.Employees.app.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepoImp implements EmployeeRepo {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public EmployeeRepoImp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public int count() {
       return jdbcTemplate.queryForObject("select count(*) from Employee",Integer.class);
    }

    @Override
    public Employee findById(Long id) {
       return jdbcTemplate.queryForObject("select * from Employee where Employee.EMPLOYEE_ID=?",new Object[] {id},
        (rs,rowNum)-> new Employee(rs.getLong("EMPLOYEE_ID"),rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getInt("salary"),rs.getString("department")
           ));
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into Employee values (?,?,?,?,?)",
                new Object[]{employee.getId(),employee.getFirstName(),
                             employee.getLastName(),employee.getSalary(),
                             employee.getDepartment()});

    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update Employee set FIRST_NAME=? , LAST_NAME=?,salary =?,department=? where EMPLOYEE_ID =?",
                new Object[]{employee.getFirstName(),
                        employee.getLastName(),employee.getSalary(),
                        employee.getDepartment(),employee.getId()});    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from Employee  where EMPLOYEE_ID =?",
                new Object[]{id});       }

    @Override
    public List<Employee> findAll() {
         return jdbcTemplate.query("select * from Employee",
                (rs,rowNum)-> new Employee(rs.getLong("EMPLOYEE_ID"),rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getInt("salary"),rs.getString("department")
                ));

    }
}
