import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeResultSet {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "rakesh@123";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database connected successfully!");

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM employees";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n===== EMPLOYEE RECORDS =====");

            while (rs.next()) {

                System.out.println("Employee ID : "
                        + rs.getInt("employee_id"));

                System.out.println("Name        : "
                        + rs.getString("employee_name"));

                System.out.println("Department  : "
                        + rs.getString("department"));

                System.out.println("Salary      : "
                        + rs.getDouble("salary"));

                System.out.println("----------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}