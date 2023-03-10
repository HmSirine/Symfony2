/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author dell
 */

public class DataSource {
    private static DataSource instance ;
    private Connection cnx ;
    
    private final String URL ="jdbc:mysql://localhost:3306/travolta";
    private final String LOGIN ="root";
    private final String PASSWORD ="";
    
    public  DataSource(){
    try {
        cnx =DriverManager.getConnection(URL, LOGIN, PASSWORD);
        System.out.println("Connecting !");
        
    
    }catch(SQLException ex){
        System.err.println(ex.getMessage());
    }
}
    
    public static DataSource getInstance(){
     if (instance == null){
        instance = new DataSource();
    }
    return instance ;
    
    }
    public Connection getCnx(){
    return cnx ;
    }
    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/travolta","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }    }