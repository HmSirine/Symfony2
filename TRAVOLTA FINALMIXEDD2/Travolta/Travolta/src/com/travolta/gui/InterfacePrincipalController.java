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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class InterfacePrincipalController implements Initializable {

    @FXML
    private Button Acceuil;
    @FXML
    private Button categorie;
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
    private Button reponse;
    @FXML
    private Button Statistique;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Acceuil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AdminPage.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Acceuil.getScene().getWindow();
        stage.setTitle("Menu"); 
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Categorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategorieInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) categorie.getScene().getWindow();
        stage.setTitle("Categorie Interface"); 
        stage.setScene(newScene);
        stage.show();
    }
    

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reservation.getScene().getWindow();
        stage.setTitle("Reservation Interface");
        
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Paiement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaiementInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        //Scene.setTitle("Paiement Interface");
        Stage stage = (Stage) paiement.getScene().getWindow();
        stage.setScene(newScene);
        //Scene.setTitle("Paiement Interface");
        stage.setTitle("Paiement Interface");
        
        // Set the scene for the stage
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Evenement(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) evenement.getScene().getWindow();
        stage.setTitle("Event Interface");
        stage.setScene(newScene);
        stage.show();
               
    }

    @FXML
    private void Game(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("snake.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) game.getScene().getWindow();
        stage.setTitle("Game Interface");
        stage.setScene(newScene);
        stage.show();
               
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReclamationInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reclamation.getScene().getWindow();
        stage.setTitle("Game Interface");
        stage.setScene(newScene);
        stage.show();
    
}

    private void Reponse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) reponse.getScene().getWindow();
        stage.setTitle("Game Interface");
        stage.setScene(newScene);
        stage.show();
}

    @FXML
    private void Statistique(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistique.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Statistique.getScene().getWindow();
        stage.setTitle("Game Interface");
        stage.setScene(newScene);
        stage.show();
}

    @FXML
    private void menu(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AdminPage.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    
}