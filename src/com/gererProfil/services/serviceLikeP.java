/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gererProfil.services;

import com.gererProfil.entities.Publication;
import com.gererProfil.utils.DbConnect;
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
public class serviceLikeP {
 
      private Connection cnx = DbConnect.getInstance().getConnection();

    public void ajouter() {
        String req = "INSERT INTO likepub(id_user,id_pub) VALUES(?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, 1);
            pst.setInt(2,1);

           
            pst.executeUpdate();
            System.out.println("Publication ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
 
    
}
