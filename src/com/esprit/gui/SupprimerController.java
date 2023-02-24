/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Projet;
import com.esprit.services.ServiceProjet;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SupprimerController implements Initializable {

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
    @FXML
    private TextField tfid;
    
    ObservableList<Projet> listp;
     int index = -1;
    
    Connection cnx =null;
   ResultSet result = null;
   Statement st = null;
    @FXML
    private Button tfsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialisation du tableau
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
    
      listp=DataSource.getDataproj();
       //listp=DataSource.afficher();
        tableprojet.setItems(listp);
    }    

    @FXML
    private void Delete(ActionEvent event)throws IOException{
        
           
      ServiceProjet sp3 = new ServiceProjet();
        sp3.supprimer(new Projet(Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "Projet supprime !");  
          
            
            
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLhello.fxml"));
        Parent root = loader.load();
       tfsup.getScene().setRoot(root);
        FXMLhelloController dpc = loader.getController();
            
        }
        
    }
    

