package Core_Advance_Java.Day_3.Questions.OOP;
// 🔹 Question 2 — Interface + default + private helper
//
//Create an interface Printer:
//
//default method printHeader() calls a private method header()
//
//private method header() prints "Header"
//
//abstract method printContent()
//
//Create class Document implementing Printer and implement printContent().
//
//Call printHeader() and printContent() in main().

public interface Printer {
    private  void header(){
        System.out.println("header");
    }
    default void printheader(){
        header();
    }
    public void printcontent();
}
class Document implements Printer{
   public void printcontent(){
       System.out.println("content");
    }

    public static void main(String[] args) {
        Printer printer = new Document();
        printer.printheader();
        printer.printcontent();
    }
}
