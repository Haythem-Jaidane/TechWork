/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;



import com.esprit.utils.DataSource;
import com.esprit.entities.Projet;
import com.esprit.services.IService;
import com.esprit.services.ServiceProjet;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouterprojetController implements Initializable {
   
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfdesc;
     @FXML
    private TextField tfdom;
    @FXML
    private ImageView tfimg;

    //ObservableList<Projet> dataList;
    
   
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*   //initialisation du tableau
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
     
      listp=DataSource.getDataproj();
     
        tableprojet.setItems(listp);*/
    }  
    @FXML
    
    private void Ajouterprojet(ActionEvent event) throws IOException {
       
        ServiceProjet sp1 = new ServiceProjet();
        sp1.ajouter(new Projet(tfNom.getText(), tfdesc.getText(), tfdom.getText()));
        JOptionPane.showMessageDialog(null, "Projet ajoutée !");
        // interface o5ra tjini ba3ed l ok
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Detailsprojet.fxml"));
        Parent root = loader.load();
        tfNom.getScene().setRoot(root);
     
        DetailsprojetController dpc = loader.getController();
       /* dpc.setLbNom(tfNom.getText());
        dpc.setLbdesc(tfdesc.getText());
        dpc.setLbdom(tfdom.getText());*/
    }
    
    
    
    
       
    
    /*
    @FXML
    pour modifier
    private void Edit(ActionEvent event) {
       ServiceProjet sp2 = new ServiceProjet();
        sp2.modifier(new Projet(Integer.parseInt(tfid.getText()),tfNom.getText(), tfdesc.getText(), tfdom.getText()));
        JOptionPane.showMessageDialog(null, "Projet edite !"); 
    }
    */
 /* methode select users  
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
         index = tableprojet.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfid.setText(colid.getCellData(index).toString());
    tfNom.setText(colnom.getCellData(index).toString());
    tfdesc.setText(coldesc.getCellData(index).toString());
    tfdom.setText(coldom.getCellData(index).toString());
    }

    @FXML
    private void Delete(ActionEvent event) {
        try {
      ServiceProjet sp3 = new ServiceProjet();
        sp3.supprimer(new Projet(Integer.parseInt(tfid.getText())));
        JOptionPane.showMessageDialog(null, "Projet supprime !");  
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Projet");
        }
    }*/

    

    
}
