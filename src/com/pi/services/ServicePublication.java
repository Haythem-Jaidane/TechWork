/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.services;

import com.pi.entities.Publication;
import com.pi.utils.DataSource;
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
public class ServicePublication implements IService<Publication> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Publication b) {
        String req = "INSERT INTO publication(Objet,Message,Id_Formation,id_Candidat ) VALUES(?,?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
       
            pst.setString(1, b.getObjet());
            pst.setString(2, b.getMessage());
            pst.setString(3, Integer.toString( b.getId_Formation()));
            pst.setString(4, Integer.toString( b.getId_Candidat()));
            pst.executeUpdate();
            System.out.println("Publication ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publication b) {
        String req = "UPDATE publication SET objet=?, message= ?,id_Formation= ?,id_Candidat=?  WHERE id_Pub=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, b.getId_Pub());
            pst.setString(1, b.getObjet());
            pst.setString(2, b.getMessage());
            pst.setInt(3, b.getId_Formation());
            pst.setInt(4, b.getId_Candidat());
            pst.executeUpdate();
            System.out.println("Publication modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Publication b) {
        String req = "DELETE FROM publication WHERE id_Pub=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,b.getId_Pub());
            pst.executeUpdate();
            System.out.println("Publication supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Publication> afficher() {
        List<Publication> list = new ArrayList<>();
        
        String req = "SELECT * FROM publication";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Publication(result.getInt("id_Pub"), result.getString("objet"),result.getString("message"),result.getInt("id_Formation"),result.getInt("id_Candidat")));
            }
            System.out.println("Publications récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    
    
    public Publication getPublicationById(int id)
    {
        String req = "SELECT * FROM publication  WHERE id_Pub='" + id + "';";
        Publication p;
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                p=new Publication(result.getInt("id_Pub"), result.getString("objet"),result.getString("message"));
               return p;
            }
            
            System.out.println("Publications récupérées by id !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
