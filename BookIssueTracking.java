import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookIssueTracking extends JFrame implements ActionListener {

    JTextField bookId, studentName, issueDate, returnDate;
    JButton add, view, update, delete, clear;
    JTextArea output;

    Connection con;

    BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(750, 550);
        setLayout(new FlowLayout());

        add(new JLabel("Book ID"));
        bookId = new JTextField(15);
        add(bookId);

        add(new JLabel("Student Name"));
        studentName = new JTextField(15);
        add(studentName);

        add(new JLabel("Issue Date"));
        issueDate = new JTextField(15);
        add(issueDate);

        add(new JLabel("Return Date"));
        returnDate = new JTextField(15);
        add(returnDate);

        add = new JButton("Add");
        view = new JButton("View");
        update = new JButton("Update");
        delete = new JButton("Delete");
        clear = new JButton("Clear");

        add(add);
        add(view);
        add(update);
        add(delete);
        add(clear);

        output = new JTextArea(18, 60);
        output.setEditable(false);

        add(new JScrollPane(output));

        add.addActionListener(this);
        view.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);

        connect();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookissue",
                "root",
                "VINEET321@wax"
            );

            output.setText("database connected successfully");

        } catch (Exception e) {

            output.setText(
                "DATABASE CONNECTION FAILED\n\n" +
                e.toString()
            );
        }
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (con == null) {
                output.setText("database is not connected");
                return;
            }

            if (e.getSource() == add) {

                PreparedStatement ps = con.prepareStatement(
                    "insert into book_issue values (?, ?, ?, ?)"
                );

                ps.setInt(
                    1,
                    Integer.parseInt(bookId.getText())
                );

                ps.setString(
                    2,
                    studentName.getText()
                );

                ps.setDate(
                    3,
                    Date.valueOf(issueDate.getText())
                );

                ps.setDate(
                    4,
                    Date.valueOf(returnDate.getText())
                );

                ps.executeUpdate();

                output.setText(
                    "book issue record added successfully"
                );

                ps.close();
            }

            else if (e.getSource() == view) {

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(
                    "select * from book_issue"
                );

                output.setText(
                    String.format(
                        "%-10s %-25s %-15s %-15s%n",
                        "book id",
                        "student name",
                        "issue date",
                        "return date"
                    )
                );

                output.append(
                    "--------------------------------------------------------------------------\n"
                );

                while (rs.next()) {

                    output.append(
                        String.format(
                            "%-10d %-25s %-15s %-15s%n",
                            rs.getInt("book_id"),
                            rs.getString("student_name"),
                            rs.getDate("issue_date"),
                            rs.getDate("return_date")
                        )
                    );
                }

                rs.close();
                st.close();
            }

            else if (e.getSource() == update) {

                PreparedStatement ps = con.prepareStatement(
                    "update book_issue set student_name=?, issue_date=?, return_date=? where book_id=?"
                );

                ps.setString(
                    1,
                    studentName.getText()
                );

                ps.setDate(
                    2,
                    Date.valueOf(issueDate.getText())
                );

                ps.setDate(
                    3,
                    Date.valueOf(returnDate.getText())
                );

                ps.setInt(
                    4,
                    Integer.parseInt(bookId.getText())
                );

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    output.setText(
                        "book issue record updated successfully"
                    );
                } else {
                    output.setText(
                        "book id not found"
                    );
                }

                ps.close();
            }

            else if (e.getSource() == delete) {

                PreparedStatement ps = con.prepareStatement(
                    "delete from book_issue where book_id=?"
                );

                ps.setInt(
                    1,
                    Integer.parseInt(bookId.getText())
                );

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    output.setText(
                        "book issue record deleted successfully"
                    );
                } else {
                    output.setText(
                        "book id not found"
                    );
                }

                ps.close();
            }

            else if (e.getSource() == clear) {

                bookId.setText("");
                studentName.setText("");
                issueDate.setText("");
                returnDate.setText("");
                output.setText("");
            }

        } catch (NumberFormatException ex) {

            output.setText(
                "please enter a valid book id"
            );

        } catch (IllegalArgumentException ex) {

            output.setText(
                "please enter date in yyyy-mm-dd format"
            );

        } catch (SQLException ex) {

            output.setText(
                "database error:\n" +
                ex.getMessage()
            );

        } catch (Exception ex) {

            output.setText(
                "error:\n" +
                ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new BookIssueTracking();
    }
}