import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {

    JTextField bookIdField;
    JTextField studentField;
    JTextField issueDateField;
    JTextField returnDateField;
    JTextArea outputArea;

    String url = "jdbc:mysql://localhost:3306/college";
    String username = "root";
    String password = "rakesh@123";

    BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(550, 550);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Book ID:"));
        bookIdField = new JTextField(20);
        add(bookIdField);

        add(new JLabel("Student Name:"));
        studentField = new JTextField(20);
        add(studentField);

        add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField(20);
        add(issueDateField);

        add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField(20);
        add(returnDateField);

        JButton addButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View Records");
        JButton deleteButton = new JButton("Delete Record");

        add(addButton);
        add(viewButton);
        add(deleteButton);

        outputArea = new JTextArea(15, 42);
        add(new JScrollPane(outputArea));

        addButton.addActionListener(e -> issueBook());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());

        setVisible(true);
    }

    void issueBook() {

        String query =
            "INSERT INTO book_issue VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(
                1,
                Integer.parseInt(bookIdField.getText())
            );

            ps.setString(
                2,
                studentField.getText()
            );

            ps.setDate(
                3,
                Date.valueOf(issueDateField.getText())
            );

            ps.setDate(
                4,
                Date.valueOf(returnDateField.getText())
            );

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                "Book issue record added successfully!"
            );

            ps.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
            );
        }
    }

    void viewRecords() {

        outputArea.setText("");

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs =
                stmt.executeQuery("SELECT * FROM book_issue");

            while (rs.next()) {

                outputArea.append(
                    "Book ID : "
                    + rs.getInt("book_id")
                    + "\n"
                );

                outputArea.append(
                    "Student Name : "
                    + rs.getString("student_name")
                    + "\n"
                );

                outputArea.append(
                    "Issue Date : "
                    + rs.getDate("issue_date")
                    + "\n"
                );

                outputArea.append(
                    "Return Date : "
                    + rs.getDate("return_date")
                    + "\n"
                );

                outputArea.append(
                    "-----------------------------\n"
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
            );
        }
    }

    void deleteRecord() {

        String query =
            "DELETE FROM book_issue WHERE book_id = ?";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(
                1,
                Integer.parseInt(bookIdField.getText())
            );

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Record deleted successfully!"
                );
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Record not found!"
                );
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new BookIssueTracking();
    }
}