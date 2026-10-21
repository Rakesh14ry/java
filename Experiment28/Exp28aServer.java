import java.rmi.Naming;

public class Exp28aServer {

    public static void main(String[] args) {

        try {

            Exp28aCalculatorImpl calculator =
                    new Exp28aCalculatorImpl();

            Naming.rebind("Calculator", calculator);

            System.out.println("Calculator RMI Server started...");

        } catch (Exception e) {

            System.out.println("Server Error: " + e);
        }
    }
}
