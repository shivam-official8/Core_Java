package com.example.jasperdemo.service;

import com.example.jasperdemo.model.Employee;
import com.example.jasperdemo.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> allEmployees(){
        return employeeRepo.findAll();
    }
}
