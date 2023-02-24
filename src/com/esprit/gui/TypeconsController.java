/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.FichMedia;
import com.esprit.entities.TypeProjet;
import com.esprit.services.ServiceFichMedia;
import com.esprit.services.ServiceTypeProjet;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class TypeconsController implements Initializable {

    @FXML
    private TableView<TypeProjet> tabcat;
    @FXML
    private TableColumn<TypeProjet,Integer> colref;
    @FXML
    private TableColumn<TypeProjet,String> colnom;
    @FXML
    private TableColumn<TypeProjet,String> coldesc;
    @FXML
    private TableColumn<TypeProjet,Integer> colid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfref;

ObservableList<TypeProjet> listc;
    //ObservableList<Projet> dataList;
    
   
    
    int index = -1;
    
    Connection cnx =null;
    ResultSet result = null;
    Statement st = null;
    @FXML
    private Button tfdep;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colnom.setCellValueFactory(new PropertyValueFactory<TypeProjet,String>("nomtype"));
        coldesc.setCellValueFactory(new PropertyValueFactory<TypeProjet,String>("descriptiontype"));
        colid.setCellValueFactory(new PropertyValueFactory<TypeProjet,Integer>("id"));
        colref.setCellValueFactory(new PropertyValueFactory<TypeProjet,Integer>("idtypeprojet"));
        
        listc=DataSource.getDatatype();
        //listp=DataSource.afficher();
        tabcat.setItems(listc);
    }    

    @FXML
    private void Select(MouseEvent event) {
        
                index = tabcat.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfref.setText(colref.getCellData(index).toString());
    tfnom.setText(colnom.getCellData(index).toString());
    tfdesc.setText(coldesc.getCellData(index).toString());
    tfid.setText(colid.getCellData(index).toString());
   
    }

    @FXML
    private void depajout(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouttype.fxml"));
        Parent root = loader.load();
        tfdep.getScene().setRoot(root);
     
        AjouttypeController dpc = loader.getController();
    }

    @FXML
    private void Delete(ActionEvent event) {
        
         ServiceTypeProjet sp4 = new ServiceTypeProjet();
        sp4.supprimer(new TypeProjet(Integer.parseInt(tfref.getText())));
        JOptionPane.showMessageDialog(null, "cat  supprime !");
    }

    @FXML
    private void modifer(ActionEvent event) {
        ServiceTypeProjet sp4 = new ServiceTypeProjet();
        index = tabcat.getSelectionModel().getSelectedIndex();
        
        sp4.modifier(new TypeProjet(Integer.parseInt(tfref.getText()),tfnom.getText(), tfdesc.getText(), Integer.parseInt(tfid.getText()))) ;
        JOptionPane.showMessageDialog(null, "categorie edite !");
    }
    
}
