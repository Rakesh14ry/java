import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JLabel label1, label2, resultLabel;
    JTextField num1, num2, result;
    JButton addButton, subButton;

    Calculator() {

        setTitle("Simple Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        label1 = new JLabel("Enter First Number:");
        label2 = new JLabel("Enter Second Number:");
        resultLabel = new JLabel("Result:");

        // Text fields
        num1 = new JTextField();
        num2 = new JTextField();
        result = new JTextField();

        result.setEditable(false);

        // Buttons
        addButton = new JButton("Addition");
        subButton = new JButton("Subtraction");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);

        // Add components
        add(label1);
        add(num1);

        add(label2);
        add(num2);

        add(addButton);
        add(subButton);

        add(resultLabel);
        add(result);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());

            if (e.getSource() == addButton) {
                result.setText(String.valueOf(a + b));
            }

            if (e.getSource() == subButton) {
                result.setText(String.valueOf(a - b));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers."
            );
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}