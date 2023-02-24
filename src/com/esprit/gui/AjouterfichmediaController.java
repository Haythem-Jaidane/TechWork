/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.FichMedia;
import com.esprit.entities.Projet;
import com.esprit.services.ServiceFichMedia;
import com.esprit.services.ServiceProjet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouterfichmediaController implements Initializable {

    @FXML
   private TextField tfid;
    @FXML
    private TextField tfurl;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfnommedia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /* ObservableList<Projet> listProjet = FXCollections.observableArrayList();
    listProjet.addAll(ServiceProjet.listProjet);
    if (!listProjet.isEmpty()) {
        tfid.setValue(listProjet.get(0).getId());
        tfid.setItems(listProjet);
    }*/
    }    
    @FXML
    private void ajouterfichmedia(ActionEvent event) throws IOException {
        ServiceFichMedia sfm = new ServiceFichMedia();
        sfm.ajouter(new FichMedia(tfnommedia.getText(), tfurl.getText(),tftype.getText(),Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "fich media ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Detailsfichmedia.fxml"));
        Parent root = loader.load();
        tfnommedia.getScene().setRoot(root);
        
        DetailsfichmediaController dpc = loader.getController();
        dpc.setLbnommedia(tfnommedia.getText());
        dpc.setLburl(tfurl.getText());
        dpc.setLbtype(tftype.getText());
        //dpc.setLbid(Integer.parseInt(tfid.getText()));
        
    }

}
