/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import utils.DbConnect;

/**
 *
 * @author Karim
 */
public class ServiceOffre implements IService<Offre> {
    private Connection cnx = DbConnect.getInstance().getConnection();
    
    
    @Override
    public void ajouter(Offre o) {
        String req = "INSERT INTO offre(titre, description, post, salaire, lieu, typeContrat, duree, status, domaineOffre,nomRecruteur,emailRecruteur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, o.getTitre());
            pst.setString(2, o.getDescription());
            pst.setString(3, o.getPost());
            pst.setInt(4, o.getSalaire());
            pst.setString(5, o.getLieu());       
            pst.setString(6, o.getTypeContrat());
            pst.setInt(7, o.getDuree());
            pst.setString(8, o.getStatus());
            pst.setString(9, o.getDomaineOffre()); 
            pst.setString(10, o.getNomRecruteur()); 
            pst.setString(11, o.getEmailRecruteur()); 
            pst.executeUpdate();
            System.out.println("Offre ajouté !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        
    
        
    public void modifierV2(Offre o) { 
     //   String req = "UPDATE  offre SET titre='"+o.getTitre()+"', description= '"+o.getDescription()+"', post= '"+o.getPost()+"', salaire= '"+o.getSalaire()+"', lieu= '"+o.getLieu()+"', status= '"+o.getStatus()+"', idRecruteur= '"+o.getIdRecruteur()+"', getIdTypeContrat= '"+o.getIdTypeContrat()+"', idDomaineOffre= '"+o.getIdDomaineOffre()+"' WHERE id="+o.getId()+"";
        String req = "UPDATE offre SET id='"+o.getId()+"', titre= '"+o.getTitre()+"', status= '"+o.getStatus()+"' WHERE id="+o.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("offre modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    
    @Override
    public void modifier(Offre o) { 
     //   String req = "UPDATE  offre SET titre='"+o.getTitre()+"', description= '"+o.getDescription()+"', post= '"+o.getPost()+"', salaire= '"+o.getSalaire()+"', lieu= '"+o.getLieu()+"', status= '"+o.getStatus()+"', idRecruteur= '"+o.getIdRecruteur()+"', getIdTypeContrat= '"+o.getIdTypeContrat()+"', idDomaineOffre= '"+o.getIdDomaineOffre()+"' WHERE id="+o.getId()+"";
        String req = "UPDATE offre SET id='"+o.getId()+"', titre= '"+o.getTitre()+"', description= '"+o.getDescription()+"', post= '"+o.getPost()+"', salaire= '"+o.getSalaire()+"', lieu= '"+o.getLieu()+"', typeContrat= '"+o.getTypeContrat()+"', duree= '"+o.getDuree()+"', status= '"+o.getStatus()+"', domaineOffre= '"+o.getDomaineOffre()+"', nomRecruteur= '"+o.getNomRecruteur()+"', emailRecruteur= '"+o.getEmailRecruteur()+"' WHERE id="+o.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("offre modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    @Override
    public void supprimer(Offre o) {
        String req = "DELETE FROM offre WHERE id="+o.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Offre supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
  @Override
    public List<Offre> afficher() {
        List<Offre> list = new ArrayList<>();
        
        String req = "SELECT * FROM offre";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) { 
                list.add(new Offre(result.getInt("id"),
                        result.getString("titre"),
                        result.getString("description"),
                        result.getString("post"),
                        result.getInt("salaire"),
                        result.getString("lieu"), 
                        result.getString("typeContrat"),
                        result.getInt("duree"),
                        result.getString("status"),
                        result.getString("domaineOffre"),
                        result.getString("nomRecruteur"),
                        result.getString("emailRecruteur")));
            }
            System.out.println("Offre récupéré !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
   // @Override
    public ObservableList<Offre> afficherV2(ObservableList<Offre> offresList,TableView<Offre> offresTable) {
    //    List<Offre> list = new ArrayList<>();
        
       try { 
            String query = "SELECT * FROM `offre`";
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
            
            while (resultSet.next()){
                offresList.add(new Offre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("description"),
                        resultSet.getString("post"),
                        resultSet.getInt("salaire"),
                        resultSet.getString("lieu"),
                        resultSet.getString("typeContrat"),
                        resultSet.getInt("duree"),
                        resultSet.getString("status"),
                        resultSet.getString("domaineOffre"),
                        resultSet.getString("nomRecruteur"),
                        resultSet.getString("emailRecruteur")));
                offresTable.setItems(offresList);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return offresList;
    }
    
    
    
       // @Override
    public ObservableList<Offre> afficherDispo(ObservableList<Offre> offresList,TableView<Offre> offresTable) {
    //    List<Offre> list = new ArrayList<>();
        
       try { 
            String query = "SELECT * FROM `offre` WHERE `status` = 'Disponible' ";
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
            
            while (resultSet.next()){
                offresList.add(new Offre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("description"),
                        resultSet.getString("post"),
                        resultSet.getInt("salaire"),
                        resultSet.getString("lieu"),
                        resultSet.getString("typeContrat"),
                        resultSet.getInt("duree"),
                        resultSet.getString("status"),
                        resultSet.getString("domaineOffre"),
                        resultSet.getString("nomRecruteur"),
                        resultSet.getString("emailRecruteur")));
                offresTable.setItems(offresList);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return offresList;
    }
    
    
    
       // @Override
    public ObservableList<Offre> afficherNonDispo(ObservableList<Offre> offresList,TableView<Offre> offresTable) {
    //    List<Offre> list = new ArrayList<>();
        
       try { 
            String query = "SELECT * FROM `offre` WHERE `status` = 'Plus Disponible' ";
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
            
            while (resultSet.next()){
                offresList.add(new Offre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("description"),
                        resultSet.getString("post"),
                        resultSet.getInt("salaire"),
                        resultSet.getString("lieu"),
                        resultSet.getString("typeContrat"),
                        resultSet.getInt("duree"),
                        resultSet.getString("status"),
                        resultSet.getString("domaineOffre"),
                        resultSet.getString("nomRecruteur"),
                        resultSet.getString("emailRecruteur")));
                offresTable.setItems(offresList);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return offresList;
    }
    
}