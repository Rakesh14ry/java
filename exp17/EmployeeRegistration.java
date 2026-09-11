import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeRegistration extends JFrame implements ActionListener {

    JTextField idField, nameField, departmentField, salaryField;
    JButton submitButton;

    EmployeeRegistration() {

        setTitle("Employee Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Employee ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);

        add(new JLabel("Salary:"));
        salaryField = new JTextField();
        add(salaryField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(new JLabel(""));
        add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this,
                "Employee Details\n\n" +
                "Employee ID: " + idField.getText() +
                "\nName: " + nameField.getText() +
                "\nDepartment: " + departmentField.getText() +
                "\nSalary: " + salaryField.getText(),
                "Employee Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new EmployeeRegistration();
    }
}