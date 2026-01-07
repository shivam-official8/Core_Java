package Day_2.Topics.Access_Specifiers;

// Create a class with:
//
//one private variable
//
//one public method to access it
//Demonstrate encapsulation.

public class Employee {
    private String email;
    int age=24;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
 class softwareDeveloper extends Employee{
    public static void main(String[] args) {
        Employee employee = new softwareDeveloper();
        employee.setEmail("shivam@gmail.com");
        System.out.println(employee.getEmail());

    }
}
