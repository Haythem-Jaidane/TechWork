/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;
import com.esprit.entities.FichMedia;
import com.esprit.entities.TypeProjet;
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
 * @author asus
 */
public class ServiceTypeProjet implements IService<TypeProjet> {
    
        private Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(TypeProjet tp) {
        
        String req = "INSERT INTO TypeProjet(nomtype, descriptiontype, id) VALUES(?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.setString(1, tp.getNomtype());
            pst.setString(2, tp.getDescriptiontype());
            pst.setInt(3, tp.getId());
            pst.executeUpdate();
            System.out.println("TypeProjet  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(TypeProjet tp) {
        String req = "UPDATE  typeprojet SET nomtype=?, descriptiontype= ?, id=?   WHERE idtypeprojet=?  ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, tp.getIdtypeprojet());
            pst.setString(1, tp.getNomtype());
            pst.setString(2, tp.getDescriptiontype());
            pst.setInt(3, tp.getId());
            pst.executeUpdate();
            System.out.println(" TypeProjet modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(TypeProjet tp) {
        String req = "DELETE FROM typeprojet WHERE idtypeprojet=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,tp.getIdtypeprojet() );
            pst.executeUpdate();
            System.out.println("type supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<TypeProjet> afficher() {
        List<TypeProjet> list = new ArrayList<>();
        
        String req = "SELECT * FROM typeprojet";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new TypeProjet (result.getInt("idtypeprojet"), result.getString("nomtype"), result.getString("descriptiontype"), result.getInt("id")));
            }
            System.out.println("type récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
   
}


