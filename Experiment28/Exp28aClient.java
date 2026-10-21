import java.rmi.Naming;
import java.util.Scanner;

public class Exp28aClient {

    public static void main(String[] args) {

        try {

            Exp28aCalculator calculator =
                    (Exp28aCalculator)
                    Naming.lookup("rmi://localhost/Calculator");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition: "
                    + calculator.add(a, b));

            System.out.println("Subtraction: "
                    + calculator.subtract(a, b));

            System.out.println("Multiplication: "
                    + calculator.multiply(a, b));

            System.out.println("Division: "
                    + calculator.divide(a, b));

            sc.close();

        } catch (Exception e) {

            System.out.println("Client Error: " + e);
        }
    }
}
