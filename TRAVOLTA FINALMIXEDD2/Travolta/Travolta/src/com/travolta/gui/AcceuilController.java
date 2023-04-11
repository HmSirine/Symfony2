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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button Acceuil;
    @FXML
    private Button client;
    @FXML
    private Button admin;
    private Button modeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Acceuil(ActionEvent event) {
    }

    @FXML
    private void Client(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) client.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Admin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) admin.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    public void toggleMode(ActionEvent event) {
    Scene scene = ((Node)event.getSource()).getScene();
    if (scene.getStylesheets().contains("dark.css")) {
        scene.getStylesheets().remove("dark.css");
        modeBtn.getStyleClass().remove("dark-mode");
        modeBtn.getStyleClass().add("light-mode");
        modeBtn.setText("Light Mode");
    } else {
        scene.getStylesheets().add("dark.css");
        modeBtn.getStyleClass().remove("light-mode");
        modeBtn.getStyleClass().add("dark-mode");
        modeBtn.setText("Dark Mode");
    }
}
}
