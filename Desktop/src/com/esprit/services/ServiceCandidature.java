/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.esprit.entities.Candidature; 
import com.esprit.entities.Offre;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import com.esprit.utils.DataSource;

/**
 *
 * @author Karim
 */
public class ServiceCandidature implements IService<Candidature> {
    private Connection cnx = DataSource.getInstance().getConnection();
    
 
      
          public List<Candidature> guideCountOnCity() throws SQLException
    {
        List<Candidature> arr=new ArrayList();
        Statement stm = cnx.createStatement();
        String req="select count(*) nb ,Status from candidature where status='Acceptée' group by status";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Candidature c = new Candidature(r.getInt("nb")
                    , r.getString("Status"));
            arr.add(c);
        }
        
        return arr;
    }
      
      
    @Override
    public void ajouter(Candidature c) {
        String req = "INSERT INTO candidature(offre, recruteur, candidat, status, informations, datePostulation, dateModification) VALUES(?, ?, ?, ?, ?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            
           
          Offre myObj = c.getOffre();
          ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(myObj);
       System.out.println(jsonString);
            pst.setString(1, jsonString);
            pst.setString(2, c.getRecruteur());
            pst.setString(3, c.getCandidat());
            pst.setString(4, c.getStatus());
            pst.setString(5, c.getInformations());       
            pst.setString(6, c.getDatePostulation());
            pst.setString(7, c.getDateModification()); 
            pst.executeUpdate();
            System.out.println("Candidature ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ServiceCandidature.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    @Override
    public void modifier(Candidature c) { 
    
        try { 
            
            Offre myObj = c.getOffre();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(myObj);
            String req = "UPDATE candidature SET id='"+c.getId()+"', offre= '"+jsonString+"', recruteur= '"+c.getRecruteur()+"', candidat= '"+c.getCandidat()
                    +"', status= '"+c.getStatus()+"', informations= '"+c.getInformations()+"', datePostulation= '"+c.getDatePostulation()+"', dateModification= '"+c.getDateModification()
                    +"' WHERE id="+c.getId()+"";
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Candidature modifiée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ServiceCandidature.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    @Override
    public void supprimer(Candidature c) {
        String req = "DELETE FROM candidature WHERE id="+c.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Candidature supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
  @Override
    public List<Candidature> afficher() {
        List<Candidature> list = new ArrayList<>();
        
        String req = "SELECT * FROM candidature";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) { 
                list.add(new Candidature(result.getInt("id"), (Offre) result.getObject("offre"),
                        result.getString("recruteur"),
                        result.getString("candidat"),
                        result.getString("status"),
                        result.getString("informations"), 
                        result.getString("datePostulation"),
                        result.getString("dateModification")));
            }
            System.out.println("Candidature récupérée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
 
       
       
       
 
             
             
           public ObservableList<Candidature> afficherRejected(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
    //    List<Offre> list = new ArrayList<>();
        
       try { 
             String query = "SELECT * FROM `candidature` WHERE `status` = 'Rejetée' ";
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
             
             
             
       
       
   
              public ObservableList<Candidature> afficherAccepted(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
    //    List<Offre> list = new ArrayList<>();
        
       try { 
             String query = "SELECT * FROM `candidature` WHERE `status` = 'Acceptée' ";
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }    
       
       
     
           public ObservableList<Candidature> afficherV2(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
    //    List<Offre> list = new ArrayList<>();
        
       try { 
             String query = "SELECT * FROM `candidature` WHERE `status` = 'En attente' ";
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
    
           
           
          /***************************************************************************************************************
      * CANDIDAT  STUFF**************************************************************************/
           
           
       /**************Candidatures***********/          
              //En attente
        public ObservableList<Candidature> afficherEnAttenteCandidatures(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
       try { 
           
           // INTEGRATION get the name of the connected person
           String p = "Person";
             String query = "SELECT * FROM `candidature` WHERE `status` = 'En attente' AND `candidat`='"+p+"'";
             
             
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
        
        
       //Accepted
        public ObservableList<Candidature> afficherAcceptedCandidatures(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
       try { 
           
           // INTEGRATION get the name of the connected person
           String p = "Person";
             String query = "SELECT * FROM `candidature` WHERE `status` = 'Acceptée' AND `candidat`='"+p+"'";
             
             
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
        
         
       //Accepted
        public ObservableList<Candidature> afficherRejectedCandidatures(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
       try { 
           
           // INTEGRATION get the name of the connected person
           String p = "Person";
             String query = "SELECT * FROM `candidature` WHERE `status` = 'Rejetée' AND `candidat`='"+p+"'";
             
             
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
        
     
           
           
           
           
           
           
           
           
           
           
           
           
     /***************************************************************************************************************
      * RECRUTEUR STUFF**************************************************************************/
           
           
       /**************Candidatures***********/    
           
       //En attente
        public ObservableList<Candidature> afficherEnAttenteRecruteur(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
       try { 
           
           // INTEGRATION get the name of the connected recruteur
           String r = "Recruter";
             String query = "SELECT * FROM `candidature` WHERE `status` = 'En attente' AND `recruteur`='"+r+"'";
             
             
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
        
        
       //Accepted
        public ObservableList<Candidature> afficherAcceptedRecruteur(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
       try { 
           
              // INTEGRATION get the name of the connected recruteur
           String r = "Recruter";
             String query = "SELECT * FROM `candidature` WHERE `status` = 'Acceptée' AND `recruteur`='"+r+"'";
             
             
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query);; 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
        
         
       //Accepted
        public ObservableList<Candidature> afficherRejectedRecruteur(ObservableList<Candidature> listee,TableView<Candidature> tableee) throws IOException {
       try { 
           
               // INTEGRATION get the name of the connected recruteur
           String r = "Recruter";
             String query = "SELECT * FROM `candidature` WHERE `status` = 'Rejetée' AND `recruteur`='"+r+"'";
             
             
            Statement st = cnx.createStatement();
            ResultSet resultSet = st.executeQuery(query); 
         



            while (resultSet.next()){
                            
            String json = resultSet.getString("offre");
             
            ObjectMapper objectMapper = new ObjectMapper();
            Offre off = objectMapper.readValue(json, Offre.class);
            
            
                listee.add(new Candidature(resultSet.getInt("id"), off,
                        resultSet.getString("recruteur"),
                        resultSet.getString("candidat"),
                        resultSet.getString("status"),
                        resultSet.getString("informations"), 
                        resultSet.getString("datePostulation"),
                        resultSet.getString("dateModification")));
                                tableee.setItems(listee);      
            }}
         catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return listee;
    }
        
     
}