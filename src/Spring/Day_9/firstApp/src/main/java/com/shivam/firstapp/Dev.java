package com.shivam.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    // autowired searched by type

    // Field Injection
   // @Autowired
//    private Laptop laptop;

    // after loose coupling
    @Autowired // behind the scenes it will do dmd parent p = new child() and it is a good practice to use loose coupling
// if parent has more then 1 child then we get error (required a single bean, but 2 were found)
    // so to prevent it:
    // 1. only put component on one child class
    // 2. add @Primary on any one if both are component
    // 3. @Qualifier("desktop") the name inside is the clasname in lowercase and this annotation should be used where injection is happening

    private Computer computer;

    // constructor injection (dont need to write autowired it writes by default)
    // if constructor has any other data type like int string or any class obj which is not a component
    // then it will give error
//    public Dev(Laptop laptop){
////        this.laptop = laptop;
//    }

    // setter injection
//    @Autowired // have to write autowired explicitly
//    public void setLaptop(Laptop laptop){
////        this.laptop = laptop;
//    }

    public void build(){
        computer.compile();
        System.out.println("Building awesome project! ");
    }
}
