/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package API;

import entities.Offre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class EditOffreController implements Initializable {

    @FXML
    private TextField tfTitle;
    @FXML
    private TextArea tfDesc;
    @FXML
    private TextField tfPost;
    @FXML
    private TextField tfSalaire;
    @FXML
    private TextField tfLieuu;
    @FXML
    private TextField tfDuree;
    @FXML    
    private ChoiceBox <String> cbContrat;
    private String[] typeContrats ={"CDI: Contrat de travail à durée indéterminée","CDD: Contrat à durée déterminée","CEI: Chèque-emploi associatif","CESU: Chèque emploi-service universel"};
    
    @FXML    
    private ChoiceBox <String> cbDomaine;
    private String[] domainesWork ={"Informatique","Assurance","Agriculture","Alimentation","Architecture","Art","Banque","Biologie","Chimie","Design","Finance","Marketing","Mode","Autre"};
   
    @FXML
    private TextField tfId;
    @FXML
    private ChoiceBox<String> cbStatus;
        private String[] status ={"Disponible","Non Disponible"};
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbContrat.getItems().addAll(typeContrats);
        cbDomaine.getItems().addAll(domainesWork);
        cbStatus.getItems().addAll(status);
    }    

 
    void setTextField(int id, String titre, String description, String post, int salaire, String lieu, String TypeContrat, int duree, String status, String DomaineOffre, String nomRecruteur, String emailRecruteur)   {

        tfId.setText(Integer.toString(id));
        tfTitle.setText(titre); 
        tfDesc.setText(description); 
        tfPost.setText(post); 
        tfSalaire.setText(Integer.toString(salaire));         
        tfLieuu.setText(lieu); 
        tfDuree.setText(Integer.toString(duree));     
//        cbContrat.setValue(null); 
      //  cbDomaine.setValue(null); 
        cbStatus.setValue(null); 
    } 
 
    @FXML
    private void modifier(ActionEvent event) {
     ServiceOffre s = new ServiceOffre();
      //  int k=Integer.parseInt(tfId.getText());
      String h = cbContrat.getValue();
        s.modifier(new Offre( Integer.parseInt(tfId.getText()),tfTitle.getText(),tfDesc.getText(),
                tfPost.getText(),Integer.parseInt(tfSalaire.getText()),tfLieuu.getText(),cbContrat.getValue(),Integer.parseInt(tfDuree.getText()),
                cbStatus.getValue(),cbDomaine.getValue(),"Esprit","Esprit@gmail.com"));
 /*       JOptionPane.showMessageDialog(null, "Offre "+tfTitle.getText()+" modifié avec succès.");
        */
         if (tfTitle.getText().isEmpty() || tfDesc.getText().isEmpty() || tfPost.getText().isEmpty() || tfLieuu.getText().isEmpty() 
                || cbContrat.getValue().isEmpty() || cbDomaine.getValue().isEmpty()||cbStatus.getValue().isEmpty()
                 || tfSalaire.getText().isEmpty() || tfDuree.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
           //  alert.setHeaderText(null);
            alert.setContentText("Informations Manquantes");
            alert.showAndWait();}
        
 
        else if (!(tfSalaire.getText().matches("[0-9]+")) && !(tfDuree.getText().matches("[0-9]+"))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("ok");
            alert.setContentText("Le salaire et la durée doivent être en chiffres");
            alert.showAndWait();}
        
         
        else{
        
                JOptionPane.showMessageDialog(null, "Offre "+tfTitle.getText()+" modifié avec succès.");
    }
         
    }
    
    @FXML
    private void btnClear() {
        tfId.setText(null);
        tfTitle.setText(null); 
        tfDesc.setText(null); 
        tfPost.setText(null); 
        tfSalaire.setText(null);         
        tfLieuu.setText(null); 
        tfDuree.setText(null);     
        cbContrat.setValue(null); 
        cbDomaine.setValue(null); 
        cbStatus.setValue(null);
        }
    
}
