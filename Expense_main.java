import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

interface ExpenseDataReceiver {
    void receiveExpense(String expense, String balance, String category, String date, String description, String amount);
}

class Expense_main implements ExpenseDataReceiver {
    private DefaultTableModel tableModel;
    private JTextField inField;

    public static void main(String args[]) {
        new Expense_main().initUI();
    }
    public void initUI() {
        JFrame frame = new JFrame("Personal Expense Manager");
        frame.setSize(900, 600);
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
            String income= inField.getText();
            new AddingFrame(this, income); // pass current instance
        });

        // Expense Report Button
        JButton expenseReportButton = new JButton("Expense Report");
        expenseReportButton.setBounds(190, 70, 150, 30);
        expenseReportButton.setBackground(Color.GREEN);
        frame.add(expenseReportButton);

        //Income Label
        JLabel inLabel = new JLabel("Income: ");
        inLabel.setFont(new Font("Arial", Font.BOLD, 24));
        inLabel.setBounds(500, 70, 150, 25);
        frame.add(inLabel);
        //Income Text Field
        inField = new JTextField();
        inField.setBounds(600, 70, 120, 30);
        frame.add(inField);

        // Table with grid lines, fixed headers
        String[] columns = {"Expense", "Balance", "Category", "Date", "Description", "Amount"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Make column headers fixed (non-moveable and non-resizable)
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Show grid lines
        table.setShowGrid(true);
        table.setGridColor(Color.GRAY);

        // Make table non-editable (optional)
        table.setDefaultEditor(Object.class, null);

        // Scroll pane wrapping the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 130, 780, 400);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
    public void receiveExpense(String expense, String balance, String category, String date, String description, String amount) {
        String[] row = {expense, balance, category, date, description, amount};
        tableModel.addRow(row);
    }
}
