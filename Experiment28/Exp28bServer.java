import java.rmi.Naming;

public class Exp28bServer {

    public static void main(String[] args) {

        try {

            Exp28bTemperature temperature =
                    new Exp28bTemperatureImpl();

            Naming.rebind("Temperature", temperature);

            System.out.println(
                    "Temperature RMI Server started..."
            );

        } catch (Exception e) {

            System.out.println(
                    "Server Error: " + e
            );
        }
    }
}
