/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.services;
import com.pi.utils.DataSource;
import com.pi.entities.Profil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceProfil implements IService<Profil> {
    
     private Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Profil p) {
        String req = "INSERT INTO profil(Tel,Email ,Localisation,Description,Langues,Competences,Formation, ExperiencesProfessionnelles,Diplome ) VALUES(?, ?,?, ?, ?,?, ?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, Integer.toString( p.getTel()));
            pst.setString(2, p.getEmail());
            pst.setString(3, p.getLocalisation());
            pst.setString(4, p.getDescription());
            pst.setString(5, p.getLangues());
            pst.setString(6, p.getCompetences());
            pst.setString(7, p.getFormation());
            pst.setString(8, p.getExperiencesProfessionnelles());
            pst.setBoolean(9, p.getDiplome());
            pst.executeUpdate();
            System.out.println("Profil ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Profil p) {
        String req = "UPDATE  profil SET tel=?, email= ?,localisation=?, description= ?,langues=?, competences= ?,formation=?, experiencesProfessionnelles= ?, diplome=? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(10, p.getId());
            pst.setString(1, Integer.toString( p.getTel()));
            pst.setString(2, p.getEmail());
            pst.setString(3, p.getLocalisation());
            pst.setString(4, p.getDescription());
            pst.setString(5, p.getLangues());
            pst.setString(6, p.getCompetences());
            pst.setString(7, p.getFormation());
            pst.setString(8, p.getExperiencesProfessionnelles());
            pst.setBoolean(9, p.getDiplome());
            pst.executeUpdate();
            System.out.println("Profil modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Profil p) {
        String req = "DELETE FROM profil WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Profil supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Profil> afficher() {
        List<Profil> list = new ArrayList<>();
        
        String req = "SELECT * FROM profil";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Profil(result.getInt("id"), result.getInt("tel"),result.getString("email"),result.getString("localisation"),result.getString("description"),result.getString("langues"),result.getString("competences"),result.getString("formation"),result.getString("experiencesProfessionnelles"),result.getBoolean("diplome")));
            }
            System.out.println("Profiles récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    
}
