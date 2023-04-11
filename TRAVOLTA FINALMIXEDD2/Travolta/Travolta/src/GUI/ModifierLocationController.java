/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Client;
import models.Locations;
import models.Vehicule;
import services.ServiceClient;
import services.ServiceLocation;
import services.ServiceVehicule;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class ModifierLocationController implements Initializable {

    @FXML
    private DatePicker tfdebut;
    @FXML
    private TextField tfDestination;
    @FXML
    private Button bAfficher;
    @FXML
    private Button VModifier;
    @FXML
    private TableView<Locations> table;
    @FXML
    private TableColumn<Locations, String> VMC1;
    @FXML
    private TableColumn<Locations, LocalDate> DebutC1;
    @FXML
    private TableColumn<Locations, LocalDate> fin_locationC2;
    @FXML
    private TableColumn<Locations, String> DestinationC1;
    @FXML
    private TableColumn<Locations, Float> MontantC1;
    @FXML
    private TableColumn<Locations, Integer> StatusC1;
    @FXML
    private TableColumn<Locations, String> ClientC1;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfStatus1;
    @FXML
    private Button bMenu1;
    @FXML
    private TextField tfClient1;
    @FXML
    private TextField tfVehicule1;
    @FXML
    private DatePicker tfflocation1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ActionEvent event = null;
         afficherLocation(event);
        // TODO
    }    

    @FXML
    private void afficherLocation(ActionEvent event) {
           ServiceLocation se = new ServiceLocation();
             // ServiceClient c =new ServiceClient();
              //String nomm=c.findUserNamebyId(1);
              //String propertyName = c.findUserNamebyId(1);

           
   
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Locations> list = FXCollections.observableList(se.afficher());
        DebutC1.setCellValueFactory(new PropertyValueFactory<>("debut_location"));
        fin_locationC2.setCellValueFactory(new PropertyValueFactory<>("fin_location"));
        DestinationC1.setCellValueFactory(new PropertyValueFactory<>("destination"));
        MontantC1.setCellValueFactory(new PropertyValueFactory<>("montant"));
        StatusC1.setCellValueFactory(new PropertyValueFactory<>("status"));
         VMC1.setCellValueFactory(new PropertyValueFactory<>("vehicule_id"));
        ClientC1.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        
      // ClientC1.setCellValueFactory(new PropertyValueFactory<>(nomm));
        //ClientC1.setText(nomm);
        //DispoC1.setCellValueFactory(new PropertyValueFactory<>("status"));
        //ImageC1.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list); 
    }

    @FXML
    private void ModifierLocation(ActionEvent event) throws IOException {
        
                ServiceLocation se = new ServiceLocation();

        String lieu = tfStatus1.getText();
        if (tfStatus1.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else {
        
        Locations e =  (Locations) table.getSelectionModel().getSelectedItem();
        
        e.setDebut_location(tfdebut.getValue() );
        e.setFin_location(tfflocation1.getValue() );
        e.setDestination(tfDestination.getText());
        e.setMontant(Float.valueOf(tfPrix.getText()));
       // e.setNb_place(Integer.valueOf(tfNbplace.getText()));
        e.setStatus(Integer.valueOf(tfStatus1.getText()));
        e.setVehicule_id(Integer.valueOf(tfVehicule1.getText()));
        e.setClient_id( Integer.valueOf( tfClient1.getText() ));
        //e.setImage(tfimage.getText());
        
        se.modifier(e);
        se.afficher();
        afficherLocation(event);
    }
          }

    @FXML
    private void selectEvent(MouseEvent event) {
             int index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    tfDestination.setText(DestinationC1.getCellData(index).toString());
    tfPrix.setText(MontantC1.getCellData(index).toString());
    tfStatus1.setText(StatusC1.getCellData(index).toString());
    tfClient1.setText(ClientC1.getCellData(index).toString());
    tfVehicule1.setText(VMC1.getCellData(index).toString());
   // tfdebut.setText(DebutC1.getCellData(index).toString);
   // tfflocation1.setText(fin_locationC2.getCellData(index).toString());
    }

    @FXML
    private void MenuBack(ActionEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuLocations.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bMenu1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    }
    

