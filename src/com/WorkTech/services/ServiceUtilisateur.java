/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WorkTech.services;

import com.WorkTech.entities.Utilisateur;
import com.WorkTech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;


/**
 *
 * @author abdel
 */
public class ServiceUtilisateur implements IService<Utilisateur> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Utilisateur p) {
        String req = "INSERT INTO utilisateur(cin, nom, prenom, motDePasse,  email , role) VALUES('"+p.getCin()+"'  ,  '"+p.getNom()+"'  ,'"+p.getPrenom()+"' , '"+p.getMotDePasse()+"' , '"+p.getEmail()+"' , '"+p.getRole()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur p) {
        String req = "UPDATE  utilisateur SET  cin='"+p.getCin()+"' , nom='"+p.getNom()+"', prenom= '"+p.getPrenom()+"' , motDePasse= '"+p.getMotDePasse()+"' ,email= '"+p.getEmail()+"' , role= '"+p.getRole()+"'   WHERE id="+p.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur p) {
        String req = "DELETE FROM utilisateur WHERE id="+p.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> list = new ArrayList<>();
        
        String req = "SELECT * FROM utilisateur";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Utilisateur(result.getString("cin"), result.getString("nom"), result.getString("prenom"), result.getString("motDePasse"), result.getString("email"), result.getString("role")));
            }
            System.out.println("Utilisateurs récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

   public List<Utilisateur> getAllUsers() {
    List<Utilisateur> users = new ArrayList<>();
    try {
        Connection cnx = DataSource.getInstance().getCnx();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateur");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Utilisateur u = new Utilisateur(rs.getInt("id"), rs.getString("cin"), rs.getString("nom"),
                    rs.getString("prenom"), rs.getString("motDePasse"), rs.getString("email"),
                    rs.getString("role"));
            users.add(u);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return users;
}
   
   
   public int getPostIdByName(String cin) {
        String query = "SELECT id FROM utilisateur WHERE cin = ?";
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setString(1, cin);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                return id;
            } else {
          
            return -1;
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1; // indicating task not found
        }
        
    }

}
