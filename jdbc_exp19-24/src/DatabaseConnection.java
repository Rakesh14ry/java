import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "rakesh@123";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            System.out.println("Database connected successfully!");
            System.out.println("Connection Status: ACTIVE");
            System.out.println("Statement object created successfully!");

            stmt.close();
            con.close();

            System.out.println("Connection closed successfully!");

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}