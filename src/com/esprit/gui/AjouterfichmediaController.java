/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.FichMedia;
import com.esprit.entities.Projet;
import com.esprit.services.ServiceFichMedia;
import com.esprit.services.ServiceProjet;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
  ObservableList<Projet> dataList;
     int index = -1;
    
    Connection cnx =null;
   ResultSet result = null;
   Statement st = null;
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
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
     
      listp=DataSource.getDataproj();
      //listp=DataSource.afficher();
        tableprojet.setItems(listp);
    
    }    
    @FXML
    private void ajouterfichmedia(ActionEvent event) throws IOException {
        ServiceFichMedia sfm = new ServiceFichMedia();
        if (tfnommedia.getText().isEmpty() ||  tfurl.getText().isEmpty() || tftype.getText().isEmpty() || tfid.getText().isEmpty() ) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("SELECTIONNER UN PROJET REMPLIR TOUS LES CHAMPS !");
            alert.showAndWait();
             //sp1.ajouter(new Projet(tfNom.getText(), tfdesc.getText(), tfdom.getText()));
        } else {
        sfm.ajouter(new FichMedia(tfnommedia.getText(), tfurl.getText(),tftype.getText(),Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "FICHIER MEDIA AJOUTE!");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Detailsfichmedia.fxml"));
        Parent root = loader.load();
        tfnommedia.getScene().setRoot(root);
        
        DetailsfichmediaController dpc = loader.getController();
        dpc.setLbnommedia(tfnommedia.getText());
        dpc.setLburl(tfurl.getText());
        dpc.setLbtype(tftype.getText());}
        //dpc.setLbid(Integer.parseInt(tfid.getText()));
        
    }

    @FXML
    private void select(javafx.scene.input.MouseEvent event) {
        index = tableprojet.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfid.setText(colid.getCellData(index).toString());       
    }
}
