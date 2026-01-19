package com.shivam.employeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@AllArgsConstructor
@Data
@Component
public class Employee {
    private String empName;
    private int empId;
    private int empSalary;

    public Employee() {
    }
}
