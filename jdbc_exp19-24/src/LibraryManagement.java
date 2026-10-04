import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {

    JTextField idField, nameField, authorField, priceField;
    JTextArea outputArea;

    String url = "jdbc:mysql://localhost:3306/college";
    String username = "root";
    String password = "rakesh@123";

    LibraryManagement() {

        setTitle("Library Management System");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Book ID:"));
        idField = new JTextField(20);
        add(idField);

        add(new JLabel("Book Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Author:"));
        authorField = new JTextField(20);
        add(authorField);

        add(new JLabel("Price:"));
        priceField = new JTextField(20);
        add(priceField);

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton deleteButton = new JButton("Delete Book");

        add(addButton);
        add(viewButton);
        add(deleteButton);

        outputArea = new JTextArea(15, 40);
        add(new JScrollPane(outputArea));

        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
        deleteButton.addActionListener(e -> deleteBook());

        setVisible(true);
    }

    void addBook() {

        String query =
            "INSERT INTO library_books VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, authorField.getText());
            ps.setDouble(4, Double.parseDouble(priceField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this, "Book added successfully!"
            );

            ps.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    void viewBooks() {

        outputArea.setText("");

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs =
                stmt.executeQuery("SELECT * FROM library_books");

            while (rs.next()) {

                outputArea.append(
                    "Book ID : " + rs.getInt("book_id") + "\n"
                );

                outputArea.append(
                    "Book Name : " + rs.getString("book_name") + "\n"
                );

                outputArea.append(
                    "Author : " + rs.getString("author") + "\n"
                );

                outputArea.append(
                    "Price : " + rs.getDouble("price") + "\n"
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
                this, "Error: " + e.getMessage()
            );
        }
    }

    void deleteBook() {

        String query =
            "DELETE FROM library_books WHERE book_id = ?";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(idField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(
                    this, "Book deleted successfully!"
                );
            } else {
                JOptionPane.showMessageDialog(
                    this, "Book not found!"
                );
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new LibraryManagement();
    }
}