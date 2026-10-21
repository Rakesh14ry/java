import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Exp28aCalculatorImpl
        extends UnicastRemoteObject
        implements Exp28aCalculator {

    public Exp28aCalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {

        if (b == 0) {
            return 0;
        }

        return (double) a / b;
    }
}
