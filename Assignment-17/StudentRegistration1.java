import javax.swing.*;

public class StudentRegistration1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel courseLabel = new JLabel("Course:");
        JLabel emailLabel = new JLabel("Email:");

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField emailField = new JTextField();

        JButton submitButton = new JButton("Submit");

        nameLabel.setBounds(50, 40, 100, 30);
        nameField.setBounds(150, 40, 200, 30);

        ageLabel.setBounds(50, 80, 100, 30);
        ageField.setBounds(150, 80, 200, 30);

        courseLabel.setBounds(50, 120, 100, 30);
        courseField.setBounds(150, 120, 200, 30);

        emailLabel.setBounds(50, 160, 100, 30);
        emailField.setBounds(150, 160, 200, 30);

        submitButton.setBounds(150, 210, 100, 30);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(courseLabel);
        frame.add(courseField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Name: " + nameField.getText() +
                    "\nAge: " + ageField.getText() +
                    "\nCourse: " + courseField.getText() +
                    "\nEmail: " + emailField.getText());
        });

        frame.setSize(450, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}