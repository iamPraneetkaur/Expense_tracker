import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

interface ExpenseDataReceiver {
    void receiveExpense(String income, String expense, String balance, String category, String date, String description, String amount);
}
class Expense_main implements ExpenseDataReceiver {
    public static void main(String args[]) {
        new Expense_main().initUI(); // call instance method from static
    }

    public void initUI() {
        JFrame frame = new JFrame("Personal Expense Manager");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Title Label
        JLabel titleLabel = new JLabel("Personal Expense Manager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 400, 30);
        frame.add(titleLabel);

        // Add Expense Button
        JButton addExpenseButton = new JButton("Add Expense");
        addExpenseButton.setBounds(50, 70, 130, 30);
        frame.add(addExpenseButton);
        addExpenseButton.addActionListener(e -> {
            new AddingFrame(this); // pass current instance
        });

        // Expense Report Button
        JButton expenseReportButton = new JButton("Expense Report");
        expenseReportButton.setBounds(190, 70, 150, 30);
        expenseReportButton.setBackground(Color.GREEN);
        frame.add(expenseReportButton);

        // Search Field
        JTextField searchField = new JTextField("Search");
        searchField.setBounds(500, 70, 120, 30);
        frame.add(searchField);

        // Filter Button
        JButton filterButton = new JButton("Filter");
        filterButton.setBounds(630, 70, 80, 30);
        filterButton.setBackground(new Color(135, 206, 250)); // Light blue
        frame.add(filterButton);

        // Table Headers (as labels for now)
        int headerY = 130;
        String[] headers = { "ItemId", "ItemName", "Amount", "ExpenseDate", "Category", "Action Item" };
        int x = 50;
        for (String header : headers){
            JLabel label = new JLabel(header);
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setBounds(x, headerY, 100, 25);
            frame.add(label);
            x += 110;
        }
        frame.setVisible(true);
    }
    public void receiveExpense(String income, String expense, String balance, String category, String date, String description, String amount) {
        System.out.println("INCOME: " + income);
        System.out.println("EXPENSE: " + expense);
        System.out.println("BALANCE: " + balance);
        System.out.println("CATEGORY: " + category);
        System.out.println("DATE: " + date);
        System.out.println("DESCRIPTION: " + description);
        System.out.println("AMOUNT: " + amount);
    }
}
