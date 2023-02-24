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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CcController implements Initializable {

    @FXML
    private ImageView tfimg;

    /**
     * Initializes the controller class.
     */
     Image image = new Image(getClass().getResourceAsStream("hee.jpg"));
    @FXML
    private ImageView tf1;
    @FXML
    private ImageView tf2;
    @FXML
    private ImageView tf3;
    @FXML
    private ImageView tf4;
    @FXML
    private Button tfcons;
    @FXML
    private Button tfcher;
    @FXML
    private Button tfcon;
    
     public void displayImage(){
        tfimg.setImage(image);
        tf1.setImage(image);
        tf2.setImage(image);
        tf3.setImage(image);
        tf4.setImage(image);
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //Image image = new Image("C:\\Users\\asus\\Desktop\\projet pidev\\Projetttt\\src\\com\\esprit\\gui\\hee.jpg");
      
      
}
    
     /*  @FXML
    private void consulter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfcons.getScene().setRoot(root);
        ConsultmediaController dpc = loader.getController();
    }
*/
    /* @FXML
    private void deeep(ActionEvent event) 
        
        throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
       tfcher.getScene().setRoot(root);
       TypeconsController dpc = loader.getController();
    }*/
    
 // TODO

    @FXML
    private void ger(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLhello.fxml"));
        Parent root = loader.load();
       tfcons.getScene().setRoot(root);
        FXMLhelloController dpc = loader.getController();
    }

    @FXML
    private void deeep(ActionEvent event) 
        
        throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
       tfcher.getScene().setRoot(root);
       TypeconsController dpc = loader.getController();
    }

    @FXML
    private void consulter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfcon.getScene().setRoot(root);
        ConsultmediaController dpc = loader.getController();
    }
    }    
     

