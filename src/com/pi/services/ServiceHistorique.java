/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.services;
import com.pi.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pi.entities.Historique;
import com.pi.entities.Profil;
/**
 *
 * @author ASUS
 */
public class ServiceHistorique implements IService<Historique> {
    
    
     private Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Historique h) {
        String req = "INSERT INTO historique(id_Profil,id_Recruteur ,id_Offre,resultat ) VALUES(?, ?,?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, Integer.toString( h.getId_Profil()));
            pst.setString(2, Integer.toString( h.getId_Recruteur()));
            pst.setString(3, Integer.toString( h.getId_Offre()));
            pst.setBoolean(4, h.getResultat()); 
            pst.executeUpdate();
            System.out.println("Historique ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Historique h) {
        String req = "UPDATE  historique SET id_Profil=?, id_Recruteur= ?,id_Offre=?, resultat= ? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, h.getId());
            pst.setString(1, Integer.toString( h.getId_Profil()));
            pst.setString(2, Integer.toString( h.getId_Recruteur()));
            pst.setString(3, Integer.toString( h.getId_Offre()));
            pst.setBoolean(4, h.getResultat());
            pst.executeUpdate();
            System.out.println("Historique modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Historique h) {
        String req = "DELETE FROM historique WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, h.getId());
            pst.executeUpdate();
            System.out.println("Historique supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Historique> afficher() {
        List<Historique> list = new ArrayList<>();
        
        String req = "SELECT * FROM historique";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Historique(result.getInt("id"), result.getInt("id_Profil"),result.getInt("id_Recruteur"),result.getInt("id_Offre"),result.getBoolean("resultat")));
            }
            System.out.println("Historiques récupérés !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    
}
