class Employee {

    String name = "Rakesh";
    double salary = 30000;

    void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: Rs. " + salary);
    }
}

class Manager extends Employee {

    String name = "Amit";
    double salary = 50000;

    void displayManager() {

        System.out.println("Manager Name: " + name);
        System.out.println("Manager Salary: Rs. " + salary);

        // Accessing parent class variables using super
        System.out.println("Employee Name: " + super.name);
        System.out.println("Employee Salary: Rs. " + super.salary);

        // Calling parent class method using super
        super.displayEmployee();
    }
}

public class EmployeeManager {

    public static void main(String[] args) {

        Manager m = new Manager();

        m.displayManager();
    }
}