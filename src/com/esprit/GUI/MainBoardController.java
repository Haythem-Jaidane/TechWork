/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MainBoardController implements Initializable {

    @FXML
    private Button profil;
    @FXML
    private Button portfolio;
    @FXML
    private Button formation;
    @FXML
    private Button Offre;
    @FXML
    private Button Offre1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profilint(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("market.fxml"));
        Parent root = loader.load();
        portfolio.getScene().setRoot(root);
        MarketController dpc = loader.getController();
    }

    @FXML
    private void portfolioint(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cc.fxml"));
        Parent root = loader.load();
        portfolio.getScene().setRoot(root);
        CcController dpc = loader.getController();
    }

    @FXML
    private void formationint(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceCours.fxml"));
        Parent root = loader.load();
        portfolio.getScene().setRoot(root);
        InterfaceCoursController dpc = loader.getController();
    }

    @FXML
    private void offre_int(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandidatReadOffres.fxml"));
        Parent root = loader.load();
        portfolio.getScene().setRoot(root);
        CandidatReadOffresController dpc = loader.getController();
    }

    @FXML
    private void offre_int1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecruteurReadOffres.fxml"));
        Parent root = loader.load();
        portfolio.getScene().setRoot(root);
        RecruteurReadOffresController dpc = loader.getController();
    }
    
}
