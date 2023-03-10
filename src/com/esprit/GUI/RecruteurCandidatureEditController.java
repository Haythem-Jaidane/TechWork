/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI ;


import com.esprit.services.Mail;
import static com.esprit.GUI.CandidatCandidaturePostulerController.nnn;
import com.esprit.entities.Candidature; 
import com.esprit.entities.Offre;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import com.esprit.services.ServiceCandidature;
import com.esprit.services.ServiceOffre;



import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * FXML Controller class
 *
 * @author Karim
 */
public class RecruteurCandidatureEditController implements Initializable {
    
    @FXML
    private Label lbId;
    @FXML
    private Label lbTitreOffre;
    @FXML
    private Label lbNomRecruteur;
    @FXML
    private Label lbNomCandidat;
    @FXML
    private Label lbDatePostulation;
    @FXML
    private Label lbDateModification;
    @FXML
    private ChoiceBox<String> cbStatus;
    private String[] status_candidatures ={"Pending","Acceptée","Rejetée"/*,"Annulée"*/};
  
    @FXML
    private TextArea tfInformation;
    public static Offre vvv;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbStatus.getItems().addAll(status_candidatures);
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
  
    }    

    
        void setTextField(Offre offre, int id,  String recruteur, String candidat, String status, String informations, String datePostulation, String dateModification)   {
        
               vvv=offre;
            lbId.setText(Integer.toString(id));
        lbTitreOffre.setText(offre.getTitre()); 
        lbNomRecruteur.setText(recruteur); 
        lbNomCandidat.setText(candidat);  
        lbDatePostulation.setText(datePostulation);     
        lbDateModification.setText(dateModification); 
    } 
 
    
    @FXML
    private void btnConfirmerModif(ActionEvent event) {
     ServiceCandidature s = new ServiceCandidature();
          ServiceOffre o = new ServiceOffre();
     String d = LocalDate.now().toString()   ;
     
     if (cbStatus.getValue().equals("Acceptée")){
         
            o.modifier(new Offre( vvv.getId(),vvv.getTitre(),vvv.getDescription(),
               vvv.getPost(),vvv.getSalaire(),vvv.getTypeContrat(),vvv.getTypeContrat(),vvv.getDuree(),
                "Plus disponible",vvv.getDomaineOffre(),vvv.getNomRecruteur(),vvv.getEmailRecruteur()));
      
 
      s.modifier(new Candidature(Integer.parseInt(lbId.getText()),vvv,lbNomRecruteur.getText(),lbNomCandidat.getText(),
        cbStatus.getValue(),tfInformation.getText(),lbDatePostulation.getText(),d));
           JOptionPane.showMessageDialog(null, "Candidature acceptée");
           
           
            Mail mail=new Mail();
             // mail.envoyerCode("a","a");
         //   Mail acceptedMail = new Mail();
             mail.envoyerMail(              
                    "bouraouines5@gmail.com",
                     
                    "Candidature acceptée",
                    
                    "Cher "+lbNomCandidat.getText()+",\n\n\n"
                            
                            
                     + "Félicitation ! votre candidature pour l'offre " + vvv.getTitre() + " à été acceptée !\n\n"
                     + "Les raisons qui ont contribuées a ce succès, sont :"
                     +   "\n" +   tfInformation.getText()+".\n\n\n"                     
                     + "Bonne journée.");
   
           
           
           
     }
    
      else if (cbStatus.getValue().equals("Rejetée")){
      s.modifier(new Candidature(Integer.parseInt(lbId.getText()),vvv,lbNomRecruteur.getText(),lbNomCandidat.getText(),
        cbStatus.getValue(),tfInformation.getText(),lbDatePostulation.getText(),d));
           JOptionPane.showMessageDialog(null, "Candidature rejetée");
              Mail mail=new Mail();
             // mail.envoyerCode("a","a");
         //   Mail acceptedMail = new Mail();
             mail.envoyerMail(
                    
                    "bouraouines5@gmail.com",
                     
                    "Candidature refusée",
                    
                    "Cher "+lbNomCandidat.getText()+",\n\n\n"
                            
                            
                     + "Malheuresement votre candidature pour l'offre " + vvv.getTitre() + " à été rejetée pour les raisons suivantes :"
                     +   "\n" +   tfInformation.getText()+"\n\n"+
                     "Mais ne vous inquietez pas! TechWork propose plusieurs d'autres opportunités.\n\n\n"
                             
                             
                     + "Bonne journée.");
     }
        
         
    }
    
}
