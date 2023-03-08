package com.gererProfil.gui;



import com.gererProfil.entities.Publication;
import com.gererProfil.services.ServicePublication;
import com.gererProfil.utils.DbConnect;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.MyListener;

import com.gererProfil.entities.infoprof;
import com.gererProfil.services.ServiceProfil;

public class MarketController implements Initializable {
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
    
    
    @FXML
    private Button btSearch;

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

    private List<items> getData() {
        List<items> fruits = new ArrayList<>();
        items fruit;
        
        
        
        ObservableList<infoprof> booksList = FXCollections.observableArrayList();
    	Connection connection = DbConnect.getConnect();
    	String query = "SELECT * FROM publication ORDER BY id_Pub DESC";
    	Statement st;
    	ResultSet rs;
    	
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

     int idprof;
    private void setChosenFruit(items fruit) {
              ServicePublication sp = new ServicePublication();
  
        fruitNameLable.setText( sp.getPublicationByname(fruit.getIdProfil()));
        idprof=fruit.getIdProfil();
        //fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          
        
          fruits.clear();
        marketshow();
       check();
    }
   
    public void check()
    {
      
        
    }
    
    
     @FXML
    private Button shob;
    @FXML
    void showrestp(ActionEvent event) {
        try {
            ServiceProfil ps= new ServiceProfil();
            ps.idp=   idprof;
            Parent parent =  FXMLLoader.load(getClass().getResource("/views/market_2.fxml"));
            shob.getScene().setRoot(parent);
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
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

}
