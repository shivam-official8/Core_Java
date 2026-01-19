package com.shivam.firstapp;

import org.springframework.stereotype.Component;

@Component
// loose coupling
public class Laptop implements Computer {
    public void compile(){
        System.out.println("Compiling with 404 bugs...");
    }
}
