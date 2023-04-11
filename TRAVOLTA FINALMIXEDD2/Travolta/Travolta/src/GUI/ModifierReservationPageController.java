/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ModifierReservationPageController implements Initializable {

    @FXML
    private TextField IdClientLabel;
    @FXML
    private Label PrixTotalLabel;
    @FXML
    private DatePicker DateReservationLabel;
    @FXML
    private Button AnnulerAjoutReservationButton;
    @FXML
    private Button ButtonAjouterReservationManually;
    @FXML
    private Label ModifReservationError;
    @FXML
    private TextField PrixTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    
    @FXML
    private void AjouterReservationManually(ActionEvent event) {
        if (IdClientLabel.getText().isEmpty()||PrixTotal.getText().isEmpty()||DateReservationLabel.getValue()== null){
                   ModifReservationError.setVisible(true);
                }
                else {
        ReservationService rs=new ReservationService();
        rs.Update(GestionReservationController.idReservation,Integer.parseInt(IdClientLabel.getText()) , DateReservationLabel.getValue(),Float.parseFloat(PrixTotal.getText()));
        Parent root;
         try {
            PrixTotal.getScene().getWindow().hide();

            root = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierReservationPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
}
   
