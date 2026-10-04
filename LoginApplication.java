import java.sql.*;
import java.util.Scanner;

public class LoginApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_demo",
                "root",
                "VINEET321@wax"
            );

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + rs.getString("username"));
            } else {
                System.out.println("Invalid username or password.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}