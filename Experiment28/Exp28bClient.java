import java.rmi.Naming;
import java.util.Scanner;

public class Exp28bClient {

    public static void main(String[] args) {

        try {

            Exp28bTemperature temperature =
                    (Exp28bTemperature)
                    Naming.lookup(
                        "rmi://localhost/Temperature"
                    );

            Scanner sc = new Scanner(System.in);

            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            System.out.print("Enter temperature: ");
            double value = sc.nextDouble();

            if (choice == 1) {

                double result =
                        temperature.celsiusToFahrenheit(value);

                System.out.println(
                        value + " Celsius = "
                        + result + " Fahrenheit"
                );

            } else if (choice == 2) {

                double result =
                        temperature.fahrenheitToCelsius(value);

                System.out.println(
                        value + " Fahrenheit = "
                        + result + " Celsius"
                );

            } else {

                System.out.println("Invalid choice.");
            }

            sc.close();

        } catch (Exception e) {

            System.out.println(
                    "Client Error: " + e
            );
        }
    }
}
