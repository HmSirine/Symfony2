/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.ReservationExcursion;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjouterReservationPageController implements Initializable {

    @FXML
    private Button ButtonAjouterReservationManually;
    @FXML
    private TextField IdClientLabel;
    @FXML
    private Label PrixTotalLabel;
    @FXML
    private Button AnnulerAjoutReservationButton;
    @FXML
    private DatePicker date_field;
    @FXML
    private Label AjoutReservationError;
    @FXML
    private TextField PrixTotal_field;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
 
    
   
    

   
    @FXML
    private void AjouterReservationManually(ActionEvent event) {
        
                if (IdClientLabel.getText().isEmpty()||PrixTotal_field.getText().isEmpty()||date_field.getValue()== null){
                   AjoutReservationError.setVisible(true);
                }
                else {

        ReservationService rs=new ReservationService();
        ReservationExcursion reservationExcursion=new ReservationExcursion(Integer.parseInt(IdClientLabel.getText()) ,date_field.getValue(),Float.parseFloat(PrixTotal_field.getText() ) );
        reservationExcursion.setDateReservation(date_field.getValue());
        rs.Ajouter(reservationExcursion);
        
        Parent root;
        try {
            ButtonAjouterReservationManually.getScene().getWindow().hide();
            root = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterReservationPageController.class.getName()).log(Level.SEVERE, null, ex);
        }}
       
    }

    @FXML
    private void ToGestionReservation(ActionEvent event) {
        Parent root;
         try {
            root = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterReservationPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
