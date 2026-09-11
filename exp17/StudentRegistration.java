import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JTextField nameField, rollField, emailField;
    JComboBox<String> courseBox;
    JButton submitButton;

    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Course:"));
        String[] courses = {"CSE", "IT", "ECE", "Mechanical"};
        courseBox = new JComboBox<>(courses);
        add(courseBox);

        submitButton = new JButton("Register");
        submitButton.addActionListener(this);

        add(new JLabel(""));
        add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this,
                "Student Registered Successfully!\n\n" +
                "Name: " + nameField.getText() +
                "\nRoll No: " + rollField.getText() +
                "\nEmail: " + emailField.getText() +
                "\nCourse: " + courseBox.getSelectedItem());
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}