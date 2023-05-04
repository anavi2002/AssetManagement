package Electricity;

import java.sql.*;
// import com.mysql.cj.jdbc.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/assetmanagement", "root", "");
            s = c.createStatement();
            // String query = "select * from login";
            // ResultSet rs = s.executeQuery(query); // Execute query
            // rs.next();
            // String name = rs.getString("name"); // Retrieve name from db

            // System.out.println(name);
            /*
             * String url
             * = "jdbc:mysql://localhost:3306/table_name"; // table details
             * String username = "rootgfg"; // MySQL credentials
             * String password = "gfg123";
             * String query
             * = "select *from students"; // query to be run
             * Class.forName(
             * "com.mysql.cj.jdbc.Driver"); // Driver name
             * Connection con = DriverManager.getConnection(
             * url, username, password);
             */

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}