import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {

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

            String query = "SELECT * FROM students";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n===== STUDENT RECORDS =====");

            while (rs.next()) {

                System.out.println("Student ID   : "
                        + rs.getInt("student_id"));

                System.out.println("Student Name : "
                        + rs.getString("student_name"));

                System.out.println("Student Mark : "
                        + rs.getInt("student_mark"));

                System.out.println("---------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}