package com.shivam.employeemanagement.controller;

import com.shivam.employeemanagement.model.Employee;
import com.shivam.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployes(){
        return service.getEmployee();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployee(@PathVariable int empId){
        return service.getEmployeeById(empId);
    }

    @PutMapping("/products")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    // name in url should be same as name in method parameter or else we need to write @PathVariable("new_name")
    @DeleteMapping("/products/{empId}")
    public void deleteEmployee(@PathVariable int empId){
        service.deleteEmployee(empId);
    }


}
