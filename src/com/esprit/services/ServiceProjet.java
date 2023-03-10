/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Projet;
import com.esprit.services.IService;
import com.esprit.utils.DataSource;
import com.esprit.entities.Projet;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdel
 */
public class ServiceProjet implements IService<Projet> {

    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Projet p) {
        String req = "INSERT INTO projet(nom, description, domaine ) VALUES('"+p.getNom()+"', '"+p.getDescription()+"', '"+p.getDomaine()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("projet ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Projet p) {
        String req = "UPDATE  projet SET nom='"+p.getNom()+"', description='"+p.getDescription()+"' , domaine='"+p.getDomaine()+"' WHERE id="+p.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Projet modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Projet p) {
        String req = "DELETE FROM projet WHERE id="+p.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Projet supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public  List<Projet> afficher() {
        List<Projet> list = new ArrayList<>();
        
        String req = "SELECT * FROM projet";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Projet(result.getInt("id"), result.getString("nom"), result.getString("description") , result.getString("domaine")));
            }
            System.out.println("Projet récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
