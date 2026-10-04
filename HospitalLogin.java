import java.sql.*;
import java.util.Scanner;

public class HospitalLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital_demo",
                "root",
                "VINEET321@wax"
            );

            System.out.print("Enter login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM hospital_staff WHERE login_id = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");

                System.out.println("Login successful!");
                System.out.println("Welcome, " + name);

                if (role.equals("Doctor")) {
                    System.out.println("Access granted: Doctor's dashboard.");
                } else if (role.equals("Nurse")) {
                    System.out.println("Access granted: Nurse's dashboard.");
                }
            } else {
                System.out.println("Invalid login ID or password.");
                System.out.println("Access denied.");
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