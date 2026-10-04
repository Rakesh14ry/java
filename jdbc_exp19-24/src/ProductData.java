import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductData {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "rakesh@123";

        try {

            // Establish database connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database connected successfully!");

            // Create Statement
            Statement stmt = con.createStatement();

            // SELECT query
            String query = "SELECT * FROM products";

            // Execute SELECT query
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nProduct Details");
            System.out.println("--------------------------------");

            // Read records
            while (rs.next()) {

                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.println("Product ID   : " + id);
                System.out.println("Product Name : " + name);
                System.out.println("Quantity     : " + quantity);
                System.out.println("Price        : " + price);
                System.out.println("--------------------------------");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}