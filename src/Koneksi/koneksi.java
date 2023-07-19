/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asutr
 */
public class koneksi {
    
    private static Connection MySQLDatabase;
    
    public static Connection configDB()throws SQLException{
        
        try {
            String url = "jdbc:mysql://localhost:3306/rula_project";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLDatabase = DriverManager.getConnection(url, user, password);
        } catch(SQLException e){
            System.out.println("Koneksi ke Database Berhasil");
        }
        return MySQLDatabase;  
    }
}
