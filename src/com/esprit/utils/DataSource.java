/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.utils;

import com.esprit.entities.FichMedia;
import com.esprit.entities.Projet;
import com.esprit.entities.TypeProjet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdel
 */
public class DataSource {
    
    private Connection cnx;
    
    private static DataSource instance;
    
    private final String URL = "jdbc:mysql://localhost:3306/esprit";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

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
