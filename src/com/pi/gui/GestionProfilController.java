/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;

import com.pi.entities.Profil;
import com.pi.services.ServiceProfil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionProfilController  {

    @FXML
    private AnchorPane fxIdGestionProfil;
    @FXML
    private Label fxInputField;

public void initialize() {
        double x = fxInputField.getLayoutX(); // get the layout X value of the label
        double y = fxInputField.getLayoutY(); // get the layout Y value of the label
        ServiceProfil sp = new ServiceProfil();
        ArrayList<Profil> lp = (ArrayList<Profil>) sp.afficher();
        for (int i = 0; i < lp.size(); i++) {
            System.out.println(lp.get(i));
            Label label = new Label("Numéro de téléphone:"+ lp.get(i).getNuméro_téléphone()+ "/ E-mail :" + lp.get(i).getE_mail()+ "/ Localisation:" + lp.get(i).getLocalisation()+ "/ Description:" +lp.get(i).getDescription()+ "/ Langues " + lp.get(i).getLangues()+ " / Compétences :" + lp.get(i).getCompetences()+ "/Formation: " + lp.get(i).getFormation()+ "/Experiences_professionnelles: " + lp.get(i).getExperiences_professionnelles()+ "/Diplome: " + lp.get(i).getDiplome() );
            label.setLayoutY(y + ((i + 1) * 40));
            label.setLayoutX(x-200);
            fxIdGestionProfil.getChildren().add(label);
            
        //update buton 
            Button myButton1 = new Button("Update");
            myButton1.setLayoutX(x + 30);
            myButton1.setLayoutY(y + ((i + 1) * 60));
            myButton1.setStyle("-fx-background-color: #00ffa2; -fx-text-fill: #ffffff; -fx-font-size: 10px;");
            myButton1.setPrefSize(50, 5);
            myButton1.setUserData(lp.get(i).getId_Profil());
            myButton1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Profil p= sp.getProfilById((int) myButton1.getUserData());
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateProfil.fxml"));
                        Parent root = loader.load();
                        UpdateProfilController upc = loader.getController();
                        upc.setId(p.getId_Profil());
                        fxIdGestionProfil.getScene().setRoot(root);
                        upc.getalldata();

                    } catch (IOException ex) {
                    }

                }
            });
            fxIdGestionProfil.getChildren().add(myButton1);
            //delete buton 
            Button myButton = new Button("Delete");
            myButton.setLayoutX(x + 150);
            myButton.setLayoutY(y + ((i + 1) * 60));
            myButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-font-size: 10px;");
            myButton.setPrefSize(50, 5);
            myButton.setUserData(lp.get(i).getId_Profil());
            myButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(myButton.getUserData());
                    Profil p = sp.getProfilById((int) myButton.getUserData());
                    sp.supprimer(p);
                }
            });
            fxIdGestionProfil.getChildren().add(myButton);
        }

    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
