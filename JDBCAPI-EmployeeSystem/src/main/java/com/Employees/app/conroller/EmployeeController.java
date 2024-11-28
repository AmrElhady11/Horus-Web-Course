package com.Employees.app.conroller;

import com.Employees.app.model.Employee;
import com.Employees.app.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public int countEmployees(){
        return employeeRepo.count();
    }
    @GetMapping("/employee")
    public Employee findEmployee(@RequestParam Long id){
        return employeeRepo.findById(id);
    }
    @GetMapping("/allEmployee")
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    @PostMapping("/update")
    public int updateEmployee(Employee employee){
        return employeeRepo.update(employee);
    }
    @GetMapping("/delete/{id}")
    public int deleteEmployee(@PathVariable Long id){
        return employeeRepo.delete(id);
    }
}
