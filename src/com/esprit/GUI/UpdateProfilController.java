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
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateProfilController implements Initializable {

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
    @FXML
    private TextField fxDiplome;
    @FXML
    private Button b5;
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
        refreshTable();
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

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Profil profil = null;
    ServiceProfil sp = new ServiceProfil();
    int id;

    private void refreshTable() {
        Connection connection = DataSource.getConnect();
        query = "SELECT * FROM profil where id_Profil=" + sp.idp;
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("id_Profil");
                fxNom.setText(rs.getString("Nom"));
                fxPrenom.setText(rs.getString("Prenom"));
                fxNum.setText(rs.getString("Numéro_téléphone"));
                fxEmail.setText(rs.getString("E_mail"));
                fxLocalisation.setText(rs.getString("Localisation"));
                fxDes.setText(rs.getString("Description"));
                fxLangues.setText(rs.getString("Langues"));
                fxComp.setText(rs.getString("Competences"));
                fxFormation.setText(rs.getString("Formation"));
                fxExp.setText(rs.getString("Experiences_professionnelles"));
                latitude.setText(rs.getString("latitude"));
                longitude.setText(rs.getString("longitude"));
                fxDiplome.setText(rs.getString("Diplome"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void Save(MouseEvent event) throws IOException {
        Profil p = new Profil(id, fxNom.getText(), fxPrenom.getText(), fxNum.getText(), fxEmail.getText(), fxLocalisation.getText(),
                fxDes.getText(), fxLangues.getText(), fxComp.getText(), fxFormation.getText(), fxExp.getText(), latitude.getText(), longitude.getText(), fxDiplome.getText());
        sp.modifier(p);
        Parent parent = FXMLLoader.load(getClass().getResource("../gui/Affiche.fxml"));
        b5.getScene().setRoot(parent);

        /*
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
         */
    }

    /*String query = "UPDATE employer SET nom='"+titleField.getText()+"',prenom='"+authorField.getText()+"',age="+yearField.getText()+",tel="+pagesField.getText()+" WHERE id="+String.valueOf(id)+"";
    executeQuery(query);*/
}
