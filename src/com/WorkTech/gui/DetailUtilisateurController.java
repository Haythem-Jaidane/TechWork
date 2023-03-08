/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.WorkTech.gui;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Jasser
 */
public class DetailUtilisateurController implements Initializable {

    
    @FXML
    private javafx.scene.control.Label lbcin;
    @FXML
    private javafx.scene.control.Label lbnom;
    @FXML
    private javafx.scene.control.Label lbprenom;
    @FXML
    private javafx.scene.control.Label lbmotDePasse;
    @FXML
    private javafx.scene.control.Label lbemail;
    @FXML
    private javafx.scene.control.Label lbrole;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setLbCin(String cin) {
        this.lbcin.setText(cin);
    }
    
       public void setLbNom(String nom) {
        this.lbnom.setText(nom);
    }
         public void setLbPrenom(String prenom) {
        this.lbprenom.setText(prenom);
    }
           public void lbMotDePasse(String motDePasse) {
        this.lbmotDePasse.setText(motDePasse);
    }
    
          public void lbEmail(String email) {
        this.lbemail.setText(email);
    }
          
       public void lbrole(String role) {
        this.lbrole.setText(role);
    }
        
}
