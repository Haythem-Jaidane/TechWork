package com.gererProfil.gui;

import com.gererProfil.entities.Publication;
import com.gererProfil.services.ServicePublication;
import com.gererProfil.utils.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.MyListener;

import com.gererProfil.entities.items;


public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label fxobject;

    @FXML
    private ImageView img;
    @FXML
    private Text fxmsg;
    @FXML
    private Button btnL;

           ServicePublication sp = new ServicePublication();
          
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(fruit);
    }

    
   
    
    private items fruit;
    private MyListener myListener;
    int idp;
    int exist=0;
    public void setData(items fruit, MyListener myListener) {
        this.fruit = fruit;
        this.myListener = myListener;
        idp=fruit.getIdP();
        nameLabel.setText( sp.getPublicationByname(fruit.getIdProfil()));
        // sp.getPublicationByname(37)
        fxobject.setText(fruit.getName());
        fxmsg.setText(fruit.getMsg());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        img.setImage(image);
        
        
         String req = "SELECT * FROM likepub  WHERE id_user='" + 1 + "' and id_pub='" + idp + "' ;";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
             exist++;
            }

            System.out.println("Publication récupérées by id !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if (exist>0){
            btnL.setText("unlike");
        }
        
        
    }
    
       private Connection cnx = DbConnect.getInstance().getConnection();
    @FXML
        void likeb(MouseEvent event) {
        
        if (exist <= 0){
            System.out.println("Controller.ItemController.likeb()");
             String req = "INSERT INTO likepub(id_user,id_pub) VALUES(?, ?);";
            try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, 1);
            pst.setInt(2,idp);

           
            pst.executeUpdate();
              btnL.setText("Unlike");
              exist++;
            System.out.println("Publication ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }else{
            
               String req = "DELETE FROM likepub  WHERE id_user='" + 1 + "' and id_pub='" + idp + "' ;";
               try {
                   PreparedStatement pst = cnx.prepareStatement(req);
                   pst.executeUpdate();
                   System.out.println("Publication supprimée !");
                   exist=0;
                    btnL.setText("like");
               } catch (SQLException ex) {
                   System.out.println(ex.getMessage());
               }


        }
        
        
        
    }

    
}
