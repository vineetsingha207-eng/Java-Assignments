import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LibraryManagement extends JFrame implements ActionListener {
    JTextField id, name, author, price;
    JButton add, view, update, delete, clear;
    JTextArea output;
    Connection con;
    LibraryManagement() {
        setTitle("Library Management System");
        setSize(700, 550);
        setLayout(new FlowLayout());
        add(new JLabel("Book ID"));
        id = new JTextField(15);
        add(id);
        add(new JLabel("Book Name"));
        name = new JTextField(15);
        add(name);
        add(new JLabel("Author"));
        author = new JTextField(15);
        add(author);
        add(new JLabel("Price"));
        price = new JTextField(15);
        add(price);
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
        output = new JTextArea(18, 55);
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
            "jdbc:mysql://localhost:3306/librarydb",
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
                    "insert into library values (?, ?, ?, ?)"
                );
                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setString(2, name.getText());
                ps.setString(3, author.getText());
                ps.setDouble(4, Double.parseDouble(price.getText()));
                ps.executeUpdate();
                output.setText("book added successfully");
                ps.close();
            }
            else if (e.getSource() == view) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(
                    "select * from library"
                );
                output.setText(
                    String.format(
                        "%-10s %-25s %-25s %-10s%n",
                        "book id",
                        "book name",
                        "author",
                        "price"
                    )
                );
                output.append(
                    "--------------------------------------------------------------------------\n"
                );
                while (rs.next()) {
                    output.append(
                        String.format(
                            "%-10d %-25s %-25s %-10.2f%n",
                            rs.getInt("book_id"),
                            rs.getString("book_name"),
                            rs.getString("author"),
                            rs.getDouble("price")
                        )
                    );
                }
                rs.close();
                st.close();
            }
            else if (e.getSource() == update) {
                PreparedStatement ps = con.prepareStatement(
                    "update library set book_name=?, author=?, price=? where book_id=?"
                );
                ps.setString(1, name.getText());
                ps.setString(2, author.getText());
                ps.setDouble(3, Double.parseDouble(price.getText()));
                ps.setInt(4, Integer.parseInt(id.getText()));
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    output.setText("book updated successfully");
                } else {
                    output.setText("book id not found");
                }
                ps.close();
            }
            else if (e.getSource() == delete) {
                PreparedStatement ps = con.prepareStatement(
                    "delete from library where book_id=?"
                );
                ps.setInt(1, Integer.parseInt(id.getText()));
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    output.setText("book deleted successfully");
                } else {
                    output.setText("book id not found");
                }
                ps.close();
            }
            else if (e.getSource() == clear) {
                id.setText("");
                name.setText("");
                author.setText("");
                price.setText("");
                output.setText("");
            }
        } catch (NumberFormatException ex) {
            output.setText(
                "please enter valid numeric values for book id and price"
            );
        } catch (SQLIntegrityConstraintViolationException ex) {
            output.setText(
                "book id already exists"
            );
        } catch (SQLException ex) {
            output.setText(
                "database error:\n" + ex.getMessage()
            );
        } catch (Exception ex) {
            output.setText(
                "error:\n" + ex.getMessage()
            );
        }
    }
    public static void main(String[] args) {
        new LibraryManagement();
    }
}