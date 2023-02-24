/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;


import com.pi.entities.Publication;
import com.pi.services.ServicePublication;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutPublicationController implements Initializable {

    @FXML
    private TextField fxObjet;
    @FXML
    private TextField fxMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjoutPublication(ActionEvent event) throws IOException { 
        ServicePublication sp = new ServicePublication();
        sp.ajouter(new Publication(fxObjet.getText(),fxMessage.getText()));
        JOptionPane.showMessageDialog(null, "Publication ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsPublication.fxml")); 
        Parent root = loader.load();
        fxObjet.getScene().setRoot(root);
       
        
        DetailsPublicationController dpc = loader.getController();
        dpc.setlbObjet(fxObjet.getText());
        dpc.setlbMessage(fxMessage.getText());
    
                

    }
    }
    

