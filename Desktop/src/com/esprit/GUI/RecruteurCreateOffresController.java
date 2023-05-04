/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI ;

import com.esprit.entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.esprit.services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author BOURAOUI
 */
public class RecruteurCreateOffresController implements Initializable {

    @FXML
    private TextField tfTitre;
    @FXML
    private TextArea tfDesc;
    @FXML
    private TextField tfPost;
    @FXML
    private TextField tfSalaire;
    @FXML
    private TextField tfLieu;
  //  @FXML
 //   private TextField tfContrat;
    @FXML
    private TextField tfDuree;
    @FXML
    private TextField tfStatus;
//     @FXML
//    private TextField tfDomaine;
    @FXML    
    private ChoiceBox <String> cbContrat;
    private String[] typeContrats ={"CDI: Contrat de travail à durée indéterminée","CDD: Contrat à durée déterminée","CEI: Chèque-emploi associatif","CESU: Chèque emploi-service universel"};
    
    @FXML    
    private ChoiceBox <String> cbDomaine;
    private String[] domainesWork ={"Informatique","Assurance","Agriculture","Alimentation","Architecture","Art","Banque","Biologie","Chimie","Design","Finance","Marketing","Mode","Autre"};
    @FXML
    private TextField tfContrat;
    @FXML
    private TextField tfDomaine;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbContrat.getItems().addAll(typeContrats);
        cbDomaine.getItems().addAll(domainesWork);
    }    

    @FXML
    private void btnAjouterOffre(ActionEvent event)  throws IOException {
        ServiceOffre s = new ServiceOffre();
         //INTERGRATION : NAME AND EMAIL OF THE CURRENT RECRUTEUR
        String nomRecruteur = "Recruter";
        String mailRecruteur = "Recruter@yahoo.com";
        s.ajouter(new Offre(tfTitre.getText(), tfDesc.getText(), tfPost.getText(), Integer.parseInt(tfSalaire.getText()), tfLieu.getText(), cbContrat.getValue(), Integer.parseInt(tfDuree.getText()), "Disponible", cbDomaine.getValue(),nomRecruteur,mailRecruteur));
        

        
        if (!(tfSalaire.getText().matches("[0-9]+")) && !(tfDuree.getText().matches("[0-9]+"))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("ok");
            alert.setContentText("Le salaire et la durée doivent être en chiffres");
            alert.showAndWait();}
        
        else if (tfTitre.getText().isEmpty() || tfDesc.getText().isEmpty() || tfPost.getText().isEmpty() || tfLieu.getText().isEmpty() 
                || cbContrat.getValue().isEmpty() || cbDomaine.getValue().isEmpty()
                 || tfSalaire.getText().isEmpty() || tfDuree.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
           //  alert.setHeaderText(null);
            alert.setContentText("Informations Manquantes");
            alert.showAndWait();}
        
         
        else{
        
        JOptionPane.showMessageDialog(null, "Nouveau offre "+tfTitre.getText()+" ajouté");
        
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecruteurDetailsOffre.fxml"));
        Parent root = loader.load();
        tfTitre.getScene().setRoot(root);
        
        RecruteurDetailsOffreController c = loader.getController();
        c.setLbTitre(tfTitre.getText()); 
        c.setLbDesc(tfDesc.getText());
        c.setLbPost(tfPost.getText());
        c.setLbSalaire(tfSalaire.getText());
        c.setLbLieu(tfLieu.getText());
        c.setLbContrat(cbContrat.getValue());
        c.setLbDuree(tfDuree.getText());
        c.setLbStatus("Disponible");
        c.setLbDomaine(cbDomaine.getValue());
      //  c.setLbStatus("Disponible");
        c.setLbNomRec(nomRecruteur);
        c.setLbEmailRec(mailRecruteur);
    } }

    @FXML
    private void btnClear() {
        tfTitre.setText(null);
        tfDesc.setText(null);
        tfPost.setText(null);            
        tfSalaire.setText(null);
        tfLieu.setText(null);
   //     cbContrat.setValue(null);             
        tfDuree.setText(null);
        tfStatus.setText(null);
   //     cbDomaine.setValue(null); 
        
 
 
        
        
        
        
        
        
        
        
        
        
        }
 
 
}
