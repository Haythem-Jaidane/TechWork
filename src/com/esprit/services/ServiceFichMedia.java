/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.FichMedia;
import com.esprit.entities.Projet;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class ServiceFichMedia implements IService<FichMedia> {
    private Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    
    public void ajouter(FichMedia f) {
        
        String req = "INSERT INTO FichMedia(nommedia, urlmedia,typemedia,id) VALUES(?, ?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.setString(1, f.getNommedia());
            pst.setString(2, f.getUrlmedia());
            pst.setString(3, f.getTypemedia());
            pst.setInt(4, f.getId());
            pst.executeUpdate();
            System.out.println("fichier media ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(FichMedia f) {
        String req = "UPDATE  fichmedia SET nommedia=?, urlmedia= ? , typemedia= ? , id= ?  WHERE idmedia=?  ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, f.getIdmedia());
            pst.setString(1, f.getNommedia());
            pst.setString(2, f.getUrlmedia());
            pst.setString(3, f.getTypemedia());
            pst.setInt(4, f.getId());
            pst.executeUpdate();
            System.out.println("fichier media modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(FichMedia f) {
        String req = "DELETE FROM fichmedia WHERE idmedia=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, f.getIdmedia());
            pst.executeUpdate();
            System.out.println("fichier media supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<FichMedia> afficher() {
        List<FichMedia> list = new ArrayList<>();
        
        String req = "SELECT * FROM fichmedia";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new FichMedia (result.getInt("idmedia"), result.getString("nommedia"), result.getString("urlmedia"), result.getString("typemedia"), result.getInt("id")));
            }
            System.out.println("fichier media récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
