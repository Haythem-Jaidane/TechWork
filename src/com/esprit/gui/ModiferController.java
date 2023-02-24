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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModiferController implements Initializable {

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
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfdom;
    @FXML
    private TextField tfid;
ObservableList<Projet> listp;
  ObservableList<Projet> dataList;
     int index = -1;
    
    Connection cnx =null;
   ResultSet result = null;
   Statement st = null;
    @FXML
    private Button tfmodif;
    @FXML
    private TextField tf;
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
        // TODO
         search_user();
    } 
    
    

    @FXML
    private void modifierproj(ActionEvent event) throws IOException {
               ServiceProjet sp2 = new ServiceProjet();
        sp2.modifier(new Projet(Integer.parseInt(tfid.getText()),tfnom.getText(), tfdesc.getText(), tfdom.getText()));
        JOptionPane.showMessageDialog(null, "Projet edite !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLhello.fxml"));
        Parent root = loader.load();
       tfmodif.getScene().setRoot(root);
        FXMLhelloController dpc = loader.getController();
    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = tableprojet.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfid.setText(colid.getCellData(index).toString());
    tfnom.setText(colnom.getCellData(index).toString());
    tfdesc.setText(coldesc.getCellData(index).toString());
    tfdom.setText(coldom.getCellData(index).toString());
        
    }
    
     void search_user() {          
         colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
        
        dataList = DataSource.getDataproj();
        tableprojet.setItems(dataList);
        FilteredList<Projet> filteredData = new FilteredList<>(dataList, b -> true);  
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(projet -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (String.valueOf(projet.getId()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
    // Le code ici sera exécuté si l'ID du projet (converti en chaîne de caractères) correspond à la valeur filtrée

     return true; // Filter matches username
    } else if (projet.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else if (projet.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    return true; // Filter matches password
    }
    else if (String.valueOf(projet.getDomaine()).indexOf(lowerCaseFilter)!=-1)
         return true;// Filter matches email
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<Projet> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(tableprojet.comparatorProperty());  
  tableprojet.setItems(sortedData);      
    }
    
    
}
