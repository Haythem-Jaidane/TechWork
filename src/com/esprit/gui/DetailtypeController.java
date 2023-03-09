/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DetailtypeController implements Initializable {

    @FXML
    private Label lbtype;
    @FXML
    private Label lbdesc;
    @FXML
    private Button tfret;
    @FXML
    private ImageView tfimg;
Image image = new Image(getClass().getResourceAsStream("logo WorkTech.PNG"));
    public void displayImage(){
       
        tfimg.setImage(image);}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setlbtype(String nomtype) {
        this.lbtype.setText(nomtype);
    }
    public void setlbdesc(String descriptiontype) {
        this.lbdesc.setText(descriptiontype);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
       tfret.getScene().setRoot(root);
      TypeconsController dpc = loader.getController();
    }

}
