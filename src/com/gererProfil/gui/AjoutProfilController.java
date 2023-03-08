/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gererProfil.gui;

import com.gererProfil.entities.Profil;
import com.gererProfil.services.ServiceProfil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutProfilController implements Initializable {

    @FXML
    private TextField fxId;
    @FXML
    private TextField fxNom;
    @FXML
    private TextField fxPrenom;
    @FXML
    private TextField fxNum;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxLocalisation;
    @FXML
    private TextField fxDes;
    @FXML
    private TextField fxLangues;
    @FXML
    private TextField fxComp;
    @FXML
    private TextField fxFormation;
    @FXML
    private TextField fxExp;
    private TextField fxDiplome;
    @FXML
    private RadioButton gr1;
    @FXML
    private RadioButton gr2;
    @FXML
    private ToggleGroup group1;
    @FXML
    private TextField latitude;
    @FXML
    private TextField longitude;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 String diplom;
    @FXML
    private void Save(MouseEvent event) throws IOException {
        
       if (fxNom.getText().isEmpty()
               || fxPrenom.getText().isEmpty()
               || fxNum.getText().isEmpty()
               || fxEmail.getText().isEmpty()
               || fxLocalisation.getText().isEmpty()
               || fxDes.getText().isEmpty()
               || fxLangues.getText().isEmpty()
               || fxComp.getText().isEmpty()
               || fxFormation.getText().isEmpty()
               || fxExp.getText().isEmpty()
               || latitude.getText().isEmpty()
               || longitude.getText().isEmpty()){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajouter incorrect!!");
		alert.setHeaderText("check your information before add new one ");
		alert.setContentText("failed!");

		alert.showAndWait();
           }  
        
        else {
        ServiceProfil sp = new ServiceProfil();
       
         if(gr1.isSelected()){
             diplom="Oui";
        }else if(gr2.isSelected()){
              diplom="Non";
        }
        
        
        sp.ajouter(new Profil(fxNom.getText(), fxPrenom.getText(), fxNum.getText(), fxEmail.getText(), fxLocalisation.getText(), fxDes.getText(), fxLangues.getText(), fxComp.getText(), fxFormation.getText(), fxExp.getText(), latitude.getText(), longitude.getText(), diplom));
        JOptionPane.showMessageDialog(null, "Profil ajoutée !");
        if(sp.profils==1){
               Parent parent = FXMLLoader.load(getClass().getResource("/views/market.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        
        }
            }
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("Affiche.fxml"));
        Parent root = loader.load();
        fxNom.getScene().setRoot(root);*/

 /*AfficheController dpc = loader.getController();
        dpc.setLbNom(tfNom.getText());
        dpc.setLbPrenom(tfPrenom.getText());*/
    }

    @FXML
    private void Clean(MouseEvent event) {
        fxNom.setText(null);
        fxPrenom.setText(null);
        fxNum.setText(null);
        fxEmail.setText(null);
        fxLocalisation.setText(null);
        fxDes.setText(null);
        fxLangues.setText(null);
        fxComp.setText(null);
        fxFormation.setText(null);
        fxExp.setText(null);
        latitude.setText(null);
        longitude.setText(null);
        fxDiplome.setText(null);
    }
}
