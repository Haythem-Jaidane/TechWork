/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class ReadCandidaturesController implements Initializable {

    @FXML
    private TableView<?> candidaturesTable;
    @FXML
    private TableColumn<?, ?> statusCol;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> offreCol;
    @FXML
    private TableColumn<?, ?> titreOffreCol;
    @FXML
    private TableColumn<?, ?> recruteurCol;
    @FXML
    private TableColumn<?, ?> candidatCol;
    @FXML
    private TableColumn<?, ?> datePostulationCol;
    @FXML
    private TableColumn<?, ?> dateModificationCol;
    @FXML
    private TableColumn<?, ?> informationCol;
    @FXML
    private TableColumn<?, ?> buttonsCol;
    @FXML
    private TableView<?> rejectedCandidaturesTable;
    @FXML
    private TableColumn<?, ?> statusCol1;
    @FXML
    private TableColumn<?, ?> offreCol1;
    @FXML
    private TableColumn<?, ?> titreOffreCol1;
    @FXML
    private TableColumn<?, ?> idCol1;
    @FXML
    private TableColumn<?, ?> recruteurCol1;
    @FXML
    private TableColumn<?, ?> candidatCol1;
    @FXML
    private TableColumn<?, ?> datePostulationCol1;
    @FXML
    private TableColumn<?, ?> dateModificationCol1;
    @FXML
    private TableColumn<?, ?> informationCol1;
    @FXML
    private TableColumn<?, ?> buttonsCol1;
    @FXML
    private TableView<?> acceptedCandidaturesTable;
    @FXML
    private TableColumn<?, ?> idCol11;
    @FXML
    private TableColumn<?, ?> statusCol11;
    @FXML
    private TableColumn<?, ?> offreCol11;
    @FXML
    private TableColumn<?, ?> titreOffreCol11;
    @FXML
    private TableColumn<?, ?> recruteurCol11;
    @FXML
    private TableColumn<?, ?> candidatCol11;
    @FXML
    private TableColumn<?, ?> datePostulationCol11;
    @FXML
    private TableColumn<?, ?> dateModificationCol11;
    @FXML
    private TableColumn<?, ?> informationCol11;
    @FXML
    private TableColumn<?, ?> buttonsCol11;
    @FXML
    private Text nbAttente;
    @FXML
    private Text nbAccepted;
    @FXML
    private Text nbRejected;
    @FXML
    private PieChart pieChart;
    @FXML
    private TableView<?> candidaturesTable1;
    @FXML
    private TableView<?> rejectedCandidaturesTable1;
    @FXML
    private TableView<?> acceptedCandidaturesTable1;
    @FXML
    private TableColumn<?, ?> idCol111;
    @FXML
    private TableColumn<?, ?> statusCol111;
    @FXML
    private TableColumn<?, ?> offreCol111;
    @FXML
    private TableColumn<?, ?> titreOffreCol111;
    @FXML
    private TableColumn<?, ?> recruteurCol111;
    @FXML
    private TableColumn<?, ?> candidatCol111;
    @FXML
    private TableColumn<?, ?> datePostulationCol111;
    @FXML
    private TableColumn<?, ?> dateModificationCol111;
    @FXML
    private TableColumn<?, ?> informationCol111;
    @FXML
    private TableColumn<?, ?> buttonsCol111;
    @FXML
    private Text nbAttente1;
    @FXML
    private Text nbAccepted1;
    @FXML
    private Text nbRejected1;
    @FXML
    private PieChart pieChart1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAjoutOffre(MouseEvent event) {
    }

    @FXML
    private void btnViewOffre(MouseEvent event) {
    }

    @FXML
    private void btnClose(MouseEvent event) {
    }
    
}
