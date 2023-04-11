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
 * @author Ghassen Chamakh
 */
public class FirstInterfaceController implements Initializable {

    @FXML
    private Button clientbutton;
    @FXML
    private Button adminbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ToClientFirstPage(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) clientbutton.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void ToGestionReservation(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) adminbutton.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    
}
