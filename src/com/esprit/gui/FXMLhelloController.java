/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Projet;
import com.esprit.utils.DataSource;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;




import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLhelloController implements Initializable {

   
    @FXML
    private Button tfAjout;
    @FXML
    private TableView<Projet> tab1;
    @FXML
    private TableColumn<Projet,Integer> colid;
    @FXML
    private TableColumn<Projet,String> colnom;
    @FXML
    private TableColumn<Projet,String> coldesc;
    @FXML
    private TableColumn<Projet,String> coldom;
 ObservableList<Projet> listp;
     int index = -1;
    
    Connection cnx =null;
   ResultSet result = null;
   Statement st = null;
    @FXML
    private Button tfmodif;
    @FXML
    private Button tfsup;
   // @FXML
   // private Button tfcons;
    @FXML
    private Button tfcher;
    @FXML
    private ImageView tfaj;
    @FXML
    private ImageView tfm;
    @FXML
    private ImageView tfs;
   
   // private Button tfdeeep;
    /**
     * Initializes the controller class.
     */
     Image image = new Image(getClass().getResourceAsStream("sup.PNG"));
    @FXML
    private ImageView tfc;
    @FXML
    private ImageView tfar;
    @FXML
    private Button tfret;
    @FXML
    private ImageView tfimg;
    @FXML
    private Button tfdip;
          public void displayImage(){
        tfc.setImage(image);
        tfimg.setImage(image);
        tfaj.setImage(image);
        tfm.setImage(image);
        tfs.setImage(image);
         tfar.setImage(image);
       
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                //initialisation du tableau
        colid.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Projet,String>("nom"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        coldom.setCellValueFactory(new PropertyValueFactory<Projet,String>("domaine"));
     
      listp=DataSource.getDataproj();
      //listp=DataSource.afficher();
        tab1.setItems(listp);
    }    

    @FXML
    private void ajout(ActionEvent event) throws IOException{
        //code net3ada min interface l interface 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterprojet.fxml"));
        Parent root = loader.load();
       tfAjout.getScene().setRoot(root);
        AjouterprojetController dpc = loader.getController();
    }

    @FXML
    private void modif(ActionEvent event)throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifer.fxml"));
        Parent root = loader.load();
       tfmodif.getScene().setRoot(root);
        ModiferController dpc = loader.getController();
    }

    @FXML
    private void supp(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifer.fxml"));
        Parent root = loader.load();
       tfsup.getScene().setRoot(root);
        ModiferController dpc = loader.getController();
    }

  /*  @FXML
    private void consulter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultmedia.fxml"));
        Parent root = loader.load();
       tfcons.getScene().setRoot(root);
        ConsultmediaController dpc = loader.getController();
    }
*/
    @FXML
    private void dep(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifer.fxml"));
        Parent root = loader.load();
       tfcher.getScene().setRoot(root);
        ModiferController dpc = loader.getController();
     
    }

   /* @FXML
    private void deeep(ActionEvent event) 
        
        throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Typecons.fxml"));
        Parent root = loader.load();
       tfcher.getScene().setRoot(root);
       TypeconsController dpc = loader.getController();
    }*/

    @FXML
    private void retour(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("cc.fxml"));
        Parent root = loader.load();
       tfret.getScene().setRoot(root);
        CcController dpc = loader.getController();
    }

    @FXML
    private void generatePdf(ActionEvent event) throws SQLException{

       
        // Créer un nouveau document PDF
        Document document = new Document();
        try {
            // Créer un objet PdfWriter pour écrire le document dans un fichier
            PdfWriter.getInstance(document, new FileOutputStream("LISTE.pdf"));

            // Ouvrir le document
            document.open();
            Paragraph paragraph = new Paragraph("VOICI LA LISTE DE VOS PROJETS!");
            Paragraph par = new Paragraph("                                   ");
            
         // Créer un tableau avec 3 colonnes
            PdfPTable table = new PdfPTable(3);
            
            // Ajouter des en-têtes de colonne
            table.addCell(new PdfPCell(new Paragraph("TITRE")));
            table.addCell(new PdfPCell(new Paragraph("DESCRIPTION")));
            table.addCell(new PdfPCell(new Paragraph("DOMAINE")));
            Connection cnx = DataSource.getInstance().getCnx();
        ObservableList<Projet> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnx.prepareStatement("select * from projet");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
            // Ajouter des cellules
            table.addCell(new PdfPCell(new Paragraph(rs.getString("nom"))));
            // valueCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    //table.addCell(valueCell);
            table.addCell(new PdfPCell(new Paragraph(rs.getString("description"))));
            table.addCell(new PdfPCell(new Paragraph(rs.getString("domaine"))));}}
            catch (SQLException e) {
                e.printStackTrace();
            }
            // Ajouter le tableau au document
            document.add(par);
            document.add(paragraph);
            document.add(par);
            document.add(table);
           // document.add(paragraph);
            // Fermer le document
            document.close();
            System.out.println("Le document a été créé avec succès !");}
         catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        }
    

    @FXML
    private void dip(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent root = loader.load();
        tfdip.getScene().setRoot(root);
        
        TestController dpc = loader.getController();
    }    
}
