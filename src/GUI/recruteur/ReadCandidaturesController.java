/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI.recruteur;

import GUI.CandidatReadOffresController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Candidature;
import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import services.ServiceCandidature;
import services.ServiceOffre;
import utils.DbConnect;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class ReadCandidaturesController implements Initializable {

    @FXML
    private TableView<Candidature> candidaturesTable;

    @FXML
    private TableView<Candidature> rejectedCandidaturesTable;

    @FXML
    private TableView<Candidature> acceptedCandidaturesTable;

    @FXML
    private TableColumn<Candidature, String> idCol;
    @FXML
    private TableColumn<Candidature, Number> offreCol;
    @FXML
    private TableColumn<Candidature, String> recruteurCol;
    @FXML
    private TableColumn<Candidature, String> candidatCol;
    @FXML
    private TableColumn<Candidature, String> statusCol;
    @FXML
    private TableColumn<Candidature, String> informationCol;
    @FXML
    private TableColumn<Candidature, String> datePostulationCol;
    @FXML
    private TableColumn<Candidature, String> dateModificationCol;
    @FXML
    private TableColumn<Candidature, String> buttonsCol;
    
        @FXML
    private TableColumn<Candidature, String> titreOffreCol;
        @FXML
    private TableColumn<Candidature, String> titreOffreCol1;
        
                @FXML
    private TableColumn<Candidature, String> titreOffreCol11;
    Candidature candidature = null;

    ObservableList<Candidature> candidaturesList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Candidature, String> idCol1;
    @FXML
    private TableColumn<Candidature, Number> offreCol1;
    @FXML
    private TableColumn<Candidature, String> recruteurCol1;
    @FXML
    private TableColumn<Candidature, String> candidatCol1;
    @FXML
    private TableColumn<Candidature, String> statusCol1;
    @FXML
    private TableColumn<Candidature, String> informationCol1;
    @FXML
    private TableColumn<Candidature, String> datePostulationCol1;
    @FXML
    private TableColumn<Candidature, String> dateModificationCol1;
    @FXML
    private TableColumn<Candidature, String> buttonsCol1;

    ObservableList<Candidature> candidaturesListRejected = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Candidature, String> idCol11;
    @FXML
    private TableColumn<Candidature, Number> offreCol11;
    @FXML
    private TableColumn<Candidature, String> recruteurCol11;
    @FXML
    private TableColumn<Candidature, String> candidatCol11;
    @FXML
    private TableColumn<Candidature, String> statusCol11;
    @FXML
    private TableColumn<Candidature, String> informationCol11;
    @FXML
    private TableColumn<Candidature, String> datePostulationCol11;
    @FXML
    private TableColumn<Candidature, String> dateModificationCol11;
    @FXML
    private TableColumn<Candidature, String> buttonsCol11;

    ObservableList<Candidature> candidaturesListAccepted = FXCollections.observableArrayList();

    
    public static Offre off;
    @FXML
    private Text nbAttente;
    @FXML
    private Text nbAccepted;
    @FXML
    private Text nbRejected;
    @FXML
    private PieChart pieReport;
    @FXML
    private PieChart pieChart;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

              
              
        fillTableView();
        fillTableViewRejected();
        fillTableViewAccepted();
        counters();
     pie();

        
    }
    
 

    
    
        public void counters() { 
        this.nbAttente.setText(Integer.toString(candidaturesList.size()));
        this.nbAccepted.setText(Integer.toString(candidaturesListAccepted.size()));
        this.nbRejected.setText(Integer.toString(candidaturesListRejected.size()));
    }
        
        
        public void pie(){
                      ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList (
            new PieChart.Data("En attente",candidaturesList.size()),
                                    new PieChart.Data("Acceptées",candidaturesListAccepted.size()),
            new PieChart.Data("Rejetées",candidaturesListRejected.size()));
              pieChart.setData(pieChartData);
              pieChart.setTitle("Candidatures");
        
        
        
        }
    @FXML
    private void btnAjoutOffre(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("ReadOffres.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReadOffresController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnClose(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnViewOffre() {
        try {
            candidaturesList.clear();
            ServiceCandidature s = new ServiceCandidature();
            s.afficherV2(candidaturesList, candidaturesTable);
            
            candidaturesListRejected.clear();
          
            s.afficherRejected(candidaturesListRejected, rejectedCandidaturesTable);
            
            candidaturesListAccepted.clear();
            
            s.afficherAccepted(candidaturesListAccepted, acceptedCandidaturesTable);
            
            
        this.nbAttente.setText(Integer.toString(candidaturesList.size()));
        this.nbAccepted.setText(Integer.toString(candidaturesListAccepted.size()));
        this.nbRejected.setText(Integer.toString(candidaturesListRejected.size()));
            
        } catch (IOException ex) {
            Logger.getLogger(ReadCandidaturesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection connection = null;

    private void fillTableView() {

        //add cell of button edit 
        Callback<TableColumn<Candidature, String>, TableCell<Candidature, String>> cellFoctory = (TableColumn<Candidature, String> param) -> {
            // cell button
            final TableCell<Candidature, String> cell = new TableCell<Candidature, String>() {
                //fill
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //if row empty
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } //if row has data
                    else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        deleteIcon.setStyle(" -fx-cursor: hand ;" + "-glyph-size:25px;" + "-fx-fill:#744124;");

                        //deletus
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            candidature = candidaturesTable.getSelectionModel().getSelectedItem();
                            ServiceCandidature s = new ServiceCandidature();
                            s.supprimer(new Candidature(candidature.getId()));
                            JOptionPane.showMessageDialog(null, "Candidature pour l'offre '" + candidature.getOffre() + "' supprimée.");
                        });

                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                        editIcon.setStyle(" -fx-cursor: hand ;" + "-glyph-size:25px;" + "-fx-fill:#BF833A;");

                        //mod
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            candidature = candidaturesTable.getSelectionModel().getSelectedItem();

                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("CandidatureEdit.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(ReadOffresController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                           
                            CandidatureEditController eoc = loader.getController();
                            eoc.setTextField(candidature.getOffre(),candidature.getId(), candidature.getRecruteur(), candidature.getCandidat(),
                                    candidature.getStatus(), candidature.getInformations(),
                                    candidature.getDatePostulation(), candidature.getDateModification());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                        });

                        /*
                         FontAwesomeIconView rejectIcon = new FontAwesomeIconView(FontAwesomeIcon.CHECK_SQUARE);
                        rejectIcon.setStyle(" -fx-cursor: hand ;"+ "-glyph-size:25px;"+ "-fx-fill:#BF833A;"); 
                        
                        //mod
                        rejectIcon.setOnMouseClicked((MouseEvent event) -> { 
                            candidature = candidaturesTable.getSelectionModel().getSelectedItem();
                            
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("CandidatureAccept.fxml"));
                            try {                                loader.load();                            } catch (IOException ex) {                                Logger.getLogger(ReadOffresController.class.getName()).log(Level.SEVERE, null, ex);                            }
                            CandidatureEditController eoc = loader.getController();
                            eoc.setTextField(candidature.getId(), candidature.getOffre(),candidature.getRecruteur(), candidature.getCandidat(), 
                                   "yepp",candidature.getInformations(),
 candidature.getDatePostulation(), candidature.getDateModification());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();    
                        });*/
                        setGraphic(new HBox(editIcon, deleteIcon/*, acceptIcon*/));

                    }
                }

            };

            return cell;
        };

        connection = DbConnect.getConnect();
        btnViewOffre();
        offreCol.setCellValueFactory(new PropertyValueFactory<>("offre"));
            
        titreOffreCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffre().getTitre()));
        recruteurCol.setCellValueFactory(new PropertyValueFactory<>("recruteur"));
        candidatCol.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        informationCol.setCellValueFactory(new PropertyValueFactory<>("informations"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        datePostulationCol.setCellValueFactory(new PropertyValueFactory<>("datePostulation"));
        dateModificationCol.setCellValueFactory(new PropertyValueFactory<>("dateModification"));
        buttonsCol.setCellFactory(cellFoctory);
        candidaturesTable.setItems(candidaturesList);
    }

    private void fillTableViewRejected() {

        //add cell of button edit 
        Callback<TableColumn<Candidature, String>, TableCell<Candidature, String>> cellFoctory = (TableColumn<Candidature, String> param) -> {
            // cell button
            final TableCell<Candidature, String> cell = new TableCell<Candidature, String>() {
                //fill
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                }

            };

            return cell;
        };

        connection = DbConnect.getConnect();
        btnViewOffre();
        offreCol1.setCellValueFactory(new PropertyValueFactory<>("offre"));
        titreOffreCol1.setCellValueFactory(new PropertyValueFactory<>("offre"));
           //     titreOffreCol1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffre().getTitre()));
        recruteurCol1.setCellValueFactory(new PropertyValueFactory<>("recruteur"));
        candidatCol1.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        statusCol1.setCellValueFactory(new PropertyValueFactory<>("status"));
        informationCol1.setCellValueFactory(new PropertyValueFactory<>("informations"));
        idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        datePostulationCol1.setCellValueFactory(new PropertyValueFactory<>("datePostulation"));
        dateModificationCol1.setCellValueFactory(new PropertyValueFactory<>("dateModification"));
        buttonsCol1.setCellFactory(cellFoctory);
        rejectedCandidaturesTable.setItems(candidaturesListRejected);
    }

    private void fillTableViewAccepted() {

        //add cell of button edit 
        Callback<TableColumn<Candidature, String>, TableCell<Candidature, String>> cellFoctory = (TableColumn<Candidature, String> param) -> {
            // cell button
            final TableCell<Candidature, String> cell = new TableCell<Candidature, String>() {
                //fill
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                }

            };

            return cell;
        };

        connection = DbConnect.getConnect();
        btnViewOffre();
        offreCol11.setCellValueFactory(new PropertyValueFactory<>("offre"));
       
      //  titreOffreCol11.setCellValueFactory(new PropertyValueFactory<>(k));
       
    //  Object titreOffre= offreCol11.getUserData();
    
    //  String titreOffre = offreCol11;
      //      titreOffreCol11.setCellValueFactory(cellDataa -> new SimpleStringProperty(titreOffre));
            titreOffreCol11.setCellValueFactory(new PropertyValueFactory<>("offre"));
            //  titreOffreCol11.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffre().getTitre()));
        recruteurCol11.setCellValueFactory(new PropertyValueFactory<>("recruteur"));
        candidatCol11.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        statusCol11.setCellValueFactory(new PropertyValueFactory<>("status"));
        informationCol11.setCellValueFactory(new PropertyValueFactory<>("informations"));
        idCol11.setCellValueFactory(new PropertyValueFactory<>("id"));
        datePostulationCol11.setCellValueFactory(new PropertyValueFactory<>("datePostulation"));
        dateModificationCol11.setCellValueFactory(new PropertyValueFactory<>("dateModification"));
        buttonsCol11.setCellFactory(cellFoctory);
        acceptedCandidaturesTable.setItems(candidaturesListAccepted);
    }

}
