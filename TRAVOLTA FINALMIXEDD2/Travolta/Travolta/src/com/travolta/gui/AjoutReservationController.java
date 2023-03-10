/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Reservation_Evenement;
import com.travolta.services.ServiceReservation_Evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class AjoutReservationController implements Initializable {

    @FXML
    private TextField NewNom;
    @FXML
    private TextField NewMail;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bAjouter;
    @FXML
    private TextField NewPrenom;
    @FXML
    private TextField NewTel;
    @FXML
    private TextField NewHeure_arrivee;
    @FXML
    private TableView<Reservation_Evenement> table;
    @FXML
    private TableColumn<Reservation_Evenement, String> nom;
    @FXML
    private TableColumn<Reservation_Evenement, String> prenom;
    @FXML
    private TableColumn<Reservation_Evenement, String> mail;
    @FXML
    private TableColumn<Reservation_Evenement, String> tel;
    @FXML
    private TableColumn<Reservation_Evenement, String> heure_arrivee;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
        afficherReservation((ActionEvent) event);// TODO
    }    


    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void afficherReservation(ActionEvent event) {
        ServiceReservation_Evenement sre = new ServiceReservation_Evenement();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Reservation_Evenement> list = FXCollections.observableList(sre.afficher());
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        heure_arrivee.setCellValueFactory(new PropertyValueFactory<>("heure_arriver"));
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Reservation_Evenement> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Reservation_Evenement e1, Reservation_Evenement e2) -> e1.getNom().compareTo(e2.getNom()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void AjouterReservation(ActionEvent event) {
         ServiceReservation_Evenement sre = new ServiceReservation_Evenement();

         sre.ajouter(new Reservation_Evenement(NewNom.getText(), NewPrenom.getText(), NewMail.getText(), NewTel.getText(), NewHeure_arrivee.getText()  ));
          JOptionPane.showMessageDialog(null, "Reservation ajoutée !");
    }
    
}
