/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Projet;
import com.esprit.entities.TypeProjet;
import com.esprit.services.ServiceProjet;
import com.esprit.services.ServiceTypeProjet;
import com.esprit.utils.DataSource;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
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
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouttypeController implements Initializable {

    @FXML
    private TextField tft;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfid;
    @FXML
    private Button tfaj;
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
private static final String ACCOUNT_SID = "AC0f74c61c9ed9455ce572deb3e1266124";
    private static final String AUTH_TOKEN = "528ac835ab2c810fa635a9f451a946da";
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
    private void ajouter(ActionEvent event)  throws IOException {
        
        ServiceTypeProjet sp4 = new ServiceTypeProjet();
           if (tft.getText().isEmpty() ||  tfdesc.getText().isEmpty() || tfid.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("SELECTIONNER UN PROJET REMPLIR TOUS LES CHAMPS !");
            alert.showAndWait();
            
        } else {
        sp4.ajouter(new TypeProjet(tft.getText(), tfdesc.getText(), Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "CATEGORIE AJOUTE !");
       
        
/*

    // Replace ACCOUNT_SID and AUTH_TOKEN with your own credentials

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber("+21695643106"),
                new PhoneNumber("+21695643106"),
                "Hello from Java!")
            .create();

        System.out.println(message.getSid());*/
    }




// interface o5ra tjini ba3ed l ok
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Detailtype.fxml"));
        Parent root = loader.load();
        tft.getScene().setRoot(root);
        
        DetailtypeController dpc = loader.getController();
        dpc.setlbtype(tft.getText());
        dpc.setlbdesc(tfdesc.getText());
    }

    @FXML
    private void select(javafx.scene.input.MouseEvent event) {
        index = tableprojet.getSelectionModel().getSelectedIndex();
    if (index <= -1){
        return;
    }
    tfid.setText(colid.getCellData(index).toString());       
    }

    @FXML
    private void tfdep(ActionEvent event)throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
       tft.getScene().setRoot(root);
      TypeconsController dpc = loader.getController();
    }
}
