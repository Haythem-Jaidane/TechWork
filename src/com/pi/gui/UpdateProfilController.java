/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;

import com.pi.entities.Profil;
import com.pi.services.ServiceProfil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateProfilController  {

    @FXML
    private TextField fxNuméro_téléphone;
    @FXML
    private TextField fxE_mail;
    @FXML
    private TextField fxLocalisation;
    @FXML
    private TextField fxDescription;
    @FXML
    private TextField fxLangues;
    @FXML
    private TextField fxCompetences;
    @FXML
    private TextField fxFormation;
    @FXML
    private TextField fxExperiences_professionnelles;
    @FXML
    private TextField fxDiplome;
    
    private int id;

    ServiceProfil sp = new ServiceProfil();
    Profil p;

    public void setId(int id) {
        this.id = id;
    }

    public void getalldata() {

        p = sp.getProfilById(id);
        fxNuméro_téléphone.setText(p.getNuméro_téléphone());
        fxE_mail.setText(p.getE_mail());
        fxLocalisation.setText(p.getLocalisation());
        fxDescription.setText(p.getDescription());
        fxLangues.setText(p.getLangues());
        fxCompetences.setText(p.getCompetences());
        fxFormation.setText(p.getFormation());
        fxExperiences_professionnelles.setText(p.getExperiences_professionnelles());
        fxDiplome.setText(p.getDiplome());
        
   }
   
   
  
    @FXML
    private void UpdateProfil(ActionEvent event) {
        p.setNuméro_téléphone(fxNuméro_téléphone.getText());
        p.setE_mail(fxE_mail.getText());
        p.setLocalisation(fxLocalisation.getText());
        p.setDescription(fxDescription.getText());
        p.setLangues(fxLangues.getText());
        p.setCompetences(fxCompetences.getText());
        p.setFormation(fxFormation.getText());
        p.setExperiences_professionnelles(fxExperiences_professionnelles.getText());
        p.setDiplome(fxDiplome.getText());
        

        System.out.println(p);
        sp.modifier(p);
        

    }
    
}
