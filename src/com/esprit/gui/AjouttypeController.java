/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Projet;
import com.esprit.entities.TypeProjet;
import com.esprit.services.ServiceProjet;
import com.esprit.services.ServiceTypeProjet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouttypeController implements Initializable {

    @FXML
    private TextField tft;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfid;
    @FXML
    private Button tfaj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event)  throws IOException {
       
        ServiceTypeProjet sp4 = new ServiceTypeProjet();
        sp4.ajouter(new TypeProjet(tft.getText(), tfdesc.getText(), Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "type ajoutée !");
        // interface o5ra tjini ba3ed l ok
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
        tft.getScene().setRoot(root);
     
        TypeconsController dpc = loader.getController();
    }
    
}
