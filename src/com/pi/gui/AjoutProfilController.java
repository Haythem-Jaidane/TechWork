/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;

import com.pi.entities.Profil;
import com.pi.services.ServiceProfil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutProfilController implements Initializable {
    
    @FXML
    private TextField tfNuméro_téléphone;
    @FXML
    private TextField tfE_mail;
    @FXML
    private TextField tfLocalisation;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfLangues;
    @FXML
    private TextField tfCompétences;
    @FXML
    private TextField tfFormation;
    @FXML
    private TextField tfExperiences_professionnelles;
    @FXML
    private TextField tfDiplome;
   
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    private void AjoutProfil(ActionEvent event) throws IOException {
        ServiceProfil sp = new ServiceProfil();
        sp.ajouter(new Profil(tfNuméro_téléphone.getText(),tfE_mail.getText(), tfLocalisation.getText(), 
                tfDescription.getText(), tfLangues.getText(), tfCompétences.getText(),tfFormation.getText(), tfExperiences_professionnelles.getText(),tfDiplome.getText()));
        JOptionPane.showMessageDialog(null, "Profil ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsProfil.fxml")); 
        Parent root = loader.load();
        tfNuméro_téléphone.getScene().setRoot(root);
       
        
        DetailsProfilController dpc = loader.getController();
        dpc.setLbNuméro_téléphone(tfNuméro_téléphone.getText());
        dpc.setLbE_mail(tfE_mail.getText());
        dpc.setLbLocalisation(tfLocalisation.getText());
        dpc.setLbDescription(tfDescription.getText());
        dpc.setLbLangues(tfLangues.getText());
        dpc.setLbCompétences(tfCompétences.getText());
        dpc.setLbFormation(tfFormation.getText());
        dpc.setLbExperiences_professionnelles(tfExperiences_professionnelles.getText());
        dpc.setLbDiplome(tfDiplome.getText());
       
                

    }
        // TODO
    }    
    

