package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection conn;
    
    public static Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/fourty_db";
                String user = "root";
                String pass = "";
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Database connection success");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return conn;
    }
}
