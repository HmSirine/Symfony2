/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class InterfaceHotelController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField adresse;
    @FXML
    private Button Afficher;
    @FXML
    private Button Ajouter;
    @FXML
    private TextField description;
    @FXML
    private TextField etoile;
    @FXML
    private TextField image;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> address;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherHotel(ActionEvent event) {
    }

    @FXML
    private void ajouterHotel(ActionEvent event) {
    }

    @FXML
    private void modifierHotel(ActionEvent event) {
    }

    @FXML
    private void supprimerHotel(ActionEvent event) {
    }

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void RetourMenu(ActionEvent event) {
    }
    
}
