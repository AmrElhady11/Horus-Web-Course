package com.Employees.app.repository;

import com.Employees.app.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    int count();
    Employee findById(Long id);
    int insert(Employee employee);
    int update(Employee employee);
    int delete(Long id);
    List<Employee> findAll();

}
