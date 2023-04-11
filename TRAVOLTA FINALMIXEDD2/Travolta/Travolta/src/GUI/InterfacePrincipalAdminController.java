/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Hotel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class InterfacePrincipalAdminController implements Initializable {

    @FXML
    private Button Acceuil;
    @FXML
    private Button Chambre;
    @FXML
    private Button Maison;
    @FXML
    private Button ReservationMaison;
    @FXML
    private Button reservationHotel;
    //private Button Hotel1;
    @FXML
    private Button Hotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Acceuil(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Acceuil.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void chambre(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceChambre.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Chambre.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void maison(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceMaison.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Maison.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void reservationmaison(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationMaison.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Hotel.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void reservationhotel(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReservation.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Hotel.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Hotel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hotel.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Hotel.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    
}
