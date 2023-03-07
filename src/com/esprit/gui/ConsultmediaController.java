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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class ConsultmediaController implements Initializable {

    @FXML
    private TableView<FichMedia> tabmedia;
    @FXML
    private TableColumn<FichMedia, String> colnom;
    @FXML
    private TableColumn<FichMedia, String> colurl;
    @FXML
    private TableColumn<FichMedia, String> coltype;
    @FXML
    private TableColumn<FichMedia, Integer> colid;
    @FXML
    private Button tfajout;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfurl;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfid;
ObservableList<FichMedia> listt;
    //ObservableList<Projet> dataList;
    
   //CONTROLE DE SAISI + METIER +JOINTIURE
    
    int index = -1;
    
    Connection cnx =null;
    ResultSet result = null;
    Statement st = null;
    @FXML
    private TableColumn<FichMedia,Integer> colref;
    @FXML
    private TextField tfref;
    @FXML
    private Button tfmodif;
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
       
        colnom.setCellValueFactory(new PropertyValueFactory<FichMedia,String>("nommedia"));
        colurl.setCellValueFactory(new PropertyValueFactory<FichMedia,String>("urlmedia"));
        coltype.setCellValueFactory(new PropertyValueFactory<FichMedia, String>("typemedia"));
        colid.setCellValueFactory(new PropertyValueFactory<FichMedia,Integer>("id"));
        colref.setCellValueFactory(new PropertyValueFactory<FichMedia,Integer>("idmedia"));
     
      listt=DataSource.getDatamedia();
      //listp=DataSource.afficher();
        tabmedia.setItems(listt);
    }    

    @FXML
    private void modifier(ActionEvent event) throws IOException{
        ServiceFichMedia sp3 = new ServiceFichMedia();
        index = tabmedia.getSelectionModel().getSelectedIndex();
          if (tfref.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("SELECTIONER FICHIER POUR LE MODIFIER ");
            alert.showAndWait();
       } else {
        sp3.modifier(new FichMedia(Integer.parseInt(tfref.getText()),tfnom.getText(), tfurl.getText(), tftype.getText(), Integer.parseInt(tfid.getText()))) ;
        JOptionPane.showMessageDialog(null, "FICHIER MEDIA MODIFIE !");
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfajout.getScene().setRoot(root);
      ConsultmediaController dpc = loader.getController();
          }
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajouterfichmedia.fxml"));
        Parent root = loader.load();
       tfajout.getScene().setRoot(root);
       AjouterfichmediaController dpc = loader.getController();
    }

    @FXML
    private void select(MouseEvent event) {
        
        index = tabmedia.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfref.setText(colref.getCellData(index).toString());
    tfnom.setText(colnom.getCellData(index).toString());
    tfurl.setText(colurl.getCellData(index).toString());
    tftype.setText(coltype.getCellData(index).toString());
    tfid.setText(colid.getCellData(index).toString());
    
        
    
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
          ServiceFichMedia sp3 = new ServiceFichMedia();
            if (tfref.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("SELECTIONNER UN FICHIER ! ");
            alert.showAndWait();
       } else {
        sp3.supprimer(new FichMedia(Integer.parseInt(tfref.getText())));
        JOptionPane.showMessageDialog(null, "fichier  supprime !");}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfajout.getScene().setRoot(root);
      ConsultmediaController dpc = loader.getController();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Cc.fxml"));
        Parent root = loader.load();
       tfret.getScene().setRoot(root);
      CcController dpc = loader.getController();
    }
    
    
}
