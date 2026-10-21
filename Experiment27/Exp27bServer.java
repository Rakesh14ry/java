import java.io.*;
import java.net.*;
public class Exp27bServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6000);

            System.out.println("Echo Server started...");
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String message;

            while ((message = input.readLine()) != null) {

                System.out.println("Client: " + message);

                output.println(message);

                if (message.equalsIgnoreCase("exit")) {
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
