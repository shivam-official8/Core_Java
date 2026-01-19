package Core_Advance_Java.Day_4.Collection_Framework_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
        int id;
        String name;
        double salary;
        public Employee(int id, String name, double salry){
            this.id = id;
            this.name = name;
            this.salary = salry;
        }
        @Override
        public String toString() {
        return "Id: "+id+" Name: "+name+" Salary: "+salary;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(3,"shivam", 23112);
        Employee e2 = new Employee(2,"bhivam1", 4653);
        Employee e3 = new Employee(1,"ahivam2", 245563);
        Employee e4 = new Employee(4,"sbivam3", 3554);
        Employee e5 = new Employee(5,"chivam4", 455);
        Department dep1 = new Department("SDE1", 2);
        Department dep2 = new Department("SDE2", 1);
        Department dep3 = new Department("SDE3", 3);
        dep1.employees.add(e1);
        dep1.employees.add(e2);
        dep2.employees.add(e3);
        dep3.employees.add(e4);
        dep3.employees.add(e5);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.sort((em1, em2)->(int)(em1.salary-em2.salary));

        for(Employee e : employees){
            System.out.println(e.toString());
        }

        employees.sort((em1, em2)->em1.name.compareTo(em2.name));

        for(Employee e : employees){
            System.out.println(e.toString());
        }
        employees.sort((em1, em2)->(int)(em2.salary-em1.salary));
        System.out.println("Highest Paid: "+employees.get(0).toString());

        for(Employee e : employees){
            if(e.salary<30000.0)employees.remove(e);
        }
        Map<Department, List<Employee>> dep_employ = new HashMap<>();
        dep_employ.put(dep1, dep1.employees);
        dep_employ.put(dep2, dep2.employees);
        dep_employ.put(dep3, dep3.employees);
    }
}
class Department{
    int deptId;
    String deptName;
    List<Employee> employees;

    public Department(String deptName, int deptId) {
        this.deptName = deptName;
        this.deptId = deptId;
    }
    @Override
    public String toString() {
        return "Id: "+deptId+" Name: "+deptName+" Employees: "+employees;
    }

}
