import java.io.*;
import java.net.*;
public class Exp27aClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 50001);

            System.out.println("Connected to server!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));
            while (true) {
                String serverMessage = input.readLine();

                System.out.println("Server: " + serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Client: ");
                String message = keyboard.readLine();

                output.println(message);

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
