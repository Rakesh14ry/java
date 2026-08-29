import java.util.Scanner;

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class DrivingLicenseSystem {

    static void checkEligibility(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException(
                "Age must be 18 or above to apply for a driving license."
            );
        }

        System.out.println("You are eligible for a driving license.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkEligibility(age);
        }
        catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}