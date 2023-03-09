package com.gererProfil.gui;



import com.gererProfil.entities.Publication;
import com.gererProfil.services.ServicePublication;
import com.gererProfil.utils.DbConnect;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import com.gererProfil.entities.items;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import main.MyListener;

import com.gererProfil.entities.infoprof;
import com.gererProfil.services.ServiceProfil;
import javafx.scene.Scene;
import javafx.stage.StageStyle;


public class Front_Profile implements Initializable {
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Label fruitNameLable;


    @FXML
    private ImageView fruitImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    
    

    private List<items> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private AnchorPane AjouterP;
    @FXML
    private TextField fxObjet;
    @FXML
    private TextArea fxMessage;
    @FXML
    private ImageView imgqrcode;
    @FXML
    private WebView mapview;
    @FXML
    private ImageView fruitImg1;
    @FXML
    private Label testlaba;
    @FXML
    private Button btSearch1;
    @FXML
    private Label tel;
    @FXML
    private Label testlaba1;
    @FXML
    private Label comp;
    private Button addcomnt;
    @FXML
    private Button rback;
    @FXML
    private Button addcomnt1;
    @FXML
    private Button update;
    @FXML
    private Button deletepub;
    
    
    
        @FXML
    void btnsearch(ActionEvent event) {
            
            
    }
    
        @FXML
    private TextField searchrest;
        
 /*       
@FXML
    void searchact(KeyEvent event) {
        System.out.println(searchrest.getText().toString());
      /*   grid.getChildren().clear();
        fruits.clear();
        marketshow();
    } */
    
      @FXML
    void searchact2(KeyEvent event) {
        System.out.println(searchrest.getText().toString());
          grid.getChildren().clear();
        fruits.clear();
        marketshow();
    }
String lat,lon;
    private List<items> getData() {
        List<items> fruits = new ArrayList<>();
        items fruit;
        
        
        ///////// inof
         ServiceProfil ps= new ServiceProfil();
           Connection connection = DbConnect.getConnect();
    	String query = "SELECT * FROM profil where id_Profil="+ps.idp;
    	   Statement st;
    	   ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
                       
				//books = new emplo(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("age"),rs.getString("tel"));
			testlaba.setText(rs.getString("Nom").toString());
                           testlaba1.setText(rs.getString("Prenom").toString());
                       // local.setText(rs.getString("local").toString());
                        comp.setText(rs.getString("Competences").toString());
                         tel.setText(rs.getString("Numéro_téléphone").toString());
                        lat=rs.getString("latitude").toString();
                        lon=rs.getString("longitude").toString();
                        
                   //          System.out.println(rs.getString("specialitee").toString());
                
				}
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        ///// publication
        

    	 query = "SELECT * FROM publication where id_Profil="+ps.idp+" ORDER BY id_Pub DESC";
    
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			infoprof books;
			while(rs.next()) {
                             fruit = new items();
				//books = new emplo(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("age"),rs.getString("tel"));
				fruit.setIdP(rs.getInt("id_pub"));
                                fruit.setIdProfil(rs.getInt("id_Profil"));
                                fruit.setName(rs.getString("objet").toString());
                                fruit.setMsg(rs.getString("message").toString());
                                fruit.setImgSrc("/assest/useri.png");
                                fruit.setColor("6A7324");
                                if (searchrest.getText().isEmpty() )
                                fruits.add(fruit);
                                else if( (rs.getString("objet").toString().toUpperCase().indexOf(searchrest.getText().toUpperCase())>-1)||
                                        (rs.getString("message").toString().toUpperCase().indexOf(searchrest.getText().toUpperCase())>-1) )
                                {
                                     fruits.add(fruit);
                                }
                
				}
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        

       /* fruit = new Fruit();
        fruit.setName("Xfood");
        fruit.setImgSrc("/assest/restaurant-5841.jpg");
        fruit.setColor("1b7329");
        fruits.add(fruit);*/
    
        return fruits;
    }
