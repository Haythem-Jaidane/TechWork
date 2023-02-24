/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;

import com.pi.entities.Profil;
import com.pi.services.ServiceProfil;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DetailsProfilController implements Initializable {
    
    @FXML
    private Label lbId_Profil;
    @FXML
    private Label lbNuméro_téléphone;
    @FXML
    private Label lbE_mail;
    @FXML
    private Label lbLocalisation;
    @FXML
    private Label lbDescription;
    @FXML
    private Label lbLangues;
    @FXML
    private Label lbCompétences;
    @FXML
    private Label lbFormation;
    @FXML
    private Label lbExperiences_professionnelles;
    @FXML
    private Label lbDiplome;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    } 
    
    public void setLbNuméro_téléphone(String Numéro_téléphone) {
        this.lbNuméro_téléphone.setText(Numéro_téléphone);
    }

    public void setLbE_mail(String E_mail) {
        this.lbE_mail.setText(E_mail);
    }

    public void setLbLocalisation(String Localisation) {
        this.lbLocalisation.setText(Localisation);
    }

    public void setLbDescription(String Description) {
        this.lbDescription.setText(Description);
    }

    public void setLbLangues(String Langues) {
        this.lbLangues.setText(Langues);
    }

    public void setLbCompétences(String Compétences) {
        this.lbCompétences.setText(Compétences);
    }

    public void setLbFormation(String Formation) {
        this.lbFormation.setText(Formation);
    }

    public void setLbExperiences_professionnelles(String Experiences_professionnelles) {
        this.lbExperiences_professionnelles.setText(Experiences_professionnelles);
    }

    public void setLbDiplome(String Diplome) {
        this.lbDiplome.setText(Diplome);
    }

   
    
}
