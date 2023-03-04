package org.example;
import java.sql.*;
public class CreateInterdepartmentalRequestTable {

        public static void main(String[] args) {
            try {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");

                // Execute a query to create the Interdepartmental Request table
                String sql = "CREATE TABLE Interdepartmental_Request (" +
                        "id INT(11) NOT NULL AUTO_INCREMENT, " +
                        "mu_id INT(11) NOT NULL, " +
                        "request_type VARCHAR(255) NOT NULL, " +
                        "request_name VARCHAR(255) NOT NULL, " +
                        "creation_date DATE NOT NULL, " +
                        "responsible_user VARCHAR(255) NOT NULL, " +
                        "PRIMARY KEY (id), " +
                        "FOREIGN KEY (mu_id) REFERENCES Incoming_Document(id)" +
                        ")";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                // Close the statement and connection
                stmt.close();
                conn.close();

                System.out.println("Interdepartmental Request table created successfully");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


