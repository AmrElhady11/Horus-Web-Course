package com.Employees.app.repository;

import com.Employees.app.model.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
   
}
