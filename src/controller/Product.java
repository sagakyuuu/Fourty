package controller;
import config.Database;
import java.sql.*;

public class Product {
    public void getProduct () {
        Connection conn = Database.connect();
        
        System.out.println(conn);
        
        try {
            Statement stm = conn.createStatement();
            ResultSet query = stm.executeQuery("SELECT * FROM product");
            
            while (query.next()) {
                System.out.println(
                 "ID: " + query.getInt("id") +
                    ", Nama: " + query.getString("nama") +
                    ", Deskripsi: " + query.getString("deskripsi") +
                    ", Harga: " + query.getInt("harga") +
                    ", Stok: " + query.getInt("stok"));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
        }
    }
}
