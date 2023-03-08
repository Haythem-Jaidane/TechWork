/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gererProfil.utils;

import com.gererProfil.services.ServiceProfil;
import com.gererProfil.services.ServicePublication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author ASUS
 */
public class mainGui extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         ServicePublication check = new ServicePublication();
         ServiceProfil pp = new ServiceProfil();
          Parent parent;
        try {
        //  parent = FXMLLoader.load(getClass().getResource("../gui/Affiche.fxml"));
      /**/ if ((check.getPublicationByname(50)!= null )) {
           parent = FXMLLoader.load(getClass().getResource("/views/market.fxml"));
       }
       else{
           pp.profils=1;
           parent = FXMLLoader.load(getClass().getResource("../gui/AjoutProfil.fxml"));
       }  /**/
          Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(mainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

    
    
    
}
