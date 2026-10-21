import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exp28bTemperature extends Remote {

    double celsiusToFahrenheit(double celsius)
            throws RemoteException;

    double fahrenheitToCelsius(double fahrenheit)
            throws RemoteException;
}
