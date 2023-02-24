/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;
import com.pi.entities.Publication;
import com.pi.services.ServicePublication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DetailsPublicationController implements Initializable {

    @FXML
    private Label lbObjet;
    @FXML
    private Label lbMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setlbObjet(String objet) {
        this.lbObjet.setText(objet);
    }

    public void setlbMessage(String message) {
        this.lbMessage.setText(message);
    }

    
}
