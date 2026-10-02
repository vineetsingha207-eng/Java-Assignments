import java.sql.*;

public class ProductDetails {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "VINEET321@wax"
            );

            Statement stmt = con.createStatement();

            String query = "select product_id, product_name, quantity, price from product";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Product Details");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Product Name: " + rs.getString("product_name"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("--------------------------------");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}