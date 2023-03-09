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
public class DetailsfichmediaController implements Initializable {

    @FXML
    private Label Lbnommedia;
    @FXML
    private Label Lburl;
    @FXML
    private Label Lbtype;
    @FXML
    private Button tfretour;
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
     public void setLbnommedia(String nommedia) {
        this.Lbnommedia.setText(nommedia);
    }
    public void setLburl(String urlmedia) {
        this.Lburl.setText(urlmedia);
    }
    public void setLbtype(String typemedia) {
        this.Lbtype.setText(typemedia);
    }
   /* public void setLbid(int id) {
        this.Lbid.setText(id);
                
         }*/

    @FXML
    private void retour(ActionEvent event)  throws IOException{
        //code net3ada min interface l interface 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfretour.getScene().setRoot(root);
        ConsultmediaController dpc = loader.getController();
    }

  
}
