/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI ;

import com.esprit.GUI.CandidatReadOffresController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class RecruteurDetailsOffreController implements Initializable {

    private TextField tfTitre;
    @FXML
    private Label lbTitre;
    @FXML
    private Label lbPost;
    @FXML
    private Label lbLieu;
    @FXML
    private Label lbSalaire;
    @FXML
    private Label lbDuree;
    @FXML
    private Label lbContrat;
    @FXML
    private Label lbDomaine;
    @FXML
    private Label lbDesc;
    @FXML
    private Label lbStatus;
    @FXML
    private Label lbNomRec;
    @FXML
    private Label lbEmailRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setLbTitre(String titre) {
        this.lbTitre.setText(titre);
    }

    public void setLbPost(String lbPost) {
        this.lbPost.setText(lbPost);
    }

    public void setLbLieu(String lbLieu) {
        this.lbLieu.setText(lbLieu);
    }

    public void setLbSalaire(String lbSalaire) {
        this.lbSalaire.setText(lbSalaire);
    }

    public void setLbDuree(String lbDuree) {
        this.lbDuree.setText(lbDuree);
    }

    public void setLbContrat(String lbContrat) {
        this.lbContrat.setText(lbContrat);
    }

    public void setLbDomaine(String lbDomaine) {
        this.lbDomaine.setText(lbDomaine);
    }

    public void setLbDesc(String lbDesc) {
        this.lbDesc.setText(lbDesc);
    }

    public void setLbStatus(String lbStatus) {
        this.lbStatus.setText("Disponible");
    }

    public void setLbNomRec(String lbNomRec) {
        this.lbNomRec.setText("Test");
    }

    public void setLbEmailRec(String lbEmailRec) {
        this.lbEmailRec.setText("Test@test.com");
    }


 
    @FXML
    private void btnListeOffres(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("RecruteurReadOffres.fxml")); 
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RecruteurReadOffresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
