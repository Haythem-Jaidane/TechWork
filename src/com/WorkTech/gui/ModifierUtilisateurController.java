package com.WorkTech.gui;

import com.WorkTech.entities.Utilisateur;
import com.WorkTech.services.ServiceUtilisateur;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ModifierUtilisateurController {

    @FXML
    private TextField tfcin;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tfmotDePasse;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfrole;

    @FXML
    private TableView<Utilisateur> tableView;

    @FXML
    private TableColumn<Utilisateur, String> clcin;

    @FXML
    private TableColumn<Utilisateur, String> clnom;

    @FXML
    private TableColumn<Utilisateur, String> clprenom;

    @FXML
    private TableColumn<Utilisateur, String> clmotDePasse;

    @FXML
    private TableColumn<Utilisateur, String> clemail;

    @FXML
    private TableColumn<Utilisateur, String> clrole;

    private ObservableList<Utilisateur> utilisateurs;

    public void initialize() {
    // set up columns
    clcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
    clnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    clprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    clmotDePasse.setCellValueFactory(new PropertyValueFactory<>("motDePasse"));
    clemail.setCellValueFactory(new PropertyValueFactory<>("email"));
    clrole.setCellValueFactory(new PropertyValueFactory<>("role"));

    // display users
    ServiceUtilisateur sp = new ServiceUtilisateur();
    utilisateurs = observableArrayList(sp.afficher());
    tableView.setItems(utilisateurs);
    }

  @FXML
void modifierUtilisateur(ActionEvent event) throws IOException {
    ServiceUtilisateur sp = new ServiceUtilisateur();

    int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
    if (selectedIndex != -1) {
        Utilisateur utilisateur = tableView.getItems().get(selectedIndex);
        utilisateur.setCin(tfcin.getText());
        utilisateur.setNom(tfnom.getText());
        utilisateur.setPrenom(tfprenom.getText());
        utilisateur.setMotDePasse(tfmotDePasse.getText());
        utilisateur.setEmail(tfemail.getText());
        utilisateur.setRole(tfrole.getText());

        sp.modifier(new Utilisateur(tfcin.getText() ,tfnom.getText() ,tfprenom.getText()  ,tfmotDePasse.getText()   , tfemail.getText()  ,   tfrole.getText()));     // update database
        JOptionPane.showMessageDialog(null, "Utilisateur modifié !");
        
        tableView.refresh(); // update display

    } else {
        JOptionPane.showMessageDialog(null, "Sélectionnez un utilisateur à modifier.");
    }
}

}


