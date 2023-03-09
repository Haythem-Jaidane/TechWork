/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entities.Offre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author BOURAOUI
 */
public class DbConnect {    
    private static String HOST = "127.0.0.1";
    private final String URL = "jdbc:mysql://localhost:3306/gestionoffrev5";
    private static int PORT = 3306;
    private static String DB_NAME = "gestionoffrev5";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static Connection connection;
    
    

    
       
    public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
     
        
 
    private static DbConnect instance;
    private DbConnect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connecting !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static DbConnect getInstance() {
        if(instance == null) {
            instance = new DbConnect();
        }
        return instance;
    }
    
    
        Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionoffrev5","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    

    public Connection getConnection() {
        return connection;
    }
    
    
        public static ObservableList<Offre> getDatausers(){
        Connection conn = ConnectDb();
        ObservableList<Offre> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from offre WHERE `status` = 'Disponible'  ");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Offre(Integer.parseInt(rs.getString("id")), rs.getString("titre"), rs.getString("description"), rs.getString("post"), rs.getInt("salaire"),
                rs.getString("lieu"), rs.getString("typeContrat"),rs.getInt("duree"), rs.getString("status"), rs.getString("domaineOffre"), 
                        rs.getString("nomRecruteur"),rs.getString("emailRecruteur")  ));  
                 
            }
        } catch (Exception e) {
        }
        return list;
    }
        
         public static ObservableList<Offre> getDatausers1(){
        Connection conn = ConnectDb();
        ObservableList<Offre> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from offre WHERE `status` = 'Plus Disponible'  ");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Offre(Integer.parseInt(rs.getString("id")), rs.getString("titre"), rs.getString("description"), rs.getString("post"), rs.getInt("salaire"),
                rs.getString("lieu"), rs.getString("typeContrat"),rs.getInt("duree"), rs.getString("status"), rs.getString("domaineOffre"), 
                        rs.getString("nomRecruteur"),rs.getString("emailRecruteur")  ));  
                 
            }
        } catch (Exception e) {
        }
        return list;
    }
 
}