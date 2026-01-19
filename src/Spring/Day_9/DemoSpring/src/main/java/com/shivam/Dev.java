package com.shivam;



public class Dev {

    private Computer computer;
//private int age;

    public Dev(){

        System.out.println("Dev Constructor");
    }
//    public Dev(int age) {
//        this.age = age;
//        System.out.println("Dev 1 constructor");
//    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//        System.out.println("constructor injection");
//    }


    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void build(){
//        System.out.println();
        System.out.println("Building awesome project! ");
        computer.compile();
    }
}
