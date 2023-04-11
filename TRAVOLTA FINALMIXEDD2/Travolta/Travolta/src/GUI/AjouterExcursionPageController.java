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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Excursion;
import models.ReservationExcursion;
import services.ExcursionService;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjouterExcursionPageController implements Initializable {

    @FXML
    private TextField TypeExcursionLabel;
    @FXML
    private TextField PrixExcursionLabel;
    @FXML
    private Label PrixTotalLabel;
    @FXML
    private TextField NombrePersonneLabel;
    @FXML
    private Button AnnulerAjoutExcursionButton;
    @FXML
    private Button ButtonAjouterExcursion;
    @FXML
    private Label error_excur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void ToGestionExcursion(ActionEvent event) {
        AnnulerAjoutExcursionButton.getScene().getWindow().hide();
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GestionExcursion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterExcursionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void AjouterExcursion(ActionEvent event) {
   
        
       
        if (TypeExcursionLabel.getText().isEmpty()||NombrePersonneLabel.getText().isEmpty()||PrixExcursionLabel.getText().isEmpty()){
            error_excur.setVisible(true);
        }
        else{
            ExcursionService es=new ExcursionService();
            Excursion ex=new Excursion(TypeExcursionLabel.getText() ,Integer.parseInt(NombrePersonneLabel.getText()),Float.parseFloat(PrixExcursionLabel.getText() ) );
            es.Ajouter(ex);
             try {
            AnnulerAjoutExcursionButton.getScene().getWindow().hide();
            
            
            Parent root = FXMLLoader.load(getClass().getResource("GestionExcursion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex1) {
            Logger.getLogger(AjouterExcursionPageController.class.getName()).log(Level.SEVERE, null, ex1);
        }}
       
    }
    
}
