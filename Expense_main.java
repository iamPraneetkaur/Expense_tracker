import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

interface ExpenseDataReceiver {
    void receiveExpense(String expense, String category, String date, String description);
}

class Expense_main implements ExpenseDataReceiver {
    private DefaultTableModel tableModel;
    private JTextField inField;
    private double income = 0;
    private double totalExpenses = 0;

    public static void main(String args[]) {
        new Expense_main().initUI();
    }

    public void initUI() {
        JFrame frame = new JFrame("Personal Expense Manager");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Personal Expense Manager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 400, 30);
        frame.add(titleLabel);

        JButton addExpenseButton = new JButton("Add Expense");
        addExpenseButton.setBounds(50, 70, 130, 30);
        frame.add(addExpenseButton);

        addExpenseButton.addActionListener(e -> {
            try {
                if (income == 0) {
                    income = Double.parseDouble(inField.getText());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid income first.");
                return;
            }
            new AddingFrame(this);
        });

        JButton expenseReportButton = new JButton("Expense Report");
        expenseReportButton.setBounds(190, 70, 150, 30);
        expenseReportButton.setBackground(Color.GREEN);
        frame.add(expenseReportButton);

        JLabel inLabel = new JLabel("Income: ");
        inLabel.setFont(new Font("Arial", Font.BOLD, 24));
        inLabel.setBounds(500, 70, 150, 25);
        frame.add(inLabel);

        inField = new JTextField();
        inField.setBounds(600, 70, 120, 30);
        frame.add(inField);

        String[] columns = {"Expense", "Balance", "Category", "Date", "Description", "Amount"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setShowGrid(true);
        table.setGridColor(Color.GRAY);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 130, 780, 400);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public void receiveExpense(String expense, String category, String date, String description) {
        double amount = Double.parseDouble(expense);
        totalExpenses += amount;
        double balance = income - totalExpenses;
        amount= income-balance;
        String[] row = {
            expense,
            String.format("%.2f", balance),
            category,
            date,
            description,
            Double.toString(amount)
        };
        tableModel.addRow(row);
    }
}
