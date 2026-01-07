package Day_2.Company.Employee;

import Day_2.Company.Department.Department;

import java.util.Scanner;


public class Employee {
    public Scanner sc = new Scanner(System.in);
    public final int tax_percentage = 15;
    public double salary;
    public String name;
    private String email;
    public int age;
    public Department department;
    public static int id;


    public Employee(final String name, final int age, final String email, final double salary, Department department){
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.department = department;

    }
    public void edit_details(){
        boolean no_exit = true;
        while(no_exit){
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Age");
            System.out.println("3. Edit Salary");
//            System.out.println("4. Edit Department");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1-> edit_name();
                case 2-> edit_age();
                case 3-> edit_salary();
                case 4-> no_exit=false;
            }
        }
    }

    public void edit_name(){
        System.out.print("Enter new Name: ");
        String new_name = sc.nextLine();
        System.out.print("Are you sure to change name from "+ this.name+" to "+new_name+" (Y/N) ?");
        String confirmation = sc.next();
        if(confirmation.equalsIgnoreCase("y")){
            this.name = new_name;
            System.out.println("Name changed successfully!");
        }else if(confirmation.equalsIgnoreCase("n"))return;
        else System.out.println("Invalid Input!");


    }

    public void edit_age(){
        System.out.print("Enter new Age: ");
        int new_age = sc.nextInt();
        System.out.print("Are you sure to change age from "+ this.age+" to "+new_age+" (Y/N) ?");
        String confirmation = sc.next();
        if(confirmation.equalsIgnoreCase("y")){
            this.age = new_age;
            System.out.println("Age changed successfully!");
        }else if(confirmation.equalsIgnoreCase("n"))return;
        else System.out.println("Invalid Input!");
    }

    public void edit_salary(){
        System.out.print("Enter new Age: ");
        double new_salary = sc.nextDouble();
        System.out.print("Are you sure to change salary from "+ this.salary+" to "+new_salary+" (Y/N) ?");
        String confirmation = sc.next();
        if(confirmation.equalsIgnoreCase("y")){
            this.salary = new_salary;
            System.out.println("Salary changed successfully!");
        }else if(confirmation.equalsIgnoreCase("n"))return;
        else System.out.println("Invalid Input!");
    }



}
