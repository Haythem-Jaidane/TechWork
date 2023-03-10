/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.fxml;

import com.esprit.GUI.RecruteurReadOffresController;
import com.esprit.services.SpeechRecognition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class MainIController  extends BorderPane {//implements Initializable {
	
	@FXML
	private Button start;
	
	@FXML
	private Button pause;
	
	@FXML
	private Button resume;
	
	@FXML
	private Label statusLabel;
	
	@FXML
	private TextArea infoArea;
       @FXML
	private TextField tfText;
         
         @FXML
    private Label lbData;
        
	
	// -----------------------------------------
	
	private SpeechRecognition speechRecognition = new SpeechRecognition();
	
	/**
	 * Constructor
	 */
        
        
        
	public MainIController() {
		
		// FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainInterfaceController.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, " FXML can't be loaded!", ex);
		}
		
	}
	
	/**
	 * Called as soon as .fxml is initialised
	 */
       
        /*
        @Override
	public void initialize(URL url, ResourceBundle rb) {
        } */
	
         @FXML
	private void initialize() {
		
		// start
		start.disableProperty().bind(speechRecognition.SpeechRecognitionThreadRunningProperty());
		start.setOnAction(a -> {
			statusLabel.setText("Status : [En Marche]");
			//infoArea.appendText("Starting Speech Recognizer\n");
			speechRecognition.startSpeechRecognition();
		});
		
		// stop
		pause.disableProperty().bind(speechRecognition.ignoreSpeechRecognitionResultsProperty().or(start.disabledProperty().not()));
		pause.setOnAction(a -> {
			statusLabel.setText("Status : [En Pause]");
			//infoArea.appendText("Pausing Speech Recognizer\n");
			speechRecognition.ignoreSpeechRecognitionResults();
		});
		
		// restart
		resume.disableProperty().bind(speechRecognition.ignoreSpeechRecognitionResultsProperty().not());
		resume.setOnAction(a -> {
			statusLabel.setText("Status : [En Marche]");
			//infoArea.appendText("Resuming Speech Recognizer\n");
			speechRecognition.stopIgnoreSpeechRecognitionResults();
		});
		
		//Bind the SpeechRecognitionText to InfoArea
		infoArea.textProperty().bind(Bindings.createStringBinding(() -> infoArea.getText() + " \n " + speechRecognition.getSpeechRecognitionResultProperty().get(),
				speechRecognition.getSpeechRecognitionResultProperty()));
		
	}
        
        
            public void setLbData(String d) {
        this.lbData.setText(d);
    } 
        
    @FXML
    private void sendData(MouseEvent event) throws IOException {
              
         JOptionPane.showMessageDialog(null, "ABCDEFG");
           RecruteurReadOffresController recruteurReadOffresController;
         
    //    FXMLLoader loader = new FXMLLoader(getClass().getResource("RecruteurReadOffres.fxml"));
    //    Parent root = loader.load();
    //    tfText.getScene().setRoot(root);
      
  setLbData(tfText.getText());
        
     //   RecruteurReadOffresController c = loader.getController();
      //  cc.setLbData(infoArea.getText()); 
      //    c.setLbData(tfText.getText()); 
        
    }
        
        
        
}