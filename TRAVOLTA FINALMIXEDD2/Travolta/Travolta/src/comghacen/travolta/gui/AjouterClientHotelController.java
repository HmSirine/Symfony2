/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package comghacen.travolta.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjouterClientHotelController implements Initializable {

    @FXML
    private Button AfficherReservation;
    @FXML
    private Button AjouterReservation;
    @FXML
    private TextField email;
    @FXML
    private DatePicker date_depart;
    @FXML
    private DatePicker date_arrivee;
    @FXML
    private Button Retour;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> date_arrivee2;
    @FXML
    private TableColumn<?, ?> date_depart2;
    @FXML
    private TableColumn<?, ?> traif2;
    @FXML
    private TableColumn<?, ?> nom1;
    @FXML
    private TableColumn<?, ?> prenom1;
    @FXML
    private TableColumn<?, ?> email1;
    @FXML
    private TableColumn<?, ?> nbchambre;
    @FXML
    private TextField nom;
    @FXML
    private TextField nombre_chambre;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tarif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherReservation(ActionEvent event) {
    }

    @FXML
    private void AjouterReservation(ActionEvent event) {
    }

    @FXML
    private void RetourMenu(ActionEvent event) {
    }

    @FXML
    private void selectEvent(MouseEvent event) {
    }
    
}
