/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Projet;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLhelloController implements Initializable {

   
    @FXML
    private Button tfAjout;
    @FXML
    private TableView<Projet> tab1;
    @FXML
    private TableColumn<Projet,Integer> colid;
    @FXML
    private TableColumn<Projet,String> colnom;
    @FXML
    private TableColumn<Projet,String> coldesc;
    @FXML
    private TableColumn<Projet,String> coldom;
 ObservableList<Projet> listp;
     int index = -1;
    
    Connection cnx =null;
   ResultSet result = null;
   Statement st = null;
    @FXML
    private Button tfmodif;
    @FXML
    private Button tfsup;
   // @FXML
   // private Button tfcons;
    @FXML
    private Button tfcher;
    @FXML
    private ImageView tfaj;
    @FXML
    private ImageView tfm;
    @FXML
    private ImageView tfs;
   
   // private Button tfdeeep;
    /**
     * Initializes the controller class.
     */
     Image image = new Image(getClass().getResourceAsStream("sup.PNG"));
    @FXML
    private ImageView tfc;
    @FXML
    private ImageView tfar;
          public void displayImage(){
        tfc.setImage(image);
        tfaj.setImage(image);
        tfm.setImage(image);
        tfs.setImage(image);
         tfar.setImage(image);
       
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                //initialisation du tableau
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
     
      listp=DataSource.getDataproj();
      //listp=DataSource.afficher();
        tab1.setItems(listp);
    }    

    @FXML
    private void ajout(ActionEvent event) throws IOException{
        //code net3ada min interface l interface 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterprojet.fxml"));
        Parent root = loader.load();
       tfAjout.getScene().setRoot(root);
        AjouterprojetController dpc = loader.getController();
    }

    @FXML
    private void modif(ActionEvent event)throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifer.fxml"));
        Parent root = loader.load();
       tfmodif.getScene().setRoot(root);
        ModiferController dpc = loader.getController();
    }

    @FXML
    private void supp(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Supprimer.fxml"));
        Parent root = loader.load();
       tfsup.getScene().setRoot(root);
        SupprimerController dpc = loader.getController();
    }

  /*  @FXML
    private void consulter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfcons.getScene().setRoot(root);
        ConsultmediaController dpc = loader.getController();
    }
*/
    @FXML
    private void dep(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifer.fxml"));
        Parent root = loader.load();
       tfcher.getScene().setRoot(root);
        ModiferController dpc = loader.getController();
     
    }

   /* @FXML
    private void deeep(ActionEvent event) 
        
        throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
       tfcher.getScene().setRoot(root);
       TypeconsController dpc = loader.getController();
    }*/
}
