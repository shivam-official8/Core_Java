package com.example.spring_security.model;

public class Student {
    public Integer studentId;
    public String name;
    public Integer marks;

//    public Student(){}

    public Student(Integer id, String n, Integer m){
        studentId=id;
        name=n;
        marks=m;
    }
//    public String toString(){
//        return "student"
//    }
}
