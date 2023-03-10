/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Paiement_Reservation_Evenement;
import com.travolta.services.ServicePaiement_Reservation_Evenement;
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
public class AjoutPaiementController implements Initializable {

    @FXML
    private TextField Newprix;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bAjouter;
    @FXML
    private TextField Newdescription;
    @FXML
    private TableView<Paiement_Reservation_Evenement> table;
    @FXML
    private TableColumn<Paiement_Reservation_Evenement, Float> prix;
    @FXML
    private TableColumn<Paiement_Reservation_Evenement, String> description;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ActionEvent event = new ActionEvent();
        afficherPaiement((ActionEvent) event);
        // TODO
    }    



    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaiementInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void afficherPaiement(ActionEvent event) {
  ServicePaiement_Reservation_Evenement spre = new ServicePaiement_Reservation_Evenement();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Paiement_Reservation_Evenement> list = FXCollections.observableList(spre.afficher());
//        id_evenement.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
//        id_reservation.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Paiement_Reservation_Evenement> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Paiement_Reservation_Evenement e1, Paiement_Reservation_Evenement e2) -> e1.getDescription().compareTo(e2.getDescription()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void ajouterPaiement(ActionEvent event) {
         ServicePaiement_Reservation_Evenement spre = new ServicePaiement_Reservation_Evenement();

         spre.ajouter(new Paiement_Reservation_Evenement(1,1, Float.parseFloat(Newprix.getText()), Newdescription.getText()));
          JOptionPane.showMessageDialog(null, "paiement ajoutée !");
      
    }
    
}
