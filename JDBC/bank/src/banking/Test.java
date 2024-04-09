package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // SQL query to insert data
        String insertQuery = "INSERT INTO customer (acc_no, cname, balance, pass_code) VALUES (1,'asdf',100,123)";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Prepare the insert statement with placeholders
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for the placeholders
            preparedStatement.setString(1, "Value1");
            preparedStatement.setString(2, "Value2");
            preparedStatement.setInt(3, 42);

            // Execute the insert query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }

            // Close the database connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        }
    }
}
