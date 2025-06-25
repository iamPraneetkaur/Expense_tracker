import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class AddingFrame{
    AddingFrame(ExpenseDataReceiver receiver){
        Font subLabel = new Font("Arial", Font.BOLD, 16);
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
        incomeLabel.setFont(subLabel);
        incomeLabel.setBounds(50, 80, 150, 25);
        frame.add(incomeLabel);

        // Income Text Field
        JTextField inTextField = new JTextField();
        inTextField.setBounds(200, 80, 150, 25);
        frame.add(inTextField);

        // Expense Label
        JLabel expenseLabel = new JLabel("Total Expenses:");
        expenseLabel.setFont(subLabel);
        expenseLabel.setBounds(50, 120, 150, 25);
        frame.add(expenseLabel);

        // Expense Text Field
        JTextField exTextField = new JTextField();
        exTextField.setBounds(200, 120, 150, 25);
        frame.add(exTextField);

        // Balance Label
        JLabel balanceLabel = new JLabel("Remaining Balance:");
        balanceLabel.setFont(subLabel);
        balanceLabel.setBounds(50, 160, 180, 25);
        frame.add(balanceLabel);

        // Balance Text Field
        JTextField balTextField = new JTextField();
        balTextField.setBounds(230, 160, 150, 25);
        frame.add(balTextField);

        // Category Label
        JLabel categoryLabel = new JLabel("Expense Category:");
        categoryLabel.setFont(subLabel);
        categoryLabel.setBounds(50, 200, 180, 25);
        frame.add(categoryLabel);

        // Category Combo Box
        String[] category = {
            "", "Household & Living", "Food", "Transportation", "Health", "Shopping/Personal",
            "Travel", "Education", "Work", "Financial", "Miscellaneous"
        };
        JComboBox<String> catComboBox = new JComboBox<>(category);
        catComboBox.setBounds(230, 200, 180, 25);
        frame.add(catComboBox);

        // Date Label
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(subLabel);
        dateLabel.setBounds(50, 240, 150, 25);
        frame.add(dateLabel);

        // Day Combo Box
        Integer[] day = new Integer[31];
        for (int i = 0; i < 31; i++) {
            day[i] = i + 1;
        }
        JComboBox<Integer> dayComboBox = new JComboBox<>(day);
        dayComboBox.setBounds(200, 240, 50, 25);
        frame.add(dayComboBox);

        // Month Combo Box
        String[] month = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        JComboBox<String> monthComboBox = new JComboBox<>(month);
        monthComboBox.setBounds(250, 240, 100, 25);
        frame.add(monthComboBox);

        // Year Combo Box
        Integer[] year = new Integer[16];
        for (int i = 0; i < 16; i++) {
            year[i] = 2020 + i;
        }
        JComboBox<Integer> yearComboBox = new JComboBox<>(year);
        yearComboBox.setBounds(350, 240, 70, 25);
        frame.add(yearComboBox);

        // Description Label
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(subLabel);
        descriptionLabel.setBounds(50, 290, 150, 25);
        frame.add(descriptionLabel);

        // Description Text Area
        JTextArea desTextArea = new JTextArea();
        desTextArea.setLineWrap(true);
        desTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(desTextArea);
        scrollPane.setBounds(200, 280, 250, 60); // Adjusted size
        frame.add(scrollPane);

        // Amount Label
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(subLabel);
        amountLabel.setBounds(50, 360, 150, 25);
        frame.add(amountLabel);

        // Amount Text Field
        JTextField amountTextField = new JTextField();
        amountTextField.setBounds(200, 360, 150, 25);
        frame.add(amountTextField);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBounds(230, 410, 100, 30); // Positioned below Amount field
        frame.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String income = inTextField.getText();
                String expense = exTextField.getText();
                String balance = balTextField.getText();
                String category = (String) catComboBox.getSelectedItem();

                int day = (int) dayComboBox.getSelectedItem();
                String month = (String) monthComboBox.getSelectedItem();
                int year = (int) yearComboBox.getSelectedItem();
                String date = day + "-" + month + "-" + year;

                String description = desTextArea.getText();
                String amount = amountTextField.getText();

                // Send data to the receiver (e.g., main frame)
                receiver.receiveExpense(income, expense, balance, category, date, description, amount);

                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
