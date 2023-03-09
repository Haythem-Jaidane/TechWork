/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;



import com.esprit.utils.DataSource;
import com.esprit.entities.Projet;
import com.esprit.services.IService;
import com.esprit.services.ServiceProjet;
import static com.lowagie.text.pdf.PdfFileSpecification.url;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javafx.scene.image.Image;
import javax.mail.internet.*;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouterprojetController implements Initializable {
   
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfdesc;
     @FXML
    private TextField tfdom;
    @FXML
    private ImageView tfimg;
    Connection cnx =null;

    //ObservableList<Projet> dataList;
     Image image = new Image(getClass().getResourceAsStream("logo WorkTech.PNG"));
    public void displayImage(){
       
        tfimg.setImage(image);}
   
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*   //initialisation du tableau
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
     
      listp=DataSource.getDataproj();
     
        tableprojet.setItems(listp);*/
    }  
    @FXML
    
    private void Ajouterprojet(ActionEvent event) throws IOException, SQLException {
       
        ServiceProjet sp1 = new ServiceProjet();
       // sp1.ajouter(new Projet(tfNom.getText(), tfdesc.getText(), tfdom.getText()));
        
        
        if (tfNom.getText().isEmpty() || tfdesc.getText().isEmpty() || tfdom.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("REMPLIR TOUS LES CHAMPS ! ");
            alert.showAndWait();
             //sp1.ajouter(new Projet(tfNom.getText(), tfdesc.getText(), tfdom.getText()));
        } else {
           sp1.ajouter(new Projet(tfNom.getText(), tfdesc.getText(), tfdom.getText()));
            JOptionPane.showMessageDialog(null, "PROJET AJOUTE AVEC SUCCES!");
            
            
            
              // Propriétés pour se connecter au serveur SMTP
      String host = "smtp.gmail.com";
      String port = "587";
      String username = "techwork414@gmail.com";
     //pacrvzlvscatwwkb
      //String password = "insogneyqftffvfm";
      String password = "pacrvzlvscatwwkb";
      // Propriétés pour définir le protocole SMTP
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", port);

      // Création d'une session avec les propriétés définies
      Session session = Session.getInstance(props, new Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Création d'un objet Message
         Message message = new MimeMessage(session);

         // Définition des destinataires
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("manarboukhris8@gmail.com"));

         // Définition du sujet
         message.setSubject("Confirmation d'ajout projet");
            
            // Création du contenu du message
            StringBuilder messageBody = new StringBuilder();
            messageBody.append("vous avez ajouté um nouveau projet dans votre portfolio avec les informations suivantes  : \n\n");
                messageBody.append("Nom : " + tfNom.getText() + "   ,   Description Projet : " + tfdesc.getText() + "   ,   domaine : " + tfdom.getText() + "\n");
         
         
         // Définition du contenu
     
           message.setText(messageBody.toString());
         // Envoi du message
         Transport.send(message);

         System.out.println("Le message a été envoyé avec succès.");
         JOptionPane.showMessageDialog(null, "Un email a été envoyé avec succès");

      } catch (MessagingException e) {
          
         System.out.println("Une erreur est survenue lors de l'envoi du message : " + e.getMessage());  
      }
            
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLhello.fxml"));
        Parent root = loader.load();
        tfNom.getScene().setRoot(root);
     
        FXMLhelloController dpc = loader.getController();          
        }
       
    }
    
    
    
    
       
    
    /*
    @FXML
    pour modifier
    private void Edit(ActionEvent event) {
       ServiceProjet sp2 = new ServiceProjet();
        sp2.modifier(new Projet(Integer.parseInt(tfid.getText()),tfNom.getText(), tfdesc.getText(), tfdom.getText()));
        JOptionPane.showMessageDialog(null, "Projet edite !"); 
    }
    */
 /* methode select users  
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
         index = tableprojet.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfid.setText(colid.getCellData(index).toString());
    tfNom.setText(colnom.getCellData(index).toString());
    tfdesc.setText(coldesc.getCellData(index).toString());
    tfdom.setText(coldom.getCellData(index).toString());
    }

    @FXML
    private void Delete(ActionEvent event) {
        try {
      ServiceProjet sp3 = new ServiceProjet();
        sp3.supprimer(new Projet(Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "Projet supprime !");  
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Projet");
        }
    }*/

    

    
}
