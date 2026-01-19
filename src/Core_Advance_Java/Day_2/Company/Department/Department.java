package Core_Advance_Java.Day_2.Company.Department;
import Core_Advance_Java.Day_2.Company.Employee.Employee;

public class Department {
    public int dept_id;
    public String dept_name;
    public Employee dept_manager;
    public Employee[] dept_employees;

    public Department(int dept_id, String dept_name, Employee dept_manager, Employee[] dept_employees){
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.dept_manager = dept_manager;
        this.dept_employees = dept_employees;
    }
}
