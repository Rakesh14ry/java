import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeCRUD {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "rakesh@123";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database connected successfully!");

            // CREATE / INSERT
            String insertQuery =
                "INSERT INTO employees VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            ps.setString(3, "IT");
            ps.setDouble(4, 50000);

            ps.executeUpdate();

            System.out.println("Employee inserted successfully.");

            // READ
            String selectQuery = "SELECT * FROM employees";

            PreparedStatement select = con.prepareStatement(selectQuery);
            ResultSet rs = select.executeQuery();

            System.out.println("\nEmployee Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("employee_id") + " | " +
                    rs.getString("employee_name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary")
                );
            }

            // UPDATE
            String updateQuery =
                "UPDATE employees SET salary = ? WHERE employee_id = ?";

            PreparedStatement update = con.prepareStatement(updateQuery);

            update.setDouble(1, 55000);
            update.setInt(2, 101);

            update.executeUpdate();

            System.out.println("\nEmployee updated successfully.");

            // DELETE
            String deleteQuery =
                "DELETE FROM employees WHERE employee_id = ?";

            PreparedStatement delete = con.prepareStatement(deleteQuery);

            delete.setInt(1, 101);

            delete.executeUpdate();

            System.out.println("Employee deleted successfully.");

            // Close resources
            rs.close();
            select.close();
            update.close();
            delete.close();
            ps.close();
            con.close();

            System.out.println("Database connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}