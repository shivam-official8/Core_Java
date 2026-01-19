package Core_Advance_Java.Day_2.Topics.Encapsulation;

// Q4: Combining Inheritance + Encapsulation
//
//Class Employee → private field salary, public getter/setter
//
//Subclass Manager → method bonus() uses getSalary() for calculation.
//
//Demonstrate access to private field only through getter.

public class Employee {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class Manager extends Employee{
    public void bonus(){
        System.out.println("Manager bonus: "+((getSalary()*0.5)));
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setSalary(50000);
        manager.bonus();
    }
}