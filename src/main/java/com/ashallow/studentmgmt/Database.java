
package com.ashallow.studentmgmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Database class creates a connection to a database
 * @author Ashika Shallow
 */
public class Database {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("JDBC Driver Not Found: " + ex.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/studentdb";

        try {
            conn = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            System.err.println("Failed to Connect: " + ex.getMessage());
        }
        return conn;
    }
}
