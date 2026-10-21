import java.io.*;
import java.net.*;

public class Exp27bClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 6000);

            System.out.println("Connected to Echo Server!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter message: ");

                String message = keyboard.readLine();

                output.println(message);

                String response = input.readLine();

                System.out.println("Server Echo: " + response);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
