package com.WorkTech.gui;

import com.WorkTech.entities.Utilisateur;
import com.WorkTech.services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AfficherUtilisateurController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set up columns
        clcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        clnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        clprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        clmotDePasse.setCellValueFactory(new PropertyValueFactory<>("motDePasse"));
        clemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clrole.setCellValueFactory(new PropertyValueFactory<>("role"));

        // display users
        ServiceUtilisateur sp = new ServiceUtilisateur();
        tableView.setItems(observableArrayList(sp.afficher()));
    }

   
}
