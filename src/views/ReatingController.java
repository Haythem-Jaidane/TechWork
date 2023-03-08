/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.gererProfil.utils.DbConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReatingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private RadioButton gr1;

    @FXML
    private RadioButton gr2;

    @FXML
    private RadioButton gr3;

    @FXML
    private RadioButton gr4;

    @FXML
    private RadioButton gr5;

    @FXML
    private ToggleGroup grating;
    
     @FXML
    private TextArea  idc;
      @FXML
    private ListView<String> listcom;
     
    
    String notte;
    
        @FXML
    private Label notreat;

        

    
   
    @FXML
    void clickbtn(ActionEvent event) {
       
         calcul();
        if(gr1.isSelected()){
            notte="1";
        }else if(gr2.isSelected()){
            notte="2";
        }else if(gr3.isSelected()){
            notte="3";
        }else if(gr4.isSelected()){
            notte="4";
        }else if(gr5.isSelected()){
            notte="5";
        }
        
        
        
        System.out.println("hey");
         
            
            Connection connection = DbConnect.getConnect();   
    	String query = "INSERT INTO `commentaire` ( `utilisateur_id`, `profil_id`, `contenu`, `note`) VALUES (1, 50, '"+idc.getText().toString()+"', '"+notte.toString()+"')";
    //    	String query = "INSERT INTO `commentaire` (`id`, `utilisateur_id`, `profil_id`, `contenu`, `date`, `note`) VALUES (NULL, '50', '50', 'ghofrane daly', '2023-03-22 16:15:36', '10');";
      try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = connection.prepareStatement(query);
  
           
            pst.executeUpdate();
            System.out.println("Publication ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        
        
        
        
          
        
        

    }
   
 
    
        
     public void executeQuery(String query) {
    	Connection conn = DbConnect.getConnect();
    	    Statement st;
    	try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    int note=0;
    int cmpt=0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    calcul();
        
        
    }    
    
    public void calcul(){
        listcom.getItems().clear();
        	Connection connection = DbConnect.getConnect();
    	String query = "SELECT * FROM commentaire where profil_id=50 ";
    	Statement st;
    	   ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
                            
                            listcom.getItems().add("Comnt: "+rs.getString("contenu")+" -  Note:"+rs.getString("note"));
				cmpt++;
				if(rs.getString("note").toString().equals("1"))
                                   note=note+1;
                                if(rs.getString("note").toString().equals("2"))
                                   note=note+2;
                                if(rs.getString("note").toString().equals("3"))
                                   note=note+3;
                                if(rs.getString("note").toString().equals("4"))
                                   note=note+4;
                                if(rs.getString("note").toString().equals("5"))
                                   note=note+5;
                                    
         
                
				}
                 
                          if(cmpt!=0)
                                {
                                    System.out.println(note/cmpt);
                                    notreat.setText(String.valueOf(note/cmpt) );
                                }else{
                                    notreat.setText("0");
                                }       
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
                   
        
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("market_2.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
    
}
