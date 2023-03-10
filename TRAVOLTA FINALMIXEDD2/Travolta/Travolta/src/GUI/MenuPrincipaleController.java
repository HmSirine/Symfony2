/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import tests.WeatherAPI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class MenuPrincipaleController implements Initializable {

    @FXML
    private Button VMenu1;
    @FXML
    private Button Vmenu;
    @FXML
    private Button Vmenu2;
    @FXML
    private Label weatherid;
    @FXML
    private Label Tempc;
    @FXML
    private Label hmidity;
    @FXML
    private Button dhakertosirineAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         WeatherAPI api =new WeatherAPI();
   
   double apiss= (double) api.Getweather().get("temperature");
   double apis1= (double) api.Getweather().get("humidity");
  // double apis11= (double) api.Getweather().get("feels_like");
   String apistr= apiss+"";
   String apistr1= apis1+"";
  // String apistr11= apis11+"";
       setLweatherid(apistr);
       hmidity(apistr1);
    }    

    @FXML
    private void ToLocation(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuLocations.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) VMenu1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
         MenuLocationsController dpc = loader.getController();
         dpc.showLocation(event);
        
    }

    @FXML
    private void ToVehicule(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuVehicule.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Vmenu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
        
        MenuVehiculeController dpc = loader.getController();
         dpc.showVehicule(event);
    }

    @FXML
    private void ToReclamation(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("la gestion de reclamation est en maintenance ");
             alert.showAndWait();
             
             //MenuLocationsController dpc = loader.getController();
        // dpc.showLocation(event);
        
        
       /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("...fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Vmenu2.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();*/
    }
      public void setLweatherid(String prenom) {
      
        this.weatherid.setText(prenom);
    }
      
      public void Tempc(String prenom) {
      
        this.Tempc.setText(prenom);
    }
      public void hmidity(String prenom) {
      
        this.hmidity.setText(prenom);
    }

    @FXML
    private void DhakerToSirineAdlin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
