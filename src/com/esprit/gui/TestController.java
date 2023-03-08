/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Projet;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class TestController implements Initializable {

    @FXML
    private PieChart pc;
    public Connection cnx =null;
    @FXML
    private ImageView tfimg;
    @FXML
    private Button tfdep;
Image image = new Image(getClass().getResourceAsStream("logo WorkTech.PNG"));
    public void displayImage(){
       
        tfimg.setImage(image);}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    @FXML
    private void telchart(ActionEvent event) throws SQLException {
      int count;
      int n;
      int a;
      int m ;
      int h;
         Connection cnx = DataSource.getInstance().getCnx();
            String sql = "SELECT COUNT(*) FROM projet WHERE domaine = 'informatique'";
            Statement statement = cnx.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            
          if (resultSet.next()) {
                count = resultSet.getInt(1);
                
            } else {
               // System.out.println("Aucun projet trouvé dans le domaine informatique.");
               count =0;
            }
         // Connection cnx = DataSource.getInstance().getCnx();
            String sq2 = "SELECT COUNT(*) FROM projet WHERE domaine = 'iot'";
            Statement ST = cnx.createStatement();
            ResultSet RS = ST.executeQuery(sq2);

            
          if (RS.next()) {
                n = RS.getInt(1);
                
            } else {
               // System.out.println("Aucun projet trouvé dans le domaine informatique.");
               n =0;
            }
            String sq4 = "SELECT COUNT(*) FROM projet WHERE domaine = 'dev web'";
            Statement ST4 = cnx.createStatement();
            ResultSet RS4 = ST4.executeQuery(sq4);

            
          if (RS4.next()) {
                m = RS4.getInt(1);
                
            } else {
               // System.out.println("Aucun projet trouvé dans le domaine informatique.");
               m =0;
            }
          
          String sq5 = "SELECT COUNT(*) FROM projet WHERE domaine = 'mobile'";
            Statement ST5 = cnx.createStatement();
            ResultSet RS5 = ST5.executeQuery(sq5);

            
          if (RS5.next()) {
                h = RS5.getInt(1);
                
            } else {
               // System.out.println("Aucun projet trouvé dans le domaine informatique.");
               h =0;
            }
          
           String sq3 = "SELECT COUNT(*) FROM projet WHERE domaine NOT IN ('informatique', 'iot')";
            Statement ST3 = cnx.createStatement();
            ResultSet RS3 = ST3.executeQuery(sq3);

          if (RS3.next()) {
                a = RS3.getInt(1);
                
            } else {
               // System.out.println("Aucun projet trouvé dans le domaine informatique.");
               a =0;
            }
          

        ObservableList<Data>list= FXCollections.observableArrayList(
                   new PieChart.Data("informatique", count),
                   new PieChart.Data("iot", n),
                   new PieChart.Data("dev web", m),
                   new PieChart.Data("Mobile", h),
                   new PieChart.Data("Autres Domaines", a)               
        );
        pc.setData(list);
    }
    @FXML
    private void tfdep(ActionEvent event)throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Cc.fxml"));
        Parent root = loader.load();
       tfdep.getScene().setRoot(root);
      CcController dpc = loader.getController();
    }
}
