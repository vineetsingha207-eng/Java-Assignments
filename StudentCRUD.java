import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "VINEET321@wax"
            );

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Create Student");
                System.out.println("2. Read Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();

                    String query = "insert into student values (?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setInt(1, roll);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.setDouble(4, marks);

                    ps.executeUpdate();

                    System.out.println("Student added successfully.");
                }

                else if (choice == 2) {
                    String query = "select * from student";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    System.out.println("\nStudent Records");
                    System.out.println("--------------------------------");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("roll_no") + "  " +
                            rs.getString("name") + "  " +
                            rs.getString("course") + "  " +
                            rs.getDouble("marks")
                        );
                    }
                }

                else if (choice == 3) {
                    System.out.print("Enter roll number to update: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter new marks: ");
                    double marks = sc.nextDouble();

                    String query = "update student set name=?, course=?, marks=? where roll_no=?";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setString(1, name);
                    ps.setString(2, course);
                    ps.setDouble(3, marks);
                    ps.setInt(4, roll);

                    ps.executeUpdate();

                    System.out.println("Student updated successfully.");
                }

                else if (choice == 4) {
                    System.out.print("Enter roll number to delete: ");
                    int roll = sc.nextInt();

                    String query = "delete from student where roll_no=?";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setInt(1, roll);

                    ps.executeUpdate();

                    System.out.println("Student deleted successfully.");
                }

                else if (choice == 5) {
                    System.out.println("Program ended.");
                    break;
                }

                else {
                    System.out.println("Invalid choice.");
                }
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}