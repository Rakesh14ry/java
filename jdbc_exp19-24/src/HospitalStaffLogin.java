import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalStaffLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "rakesh@123";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database connected successfully!");

            System.out.print("Enter Login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = sc.nextLine();

            String query =
                "SELECT staff_name, role FROM hospital_staff " +
                "WHERE login_id = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, loginId);
            ps.setString(2, loginPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String staffName = rs.getString("staff_name");
                String role = rs.getString("role");

                System.out.println("Login successful!");
                System.out.println("Staff Name: " + staffName);
                System.out.println("Role: " + role);

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println(
                        "Access Granted: Doctor Dashboard"
                    );
                } 
                else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println(
                        "Access Granted: Nurse Dashboard"
                    );
                }

            } else {
                System.out.println(
                    "Access Denied: Invalid Login ID or Password!"
                );
            }

            rs.close();
            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}