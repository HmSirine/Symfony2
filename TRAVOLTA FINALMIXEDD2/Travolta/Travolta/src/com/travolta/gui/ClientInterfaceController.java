/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

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
 * @author aghx0
 */
public class ClientInterfaceController implements Initializable {

    @FXML
    private Button Acceuil;
    @FXML
    private Button reservation;
    @FXML
    private Button paiement;
    @FXML
    private Button evenement;
    @FXML
    private Button game;
    @FXML
    private Button reclamation;
    @FXML
    private Button menu;
    @FXML
    private Button qrcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Acceuil(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reservation.getScene().getWindow();
        stage.setTitle("Acceuil");
        
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutReservationc.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reservation.getScene().getWindow();
        stage.setTitle("Reservation Interface");
        
        stage.setScene(newScene);
        stage.show();
    }
    @FXML
    private void Paiement(ActionEvent event)  throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutPaiementc.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reservation.getScene().getWindow();
        stage.setTitle("Paiement Interface");
        
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Evenement(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Eventc.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reservation.getScene().getWindow();
        stage.setTitle("Evenement Interface");
        
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Game(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("snake.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) game.getScene().getWindow();
        stage.setTitle("Game Interface");
        stage.setScene(newScene);
        stage.show();
               
    }

    @FXML
    private void Reclamation(ActionEvent event)  throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutReclamationc.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reservation.getScene().getWindow();
        stage.setTitle("Reclamation Interface");
        
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void menu(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Qrcode(ActionEvent event)   throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Qrcode.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) qrcode.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    
}
