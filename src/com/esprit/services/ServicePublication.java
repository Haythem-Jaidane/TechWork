/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Publication;
import com.esprit.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServicePublication implements IService<Publication>{
 public static int idp=-1;    
      private Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Publication p) {
        String req = "INSERT INTO publication(objet,message,id_cours,id_Profil  ) VALUES(?, ?,?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getObjet());
            pst.setString(2, p.getMessage());
            pst.setString(3, p.getId_cours());
            pst.setInt(4, p.getId_Profil());
           
            pst.executeUpdate();
            System.out.println("Publication ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publication p) {
        String req = "UPDATE  publication SET objet=?, message= ?,id_cours=?, id_Profil= ? WHERE id_Pub=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, p.getId_Pub());
            pst.setString(1, p.getObjet());
            pst.setString(2, p.getMessage());
            pst.setString(3, p.getId_cours());
            pst.setInt(4, p.getId_Profil());
            
            pst.executeUpdate();
            System.out.println("Publication modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Publication p) {
        String req = "DELETE FROM publication WHERE id_Pub=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId_Pub());
            pst.executeUpdate();
            System.out.println("Publication supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    @Override
    public List<Publication> afficher() {
        List<Publication> list = new ArrayList<>();

        String req = "SELECT * FROM profil";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                list.add(new Publication(result.getInt("id_Pub"), result.getString("objet"), result.getString("message"), result.getString("id_cours"), result.getInt("id_Profil")));

            }
            System.out.println("Publication récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public Publication getPublicationById(int id) {
        String req = "SELECT * FROM profil  WHERE id_Profil='" + id + "';";
        Publication p;
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                p = new Publication(result.getInt("id_Pub"), result.getString("objet"), result.getString("message"), result.getString("id_cours"), result.getInt("id_Profil"));
                return p;
            }

            System.out.println("Publication récupérées by id !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
 
    
      public String getPublicationByname(int id) {
        String req = "SELECT * FROM profil WHERE id_Profil='" + id + "' ;";
        Publication p;
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
       
            
                return (result.getString("Nom")+" "+result.getString("Prenom"));
            }

            System.out.println("Publication récupérées by id !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
}
