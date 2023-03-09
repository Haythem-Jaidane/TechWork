/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

//import application.MainInterfaceController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.StageStyle;


/**
 *
 * @author Karim
 */
public class Main extends Application {
 	
	public MainInterfaceController mainInterface = new MainInterfaceController();
	 
	/**
	 * The main window of the application
	 */
 	public static Stage window;
	/*
	@Override
	public void start(Stage stage) {
		try {
			
			// Scene
			Scene scene = new Scene(mainInterface);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Primary Stage
			window = stage;
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/image/unmute.png")));
			stage.setScene(scene);
			stage.setOnCloseRequest(close -> System.exit(0));
			stage.show();
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, " Error loading the Main class", ex);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
        */
        
        
        
            @Override
 
 
    public void start(Stage primaryStage) {
        try {
      //      Parent parent = FXMLLoader.load(getClass().getResource("/page/MainInterfaceController.fxml"));
            Scene scene = new Scene(mainInterface);
      
       //     			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                                		
          scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
          primaryStage.initStyle(StageStyle.UTILITY);
          primaryStage.show();
			window = primaryStage;
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/image/unmute.png")));
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(close -> System.exit(0));
			primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,  " Error loading the Main class", ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}