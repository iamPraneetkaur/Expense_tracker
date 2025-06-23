import java.awt.*;
import javax.swing.*;

class MainFrame {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Expense Tracker");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute positioning
        frame.setLocationRelativeTo(null);

        // Title Label
        JLabel titleLabel = new JLabel("Expense Tracker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(200, 20, 250, 30);
        frame.add(titleLabel);

        // Income Label
        JLabel incomeLabel = new JLabel("Total Income:");
        incomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        incomeLabel.setBounds(50, 80, 150, 25);
        frame.add(incomeLabel);

        // Expense Label
        JLabel expenseLabel = new JLabel("Total Expenses:");
        expenseLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        expenseLabel.setBounds(50, 120, 150, 25);
        frame.add(expenseLabel);

        // Balance Label
        JLabel balanceLabel = new JLabel("Remaining Balance:");
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        balanceLabel.setBounds(50, 160, 180, 25);
        frame.add(balanceLabel);

        // Category Label
        JLabel categoryLabel = new JLabel("Expense Category:");
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryLabel.setBounds(50, 200, 180, 25);
        frame.add(categoryLabel);

        // Date Label
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateLabel.setBounds(50, 240, 150, 25);
        frame.add(dateLabel);

        // Description Label
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setBounds(50, 280, 150, 25);
        frame.add(descriptionLabel);

        // Amount Label
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        amountLabel.setBounds(50, 320, 150, 25);
        frame.add(amountLabel);

        frame.setVisible(true);
    }
}
