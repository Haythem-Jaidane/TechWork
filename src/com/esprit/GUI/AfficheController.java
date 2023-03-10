/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI;

import com.esprit.entities.Profil;
import com.esprit.services.ServiceProfil;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheController implements Initializable {

    @FXML
    private TableView<Profil> ProfilesTable;
    @FXML
    private TableColumn<Profil, Number> fxId;
    @FXML
    private TableColumn<Profil, String> fxNom;
    @FXML
    private TableColumn<Profil, String> fxPrenom;
    @FXML
    private TableColumn<Profil, String> fxNum;
    @FXML
    private TableColumn<Profil, String> fxEmail;
    @FXML
    private TableColumn<Profil, String> fxLocalisation;
    @FXML
    private TableColumn<Profil, String> fxDes;
    @FXML
    private TableColumn<Profil, String> fxLangues;
    @FXML
    private TableColumn<Profil, String> fxComp;
    @FXML
    private TableColumn<Profil, String> fxFormation;
    @FXML
    private TableColumn<Profil, String> fxExp;
    @FXML
    private TableColumn<Profil, String> fxDiplome;
    @FXML
    private TableColumn<Profil, String> fxLatitude;
    @FXML
    private TableColumn<Profil, String> fxLongitude;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Profil profil = null;
    ObservableList<Profil> ProfilList = FXCollections.observableArrayList();
    @FXML
    private ImageView modif;
    @FXML
    private ImageView delete;
    ServiceProfil sp = new ServiceProfil();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modif.setVisible(false);
        delete.setVisible(false);
        remplirProfil();
    }

    @FXML
    private void close(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    private void getAddView() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("AjoutProfil.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refreshTable() {
        try {
            ProfilList.clear();
            query = "SELECT * FROM profil";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProfilList.add(new Profil(
                        resultSet.getInt("id_Profil"),
                        resultSet.getString("Nom"),
                        resultSet.getString("Prenom"),
                        resultSet.getString("Numéro_téléphone"),
                        resultSet.getString("E_mail"),
                        resultSet.getString("Localisation"),
                        resultSet.getString("Description"),
                        resultSet.getString("Langues"),
                        resultSet.getString("Competences"),
                        resultSet.getString("Formation"),
                        resultSet.getString("Experiences_professionnelles"),
                        resultSet.getString("latitude"),
                        resultSet.getString("longitude"),
                        resultSet.getString("Diplome")));
                ProfilesTable.setItems(ProfilList);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int myIndex;
    int id;

    private void remplirProfil() {
        connection = DataSource.getConnect();
        refreshTable();
        fxId.setCellValueFactory(new PropertyValueFactory<>("id_Profil"));
        fxNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        fxPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        fxNum.setCellValueFactory(new PropertyValueFactory<>("Numéro_téléphone"));
        fxEmail.setCellValueFactory(new PropertyValueFactory<>("E_mail"));
        fxLocalisation.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
        fxDes.setCellValueFactory(new PropertyValueFactory<>("Description"));
        fxLangues.setCellValueFactory(new PropertyValueFactory<>("Langues"));
        fxComp.setCellValueFactory(new PropertyValueFactory<>("Competences"));
        fxFormation.setCellValueFactory(new PropertyValueFactory<>("Formation"));
        fxExp.setCellValueFactory(new PropertyValueFactory<>("Experiences_professionnelles"));
        fxLatitude.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        fxLongitude.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        fxDiplome.setCellValueFactory(new PropertyValueFactory<>("Diplome"));

        ProfilesTable.setItems(ProfilList);

        ProfilesTable.setRowFactory(tv -> {

            TableRow<Profil> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = ProfilesTable.getSelectionModel().getSelectedIndex();
                    modif.setVisible(true);
                    delete.setVisible(true);
                    id = Integer.parseInt(String.valueOf(ProfilesTable.getItems().get(myIndex).getId_Profil()));
                    System.out.println(id);

                }
            });
            return myRow;
        });

    }

    @FXML
    private void modifProf(MouseEvent event) throws IOException {

        sp.idp = id;

        Parent parent = FXMLLoader.load(getClass().getResource("UpdateProfil.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    private void deleteprof(MouseEvent event) {

        if (myIndex < -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("suppression incorrect!!");
            alert.setHeaderText("selection employer");
            alert.setContentText("failed suppression!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete File");
            alert.setHeaderText("Are you sure want to move this file to the Recycle Bin?");
            alert.setContentText("C:/MyFile.txt");

            // option != null.
            Optional<ButtonType> option = alert.showAndWait();
            Profil p = new Profil(id);
            sp.supprimer(p);
            /* if (option.get() == ButtonType.OK) {
        String query = "DELETE FROM employer WHERE id="+String.valueOf(id)+"";
    	executeQuery(query);
    	showBooks();
      } */

            refreshTable();
        }

    }

}
