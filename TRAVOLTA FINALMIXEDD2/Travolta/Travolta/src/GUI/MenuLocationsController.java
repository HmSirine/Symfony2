/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Locations;
import services.ServiceLocation;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class MenuLocationsController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Locations> table;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private TextField tfChercher;
    @FXML
    private Button bAjouter1;
    @FXML
    private TableColumn<Locations, String> VMC1;
    @FXML
    private TableColumn<Locations, String> DebutC1;
    @FXML
    private TableColumn<Locations, String> fin_locationC2;
    @FXML
    private TableColumn<Locations, String> DestinationC1;
    @FXML
    private TableColumn<Locations, Float> MontantC1;
    @FXML
    private TableColumn<Locations, Integer> StatusC1;
    @FXML
    private TableColumn<Locations, String> ClientC1;
    @FXML
    private Button AccueilB;
    @FXML
    private Button bChercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null ;
        showLocation(event);
        // TODO
    }    

    @FXML
    private void addLocation(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterLocation.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    public void showLocation(ActionEvent event) {
        ServiceLocation se = new ServiceLocation();
   
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Locations> list = FXCollections.observableList(se.afficher());
        DebutC1.setCellValueFactory(new PropertyValueFactory<>("debut_location"));
        fin_locationC2.setCellValueFactory(new PropertyValueFactory<>("fin_location"));
        DestinationC1.setCellValueFactory(new PropertyValueFactory<>("destination"));
        MontantC1.setCellValueFactory(new PropertyValueFactory<>("montant"));
        StatusC1.setCellValueFactory(new PropertyValueFactory<>("status"));
        VMC1.setCellValueFactory(new PropertyValueFactory<>("vehicule_id"));
        ClientC1.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        //DispoC1.setCellValueFactory(new PropertyValueFactory<>("status"));
        //ImageC1.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list); 
    }

    @FXML
    private void updateLocation(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierLocation.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
        ModifierVehiculeController dpc = loader.getController();
         dpc.afficherVehicule(event);
    }

    @FXML
    private void deleteEvent(ActionEvent event) {
    }

    @FXML
    private void refresh(ActionEvent event) {
        
          ServiceLocation se = new ServiceLocation();
        Locations r = table.getSelectionModel().getSelectedItem();
   

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER LOCATION ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);
            showLocation(event);

           // JOptionPane.showMessageDialog(null, " Location SUPPRIME ");
        } else {
           // JOptionPane.showMessageDialog(null, " Location NON SUPPRIME ");
        }
        se.afficher();

    }

    @FXML
    private void AccueilBut(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipale.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    
}
