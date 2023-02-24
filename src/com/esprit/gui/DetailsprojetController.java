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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DetailsprojetController implements Initializable {

    @FXML
    private TableView<Projet> tableprojet;
    @FXML
    private TableColumn<Projet,Integer> colid;
    @FXML
    private TableColumn<Projet,String> colnom;
    @FXML
    private TableColumn<Projet,String> coldesc;
    @FXML
    private TableColumn<Projet,String> coldom;
ObservableList<Projet> listp;
    //ObservableList<Projet> dataList;
    
   
    
    int index = -1;
    
    Connection cnx =null;
    ResultSet result = null;
    Statement st = null;
    @FXML
    private Button tffichmedia;
    @FXML
    private Button tfret;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
     
      listp=DataSource.getDataproj();
      //listp=DataSource.afficher();
        tableprojet.setItems(listp);
    }    
   /* public void setLbid (int id) {
        this.lbid.;
    }*//*
     public void setLbNom(String nom) {
        this.lbNom.setText(nom);
    }
    public void setLbdesc(String description) {
        this.lbdesc.setText(description);
    }
   
public void setLbdom(String domaine) {
        this.lbdom.setText(domaine);
    }*/

    @FXML
    private void deplacer(ActionEvent event)throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajouterfichmedia.fxml"));
        Parent root = loader.load();
       tffichmedia.getScene().setRoot(root);
        AjouterfichmediaController dpc = loader.getController();
    }

    @FXML
    private void retourr(ActionEvent event) 
         throws IOException{
        //code net3ada min interface l interface 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLhello.fxml"));
        Parent root = loader.load();
       tfret.getScene().setRoot(root);
        FXMLhelloController dpc = loader.getController();
    }
   

}
