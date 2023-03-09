/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import GUI.recruteur.ReadOffresController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.MainGUI;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class LandingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void candidat(MouseEvent event) {
       try {
            Parent parent = FXMLLoader.load(getClass().getResource("CandidatReadOffres.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNIFIED);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReadOffresController.class.getName()).log(Level.ALL, null, ex);
        }
    }

    @FXML
    private void recruteur(MouseEvent event) {
       try {
            Parent parent = FXMLLoader.load(getClass().getResource("RecruteurReadOffres.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNIFIED);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReadOffresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