int delete ;
int choix=0;
    private void setChosenFruit(items fruit) {
        if(choix!=0)
        deletepub.setVisible(true);
        choix++;
              ServicePublication sp = new ServicePublication();
         delete=fruit.getIdP();
        fruitNameLable.setText( sp.getPublicationByname(fruit.getIdProfil()));
        //fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         ServiceProfil pss= new ServiceProfil();
        if (pss.idp==50){
            update.setVisible(true);
        }
        
          fruits.clear();
        marketshow();
        
          WebEngine webEngine = mapview.getEngine();

  /* Charge la carte HTML avec Leafletjs */
  webEngine.loadContent("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"    <title>Google Maps Drag Marker Get Coordinates</title>\n" +
"    <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\" type=\"text/javascript\"></script>\n" +
"    <script type=\"text/javascript\" src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBvHg2E3bOHns4yCQJ4ogiFR9wllEg4Z0E\"></script>\n" +
"    <script type=\"text/javascript\">\n" +
"        function initialize() {\n" +
"            // Creating map object\n" +
"            var map = new google.maps.Map(document.getElementById('map_canvas'), {\n" +
"                zoom: 12,\n" +
"                center: new google.maps.LatLng("+lat+","+ lon+"),\n" +
"                mapTypeId: google.maps.MapTypeId.ROADMAP\n" +
"            });\n" +
"            // creates a draggable marker to the given coords\n" +
"            var vMarker = new google.maps.Marker({\n" +
"                position: new google.maps.LatLng("+lat+","+ lon+"),\n" +
"                draggable: true\n" +
"            });\n" +
"            // adds a listener to the marker\n" +
"            // gets the coords when drag event ends\n" +
"            // then updates the input with the new coords\n" +
"           \n" +
"            // centers the map on markers coords\n" +
"            map.setCenter(vMarker.position);\n" +
"            // adds the marker on the map\n" +
"            vMarker.setMap(map);\n" +
"        }\n" +
"        \n" +
"    </script>\n" +
"</head>\n" +
"<body onload=\"initialize();\">\n" +
"   \n" +
"    <div id=\"map_canvas\" style=\"width: auto; height: 200px;\">\n" +
"    </div>\n" +
"</body>\n" +
"</html>");
  
  
        
        
        
        //qr  
        
        //https://ghofrane12.000webhostapp.com/affichage.php
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "https://ghofrane12.000webhostapp.com/affichage.php?name="+testlaba.getText().toString()+"&prenom="+testlaba1.getText()+""
                + "&tel="+tel.getText() + "&comp="+comp.getText();
        int width = 167;
        int height = 183;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {
            Logger.getLogger(Front_Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView qrView = new ImageView();
        imgqrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
       
    }    
        

    void showrestp(ActionEvent event) {
       //delete
     
               
    }
    
    
    public void marketshow()
    {
          fruits.clear();
         fruits.addAll(getData());
        if (fruits.size() > 0) {
            setChosenFruit(fruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(items fruit) {
                    setChosenFruit(fruit);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void save(MouseEvent event) {
         ServicePublication sp1 = new ServicePublication();
           sp1.ajouter(new Publication(fxObjet.getText(),fxMessage.getText(),"7",50));
           fxObjet.setText("");
           fxMessage.setText("");
            marketshow();
          AjouterP.setVisible(false);
          
    }

    @FXML
    private void exit(MouseEvent event) {
            fxObjet.setText("");
           fxMessage.setText("");
           marketshow();
          AjouterP.setVisible(false);
    }

    @FXML
    private void btnOJP(MouseEvent event) {
        AjouterP.setVisible(true);
    }

    @FXML
    private void reted(MouseEvent event) throws IOException {
        System.out.println("hey");
        
         Parent parent = FXMLLoader.load(getClass().getResource("/views/reating.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        
        
        
    }

    @FXML
    private void btnrbach(MouseEvent event) throws IOException {
     
         Parent parent = FXMLLoader.load(getClass().getResource("/views/market.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        
    }

    @FXML
    private void updateProfil(MouseEvent event) throws IOException {
    
         Parent parent = FXMLLoader.load(getClass().getResource("UpdateProfil.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        
    }

    @FXML
    private void showrestp(MouseEvent event) {
           ServicePublication sp = new ServicePublication();
        Publication p=new Publication(delete);
      sp.supprimer(p);
    }

   
    
    
}
