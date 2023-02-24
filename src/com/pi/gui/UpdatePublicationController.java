/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pi.gui;

import com.pi.entities.Publication;
import com.pi.services.ServicePublication;
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
public class UpdatePublicationController {

    @FXML
    private TextField fxObjet;
    @FXML
    private TextField fxMessage;

    private int id;

    ServicePublication sp = new ServicePublication();
    Publication p;

    public void setId(int id) {
        this.id = id;
    }

    public void getalldata() {

        p = sp.getPublicationById(id);
        fxObjet.setText(p.getObjet());
        fxMessage.setText(p.getMessage());
        
        
   }
   
   
  
    @FXML
    private void UpdatePublication(ActionEvent event) {
        p.setObjet(fxObjet.getText());
        p.setMessage(fxMessage.getText());
       
        

        System.out.println(p);
        sp.modifier(p);
        

    }
    

   
}
