/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class MainIController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private TextArea infoArea;
    @FXML
    private Button start;
    @FXML
    private Button pause;
    @FXML
    private Button resume;
    @FXML
    private Label lbData;
    @FXML
    private TextField tfText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendData(ActionEvent event) {
    }
    
}
