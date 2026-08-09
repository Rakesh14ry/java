interface Printable {

    void printDetails();
}

// Student class
class Student implements Printable {

    String name = "Rakesh";
    int rollNo = 101;

    public void printDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}

// Employee class
class Employee implements Printable {

    String name = "Amit";
    int employeeId = 501;

    public void printDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

public class PrintableApplication {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println("Student Details:");
        s.printDetails();

        System.out.println();

        Employee e = new Employee();

        System.out.println("Employee Details:");
        e.printDetails();
    }
}