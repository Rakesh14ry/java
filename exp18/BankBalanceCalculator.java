import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceCalculator extends JFrame implements ActionListener {

    JLabel initialLabel, transactionLabel, balanceLabel;
    JTextField initialField, transactionField, balanceField;
    JButton depositButton, withdrawButton;

    double balance;

    BankBalanceCalculator() {

        setTitle("Bank Balance Calculator");
        setSize(450, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        initialLabel = new JLabel("Initial Balance:");
        transactionLabel = new JLabel("Transaction Amount:");
        balanceLabel = new JLabel("Updated Balance:");

        // Text fields
        initialField = new JTextField();
        transactionField = new JTextField();
        balanceField = new JTextField();

        balanceField.setEditable(false);

        // Buttons
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        // Add action listeners
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        // Add components
        add(initialLabel);
        add(initialField);

        add(transactionLabel);
        add(transactionField);

        add(depositButton);
        add(withdrawButton);

        add(balanceLabel);
        add(balanceField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double initialBalance =
                    Double.parseDouble(initialField.getText());

            double amount =
                    Double.parseDouble(transactionField.getText());

            // Deposit
            if (e.getSource() == depositButton) {
                balance = initialBalance + amount;
            }

            // Withdrawal
            if (e.getSource() == withdrawButton) {
                balance = initialBalance - amount;
            }

            // Display updated balance
            balanceField.setText(String.valueOf(balance));

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new BankBalanceCalculator();
    }
}