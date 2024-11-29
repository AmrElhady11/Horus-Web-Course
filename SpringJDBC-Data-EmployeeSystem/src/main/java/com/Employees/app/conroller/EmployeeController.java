package com.Employees.app.conroller;

import com.Employees.app.model.Employee;
import com.Employees.app.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeController(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    @GetMapping("/count")
    public Long countEmployees(){
        return employeeRepo.count();
    }
    @GetMapping("/employee")
    public Optional<Employee> findEmployee(@RequestParam Long id){
        return employeeRepo.findById(id);
    }
    @GetMapping("/allEmployee")
    public Iterable<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    @PostMapping("/update")
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
         employeeRepo.deleteById(id);
    }
}
