import javax.swing.*;
public class EmployeeRegistration1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Registration Form");
        JLabel idLabel = new JLabel("Employee ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel deptLabel = new JLabel("Department:");
        JLabel salaryLabel = new JLabel("Salary:");
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField salaryField = new JTextField();
        JButton submitButton = new JButton("Submit");
        idLabel.setBounds(50, 40, 100, 30);
        idField.setBounds(160, 40, 200, 30);
        nameLabel.setBounds(50, 80, 100, 30);
        nameField.setBounds(160, 80, 200, 30);
        deptLabel.setBounds(50, 120, 100, 30);
        deptField.setBounds(160, 120, 200, 30);
        salaryLabel.setBounds(50, 160, 100, 30);
        salaryField.setBounds(160, 160, 200, 30);
        submitButton.setBounds(160, 210, 100, 30);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(deptLabel);
        frame.add(deptField);
        frame.add(salaryLabel);
        frame.add(salaryField);
        frame.add(submitButton);
        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Employee ID: " + idField.getText() +
                    "\nName: " + nameField.getText() +
                    "\nDepartment: " + deptField.getText() +
                    "\nSalary: " + salaryField.getText());
        });
        frame.setSize(450, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
