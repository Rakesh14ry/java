import java.io.*;
import java.net.*;

public class Exp27aServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(50001);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {

                System.out.print("Server: ");
                String message = keyboard.readLine();

                output.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String clientMessage = input.readLine();

                System.out.println("Client: " + clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

