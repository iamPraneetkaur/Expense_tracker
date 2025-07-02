import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class AddingFrame {
    private JFrame frame;

    AddingFrame(ExpenseDataReceiver receiver) {
        Font subLabel = new Font("Arial", Font.BOLD, 16);
        this.frame = new JFrame("Expense Manager");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Expense Tracker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(200, 20, 250, 30);
        frame.add(titleLabel);

        JLabel expenseLabel = new JLabel("Total Expenses:");
        expenseLabel.setFont(subLabel);
        expenseLabel.setBounds(50, 120, 150, 25);
        frame.add(expenseLabel);

        JTextField exTextField = new JTextField();
        exTextField.setBounds(200, 120, 150, 25);
        frame.add(exTextField);

        JLabel categoryLabel = new JLabel("Expense Category:");
        categoryLabel.setFont(subLabel);
        categoryLabel.setBounds(50, 200, 180, 25);
        frame.add(categoryLabel);

        String[] category = {
            "", "Household & Living", "Food", "Transportation", "Health", "Shopping/Personal",
            "Travel", "Education", "Work", "Financial", "Miscellaneous"
        };
        JComboBox<String> catComboBox = new JComboBox<>(category);
        catComboBox.setBounds(230, 200, 180, 25);
        frame.add(catComboBox);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(subLabel);
        dateLabel.setBounds(50, 240, 150, 25);
        frame.add(dateLabel);

        Integer[] day = new Integer[31];
        for (int i = 0; i < 31; i++) day[i] = i + 1;
        JComboBox<Integer> dayComboBox = new JComboBox<>(day);
        dayComboBox.setBounds(200, 240, 50, 25);
        frame.add(dayComboBox);

        String[] month = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        JComboBox<String> monthComboBox = new JComboBox<>(month);
        monthComboBox.setBounds(250, 240, 100, 25);
        frame.add(monthComboBox);

        Integer[] year = new Integer[16];
        for (int i = 0; i < 16; i++) year[i] = 2020 + i;
        JComboBox<Integer> yearComboBox = new JComboBox<>(year);
        yearComboBox.setBounds(350, 240, 70, 25);
        frame.add(yearComboBox);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(subLabel);
        descriptionLabel.setBounds(50, 290, 150, 25);
        frame.add(descriptionLabel);

        JTextArea desTextArea = new JTextArea();
        desTextArea.setLineWrap(true);
        desTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(desTextArea);
        scrollPane.setBounds(200, 280, 250, 60);
        frame.add(scrollPane);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBounds(230, 410, 100, 30);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String expense = exTextField.getText();
                String category = (String) catComboBox.getSelectedItem();
                int day = (int) dayComboBox.getSelectedItem();
                String month = (String) monthComboBox.getSelectedItem();
                int year = (int) yearComboBox.getSelectedItem();
                String date = day + "-" + month + "-" + year;
                String description = desTextArea.getText();

                receiver.receiveExpense(expense, category, date, description);
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
