/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Vehicule;
import services.ServiceVehicule;
import tests.WeatherAPI;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class MenuVehiculeController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Vehicule> table;
    @FXML
    private TableColumn<Vehicule, String> prixC;
    @FXML
    private TableColumn<Vehicule, String> dateC;
    @FXML
    private TableColumn<Vehicule, String> dateC1;
    @FXML
    private TableColumn<Vehicule, Float> dateC11;
    @FXML
    private TableColumn<Vehicule, Integer> dateC111;
    @FXML
    private TableColumn<Vehicule, Integer> dateC1111;
    @FXML
    private TableColumn<Vehicule, String> dateC11111;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private Button bAjouter1;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bChercher;
    @FXML
    private Button AccueilBut;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void selectEvent(MouseEvent event) {
    }


    @FXML
    private void deleteEvent(ActionEvent event) {
    }

    @FXML
    private void refresh(ActionEvent event) throws Exception {
         ServiceVehicule se = new ServiceVehicule();
        Vehicule r = table.getSelectionModel().getSelectedItem();
   

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER Vehicule ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);

            //JOptionPane.showMessageDialog(null, " Vehicule SUPPRIME ");
        } else {
            //JOptionPane.showMessageDialog(null, " Vehicule NON SUPPRIME ");
        }
        se.afficher();
        showVehicule(event);

        
        /*
        ServiceVehicule se = new ServiceVehicule();
        Vehicule r = table.getSelectionModel().getSelectedItem();
        r.setVehicule_id(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER VEHICULE ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);

            JOptionPane.showMessageDialog(null, " VEHICULE SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " VEHICULE NON SUPPRIME ");
        }
        se.afficher();*/
    
    }

    @FXML
    private void addVehicule(ActionEvent event) throws IOException {
         
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterVehicule.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter1.getScene().getWindow();
        stage.setScene(newScene);
        
        stage.show();
         MenuVehiculeController dpc = loader.getController();
         dpc.showVehicule(event);
       
        
       
         // AnchorPane pane = FXMLLoader.load(getClass().getResource("AjoutVehicule.fxml"));
          // rootPane.getChildren().setAll(pane);
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutVehicule.fxml"));
       // Parent root = loader.load();
        //tfMarque.getScene().setRoot(root);
    }

    @FXML
    public void showVehicule(ActionEvent event) {
        
            ServiceVehicule se = new ServiceVehicule();
   
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Vehicule> list = FXCollections.observableList(se.afficher());
        prixC.setCellValueFactory(new PropertyValueFactory<>("marque"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        dateC1.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        dateC11.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dateC111.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        dateC1111.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateC11111.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list); 
    }

    @FXML
    private void updateVehicule(ActionEvent event) throws IOException {
           
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierVehicule.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bModifier.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
        // show again
         MenuVehiculeController dpc = loader.getController();
         dpc.showVehicule(event);
      
   
       
    }

    @FXML
    private void reCherche(ActionEvent event) {
        ServiceVehicule rs = new ServiceVehicule();
        ObservableList<Vehicule> list = FXCollections.observableList(rs.afficher());
        ServiceVehicule e = new ServiceVehicule();
        //ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
        prixC.setCellValueFactory(new PropertyValueFactory<>("marque"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        dateC1.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        dateC11.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dateC111.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        dateC1111.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateC11111.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list);

        rs.afficher();
      table.setItems(list);

        FilteredList<Vehicule> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Vehicule -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Vehicule.getMatricule().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Vehicule> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void AccueilButton(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipale.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
        
        MenuPrincipaleController dpc = loader.getController();
         WeatherAPI api =new WeatherAPI();
   
   double apiss= (double) api.Getweather().get("temperature");
   double apis1= (double) api.Getweather().get("humidity");
  // double apis11= (double) api.Getweather().get("feels_like");
   String apistr= apiss+"";
   String apistr1= apis1+"";
  // String apistr11= apis11+"";
        dpc.setLweatherid(apistr);
        dpc.hmidity(apistr1);
       // dpc.Tempc(apistr11);
    }
    
}
