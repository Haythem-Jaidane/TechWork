/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import static GUI.recruteur.ReadCandidaturesController.off;
import entities.Candidat;
import entities.Candidature;
import entities.Offre;
import entities.Recruteur;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import services.ServiceCandidature;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class CandidatCandidaturePostulerController implements Initializable {

    @FXML
    private Label lbTitreOffre;
    @FXML
    private Label lbNomRecruteur;
    @FXML
    private Label lbNomCandidat;
    @FXML
    private Label lbStatus;
    @FXML
    private Label lbInformation;
    @FXML
    private Label lbDatePostulation;
    @FXML
    private Label lbDateModification;
    
 

    public static Offre nnn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /*
    public void setLbTitreOffre(Offre offre) {
        this.lbTitreOffre.setText(offre.getTitre());
    }

    public void setLbNomRecruteur(Recruteur recruteur) {
        this.lbNomRecruteur.setText(recruteur.getNom());
    }
    
    public void setLbNomCandidat(Candidat candidat) {
        this.lbNomCandidat.setText(candidat.getNom());
    }
    
    public void setLbStatus(String status) {
        this.lbStatus.setText(status);
    }
    
    public void setLbInformations(String informations) {
        this.lbInformations.setText(informations);
    }
        
    public void setLbDateCreation(String datePostulation) {
        this.lbDatePostulation.setText(datePostulation);
    }        
    
    public void setLbDateModification(String dateModification) {
        this.lbDateModification.setText(dateModification);
    }*/
    
    
    
    void setTextField(Offre offre, int id, int idOffre, String recruteur, String candidat, String status, String informations, String datePostulation, String dateModification)   {
       
        
        nnn=offre;
        lbTitreOffre.setText(offre.getTitre()); 
        
        lbNomRecruteur.setText(recruteur); 
        lbNomCandidat.setText(candidat); 
        lbStatus.setText(status);         
        lbInformation.setText(informations); 
        lbDatePostulation.setText(datePostulation);     
        lbDateModification.setText(dateModification); 
    } 

    @FXML
    private void btnAjouter(ActionEvent event)   throws IOException {
      
        ServiceCandidature s = new ServiceCandidature(); 
        s.ajouter(new Candidature(nnn,lbNomRecruteur.getText(),lbNomCandidat.getText(),
        lbStatus.getText(),lbInformation.getText(),lbDatePostulation.getText(),lbDateModification.getText()));
        JOptionPane.showMessageDialog(null, "Candidature ajoutée avec succès.");
        
   /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("ReadCandidatures.fxml"));
        Parent root = loader.load();
        lbTitreOffre.getScene().setRoot(root); */
  
    }

    @FXML
    private void btnModifier(ActionEvent event) {
        try {
     
            Parent parent = FXMLLoader.load(getClass().getResource("CandidatureModifier.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CandidatReadOffresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
