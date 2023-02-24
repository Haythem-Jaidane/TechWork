/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;

import com.pi.entities.Publication;
import com.pi.services.ServicePublication;
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
public class GestionPublicationController {

    @FXML
    private AnchorPane fxidGestionPub;
    @FXML
    private Label fxInputFieldP;

    public void initialize() {
        double x = fxInputFieldP.getLayoutX(); // get the layout X value of the label
        double y = fxInputFieldP.getLayoutY(); // get the layout Y value of the label
        ServicePublication sp = new ServicePublication();
        ArrayList<Publication> lp1 = (ArrayList<Publication>) sp.afficher();
        for (int i = 0; i < lp1.size(); i++) {
            System.out.println(lp1.get(i));
            Label label = new Label("Objet:" + lp1.get(i).getObjet() + "/ Message :" + lp1.get(i).getMessage());
            label.setLayoutY(y + ((i + 1) * 40));
            label.setLayoutX(x - 200);
            fxidGestionPub.getChildren().add(label);

            //update buton 
            Button myButton1 = new Button("Update");
            myButton1.setLayoutX(x + 30);
            myButton1.setLayoutY(y + ((i + 1) * 60));
            myButton1.setStyle("-fx-background-color: #00ffa2; -fx-text-fill: #ffffff; -fx-font-size: 10px;");
            myButton1.setPrefSize(50, 5);
            myButton1.setUserData(lp1.get(i).getId_Pub());
            myButton1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Publication p = sp.getPublicationById((int) myButton1.getUserData());
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdatePublication.fxml"));
                        Parent root = loader.load();
                        UpdatePublicationController upc = loader.getController();
                        upc.setId(p.getId_Pub());
                        fxidGestionPub.getScene().setRoot(root);
                        upc.getalldata();

                    } catch (IOException ex) {
                    }

                }
            });
            fxidGestionPub.getChildren().add(myButton1);
            //delete buton 
            Button myButton = new Button("Delete");
            myButton.setLayoutX(x + 150);
            myButton.setLayoutY(y + ((i + 1) * 60));
            myButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-font-size: 10px;");
            myButton.setPrefSize(50, 5);
            myButton.setUserData(lp1.get(i).getId_Pub());
            myButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(myButton.getUserData());
                    Publication p = sp.getPublicationById((int) myButton.getUserData());
                    sp.supprimer(p);
                }
            });
            fxidGestionPub.getChildren().add(myButton);
        }

    }

}
