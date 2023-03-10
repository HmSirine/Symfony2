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
import telegram.SendMessage;
import tests.GeolocationExample;
import tests.SendTest;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.ClientDhaker;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class AjouterLocationController implements Initializable {

    @FXML
    private Button VAjouter;
    @FXML
    private TableView<Locations> table;
    @FXML
    private TextField tfPrix;
    @FXML
    private Button bMenu1;
    @FXML
    private DatePicker tfdebut;
    @FXML
    private TextField tfDestination;
    @FXML
    private DatePicker tfflocation;
    @FXML
    private TextField tfStatus1;
    @FXML
    private TableColumn<Locations, String> VMC1;
    @FXML
    private TableColumn<Locations, String> DebutC1;
    @FXML
    private TableColumn<Locations, LocalDate> fin_locationC2;
    @FXML
    private TableColumn<Locations, LocalDate> DestinationC1;
    @FXML
    private TableColumn<Locations, Float> MontantC1;
    @FXML
    private TableColumn<Locations, Integer> StatusC1;
    @FXML
    private TableColumn<Locations, String> ClientC1;
    @FXML
    private Button tfGetLocation;
    @FXML
    private TextField tfClient1;
    @FXML
    private TextField tfVehicule1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO,
        ActionEvent event = null;
       afficherLocation(event);
    }    


    @FXML
    private void selectEvent(MouseEvent event) {
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

    private void afficherLocation(ActionEvent event) {
        
            ServiceLocation se = new ServiceLocation();
         ServiceClient cl =new ServiceClient();
     //  String  username= cl.findUserNamebyId(1);
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Locations> list = FXCollections.observableList(se.afficher());
        ObservableList<ClientDhaker> lists = FXCollections.observableList(cl.afficherNom(1));
        DebutC1.setCellValueFactory(new PropertyValueFactory<>("debut_location"));
        fin_locationC2.setCellValueFactory(new PropertyValueFactory<>("fin_location"));
        DestinationC1.setCellValueFactory(new PropertyValueFactory<>("destination"));
        MontantC1.setCellValueFactory(new PropertyValueFactory<>("montant"));
        StatusC1.setCellValueFactory(new PropertyValueFactory<>("status"));
        VMC1.setCellValueFactory(new PropertyValueFactory<>("vehicule_id"));
        ClientC1.setCellValueFactory(new PropertyValueFactory<>("client_nom"));
        //DispoC1.setCellValueFactory(new PropertyValueFactory<>("status"));
        //ImageC1.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list); 
       // table.setItems(/*lists*/); 
    }

    @FXML
    private void AjouterLocation(ActionEvent event) throws IOException {
        
          ServiceLocation sp = new ServiceLocation();
          //sp.ajouter(new location (tfdebut.getText(),fin_locationC2.getText(), DestinationC1.getText(),100, Integer.parseInt(StatusC1.getText()) ));
LocalDate sqldate_arrivee = tfdebut.getValue();
LocalDate sqldate_depart = tfflocation.getValue();
          sp.ajouter(new Locations(Integer.parseInt(tfClient1.getText() ),Integer.parseInt(tfVehicule1.getText()),sqldate_arrivee, sqldate_depart, tfDestination.getText(), Float.parseFloat( tfPrix.getText() ), Integer.parseInt(tfStatus1.getText() ) ));
          afficherLocation(event);
          SendMessage tele = new SendMessage() ;
          tele.sendToTelegram();
           
         // SendTest sms = new SendTest() ;
         // sms.SendSMS();
          
         
    }

    @FXML
    private void GetLocation(ActionEvent event) throws IOException {
        GeolocationExample ip =new GeolocationExample();
         String city = ip.GetLocationfromip();
      
        tfDestination.setText(city);
        
    }
    
}
