/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.WorkTech.tests;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author abdel
 */
public class MainGUI extends Application {
    
    /**
     *
     * @param primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouterUtilisateur.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/LoginUtilisateur.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierUtilisateur.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/SupprimerUtilisateur.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherUtilisateur.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Workshop PIDEV");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
