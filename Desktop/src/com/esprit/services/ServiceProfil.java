/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Profil;
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
public class ServiceProfil implements IService<Profil> {

    public static int idp = -1;
    public static int profils =0;
    private Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Profil p) {
        String req = "INSERT INTO profil(Nom,Prenom,Numéro_téléphone,E_mail ,Localisation,Description,Langues,Competences,Formation, Experiences_professionnelles,latitude,longitude,Diplome ) VALUES(?, ?,?, ?, ?,?, ?,?,?,?,?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getNuméro_téléphone());
            pst.setString(4, p.getE_mail());
            pst.setString(5, p.getLocalisation());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getLangues());
            pst.setString(8, p.getCompetences());
            pst.setString(9, p.getFormation());
            pst.setString(10, p.getExperiences_professionnelles());
            pst.setString(11, p.getLatitude());
            pst.setString(12, p.getLongitude());
            pst.setString(13, p.getDiplome());
            pst.executeUpdate();
            System.out.println("Profil ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Profil p) {
        String req = "UPDATE  profil SET Nom=?, Prenom= ?,Numéro_téléphone=?, E_mail= ?,Localisation=?, Description= ?,Langues=?, Competences= ?,Formation=?, Experiences_professionnelles= ?, latitude=?, longitude=?, Diplome=? WHERE id_Profil=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(14, p.getId_Profil());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getNuméro_téléphone());
            pst.setString(4, p.getE_mail());
            pst.setString(5, p.getLocalisation());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getLangues());
            pst.setString(8, p.getCompetences());
            pst.setString(9, p.getFormation());
            pst.setString(10, p.getExperiences_professionnelles());
            pst.setString(11, p.getLatitude());
            pst.setString(12, p.getLongitude());
            pst.setString(13, p.getDiplome());
            pst.executeUpdate();
            System.out.println("Profil modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Profil p) {
        String req = "DELETE FROM profil WHERE id_Profil=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId_Profil());
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
            while (result.next()) {
                list.add(new Profil(result.getInt("id_Profil"), result.getString("Nom"), result.getString("Prenom"), result.getString("Numéro_téléphone"), result.getString("E_mail"), result.getString("Localisation"), result.getString("Description"), result.getString("Langues"), result.getString("Competences"), result.getString("Formation"), result.getString("Experiences_professionnelles"), result.getString("latitude"), result.getString("longitude"), result.getString("Diplome")));

            }
            System.out.println("Profiles récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public Profil getProfilById(int id) {
        String req = "SELECT * FROM profil  WHERE id_Profil='" + id + "';";
        Profil p;
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                p = new Profil(result.getInt("id_Profil"), result.getString("Nom"), result.getString("Prenom"), result.getString("Numéro_téléphone"), result.getString("E_mail"), result.getString("Localisation"), result.getString("Description"), result.getString("Langues"), result.getString("Competences"), result.getString("Formation"), result.getString("Experiences_professionnelles"), result.getString("latitude"), result.getString("longitude"), result.getString("Diplome"));
                return p;
            }

            System.out.println("Profils récupérées by id !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
