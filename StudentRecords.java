import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "VINEET321@wax"
            );

            Statement stmt = con.createStatement();

            String query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records");
            System.out.println("-----------------------------");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("-----------------------------");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}