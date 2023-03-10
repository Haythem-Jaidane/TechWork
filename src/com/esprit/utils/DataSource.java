/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.utils;

import com.esprit.entities.FichMedia;
import com.esprit.entities.Offre;
import com.esprit.entities.Projet;
import com.esprit.entities.TypeProjet;
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
 * @author abdel
 */
public class DataSource {
    
    private Connection cnx;
    
    private static DataSource instance;
    
        private static String HOST = "127.0.0.1";
    private final String URL = "jdbc:mysql://localhost:3306/techwork";
    private static int PORT = 3306;
    private static String DB_NAME = "techwork";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static Connection connection;
    
    
    
    
//    private final String URL = "jdbc:mysql://localhost:3306/formation";
  //  private final String USERNAME = "root";
//    private final String PASSWORD = "";

       
    public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
    private DataSource() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connecting !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
 
    public static DataSource getInstance() {
        if(instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
        public static Connection ConnectDb(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/techwork","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
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
        
        //bech tafichi tab
      public static ObservableList<Projet> getDataproj(){
       Connection cnx = DataSource.getInstance().getCnx();
        ObservableList<Projet> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnx.prepareStatement("select * from projet");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Projet(rs.getInt("id"), rs.getString("nom"), rs.getString("description") , rs.getString("domaine")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public static ObservableList<FichMedia> getDatamedia(){
       Connection cnx = DataSource.getInstance().getCnx();
        ObservableList<FichMedia> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = cnx.prepareStatement("select * from FichMedia");
           ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new FichMedia (result.getInt("idmedia"), result.getString("nommedia"), result.getString("urlmedia"), result.getString("typemedia"), result.getInt("id")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
        public static ObservableList<TypeProjet> getDatatype(){
       Connection cnx = DataSource.getInstance().getCnx();
        ObservableList<TypeProjet> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = cnx.prepareStatement("select * from TypeProjet");
           ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new TypeProjet (result.getInt("idtypeprojet"), result.getString("nomtype"), result.getString("descriptiontype"), result.getInt("id")));
            }
        } catch (Exception e) {
        }
        return list;
    }    
        
}
