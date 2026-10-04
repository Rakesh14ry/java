import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentCRUD {

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

            while (true) {

                System.out.println("\n===== STUDENT CRUD MENU =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                
                // INSERT
                

                if (choice == 1) {

                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    String query =
                        "INSERT INTO student_crud VALUES (?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setInt(1, rollNo);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.setDouble(4, marks);

                    ps.executeUpdate();

                    System.out.println("Student inserted successfully!");

                    ps.close();
                }

                
                // READ
                

                else if (choice == 2) {

                    String query = "SELECT * FROM student_crud";

                    PreparedStatement ps =
                        con.prepareStatement(query);

                    ResultSet rs = ps.executeQuery();

                    System.out.println("\n===== STUDENT RECORDS =====");

                    while (rs.next()) {

                        System.out.println(
                            "Roll No : " + rs.getInt("roll_no")
                        );

                        System.out.println(
                            "Name    : " + rs.getString("name")
                        );

                        System.out.println(
                            "Course  : " + rs.getString("course")
                        );

                        System.out.println(
                            "Marks   : " + rs.getDouble("marks")
                        );

                        System.out.println("---------------------------");
                    }

                    rs.close();
                    ps.close();
                }

                
                // UPDATE
               

                else if (choice == 3) {

                    System.out.print("Enter Roll No to update: ");
                    int rollNo = sc.nextInt();

                    System.out.print("Enter new Marks: ");
                    double marks = sc.nextDouble();

                    String query =
                        "UPDATE student_crud SET marks = ? WHERE roll_no = ?";

                    PreparedStatement ps =
                        con.prepareStatement(query);

                    ps.setDouble(1, marks);
                    ps.setInt(2, rollNo);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println(
                            "Student updated successfully!"
                        );
                    } else {
                        System.out.println(
                            "Student not found!"
                        );
                    }

                    ps.close();
                }

                
                // DELETE
                

                else if (choice == 4) {

                    System.out.print("Enter Roll No to delete: ");
                    int rollNo = sc.nextInt();

                    String query =
                        "DELETE FROM student_crud WHERE roll_no = ?";

                    PreparedStatement ps =
                        con.prepareStatement(query);

                    ps.setInt(1, rollNo);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println(
                            "Student deleted successfully!"
                        );
                    } else {
                        System.out.println(
                            "Student not found!"
                        );
                    }

                    ps.close();
                }

               
                // EXIT
                

                else if (choice == 5) {

                    System.out.println("Program ended.");

                    con.close();
                    sc.close();

                    break;
                }

                else {
                    System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}