/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.sql.*;

/**
 *
 * @author HP
 */
public class connectionbd {
    
    private static Connection con=null;
    public static Connection seconnecter() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");  // cette ligne permet de charger le pilote
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcolis","root","");
        
        
        return con;
    }

    static com.mysql.jdbc.Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
