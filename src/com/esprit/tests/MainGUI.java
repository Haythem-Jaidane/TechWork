/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.esprit.tests;



import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author asus
 */
public class MainGUI extends Application {
    
    @Override
 public void start(Stage primaryStage) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajouterfichmedia.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajouterprojet.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FXMLhello.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Cc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //scene.setFill(Color.GREEN);
        primaryStage.setScene(scene);
        //primaryStage.setTitle("ajout");
         primaryStage.setTitle("hello");

        primaryStage.show();
  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
