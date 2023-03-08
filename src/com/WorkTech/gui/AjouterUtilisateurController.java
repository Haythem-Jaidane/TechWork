/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.WorkTech.gui;

import com.WorkTech.entities.Utilisateur;
import com.WorkTech.services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jasser
 */
public class AjouterUtilisateurController implements Initializable {

    
 
    @FXML
    private javafx.scene.control.TextField tfcin;
    @FXML
    private javafx.scene.control.TextField tfnom;
    @FXML
    private javafx.scene.control.TextField tfprenom;
    @FXML
    private javafx.scene.control.TextField tfmotDePasse;
    @FXML
    private javafx.scene.control.TextField tfemail;
    @FXML
    private javafx.scene.control.TextField tfrole;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  @FXML
private void ajouterUtilisateur(ActionEvent event) throws IOException {
    String cin = tfcin.getText().trim();
    String nom = tfnom.getText().trim();
    String prenom = tfprenom.getText().trim();
    String motDePasse = tfmotDePasse.getText().trim();
    String email = tfemail.getText().trim();
    String role = tfrole.getText().trim();

    if (cin.isEmpty() || nom.isEmpty() || prenom.isEmpty() || motDePasse.isEmpty() || email.isEmpty() || role.isEmpty()) {
        // Show error message if any field is empty
        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        return;
    }

    ServiceUtilisateur sp = new ServiceUtilisateur();
    sp.ajouter(new Utilisateur(cin, nom, prenom, motDePasse, email, role));
    JOptionPane.showMessageDialog(null, "Utilisateur ajoutée !");
    FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailUtilisateur.fxml"));
    Parent root = loader.load();
    tfnom.getScene().setRoot(root);

    DetailUtilisateurController dpc = loader.getController();
    dpc.setLbNom(cin);
    dpc.setLbPrenom(nom);
    dpc.setLbPrenom(prenom);
    dpc.setLbPrenom(motDePasse);
    dpc.setLbPrenom(email);
    dpc.setLbPrenom(role);
}

    
    
    
    
}

