import java.util.Scanner;

public class EmployeePayroll {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String basic = sc.nextLine();

        System.out.print("Enter Bonus: ");
        String bonus = sc.nextLine();

        // Convert String to Wrapper Objects
        Integer empId = Integer.valueOf(id);
        Double basicSalary = Double.valueOf(basic);
        Double bonusAmount = Double.valueOf(bonus);

        // Validation
        if (basicSalary < 0 || bonusAmount < 0) {
            System.out.println("Invalid Salary or Bonus!");
        } else {
            double netSalary = basicSalary + bonusAmount;

            System.out.println("\nEmployee ID: " + empId);
            System.out.println("Basic Salary: " + basicSalary);
            System.out.println("Bonus: " + bonusAmount);
            System.out.println("Net Salary: " + netSalary);
        }

        sc.close();
    }
}