package com.shivam.employeemanagement.service;

import com.shivam.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("shivam", 20, 200000),
            new Employee("rahul", 21, 100000),
            new Employee("john", 22, 562200)));

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public Employee getEmployeeById(int empId) {
        return employees.stream().filter(e->e.getEmpId()==empId).findFirst().orElse(new Employee("No Such Employee", -1, -1));

    }

    public void updateEmployee(Employee employee) {
        int index = -1;
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getEmpId()==employee.getEmpId()){
                index = i;
                break;
            }
        }
        employees.set(index, employee);
    }
    public void deleteEmployee(int empId){
        int index = -1;
        for(int i = 0; i<employees.size(); i++){
            if(employees.get(i).getEmpId()==empId){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("No such employee with employee id: "+ empId);
        }else{
            employees.remove(index);
        }
    }
}


