package com.example.jasperdemo.controller;

import com.example.jasperdemo.model.Employee;
import com.example.jasperdemo.service.EmployeeService;
import com.example.jasperdemo.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    private ReportService reportService;

    public EmployeeController(EmployeeService employeeService, ReportService reportService) {
        this.employeeService = employeeService;
        this.reportService = reportService;
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> allEmployees(){
        return employeeService.allEmployees();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
