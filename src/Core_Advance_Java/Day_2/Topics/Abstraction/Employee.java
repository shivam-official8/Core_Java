package Core_Advance_Java.Day_2.Topics.Abstraction;
//Q1: Abstract Class
//
//Create abstract class Employee with abstract method calculateSalary().
//
//Create Manager and Developer classes that extend Employee and implement calculateSalary().
//
//Test by creating objects of Manager and Developer.


public abstract class Employee {
    public abstract void calculateSalary();
    public void otherMethod(){
        System.out.println("hello");
    }
}
class Manager extends Employee{
    @Override
    public void calculateSalary() {
        System.out.println("Manager salary");
    }
}

class Developer extends Employee{
    @Override
    public void calculateSalary() {
        System.out.println("Employee Salary");
    }

    public static void main(String[] args) {
//        Employee emp = new Employee(); // error
        Manager manager = new Manager();
        manager.calculateSalary();
        Developer developer = new Developer();
        developer.calculateSalary();
    }

}
