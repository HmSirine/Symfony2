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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class PaiementUpdateController implements Initializable {

    @FXML
    private TextField Newprix;
    @FXML
    private Button bAfficher;
    @FXML
    private TextField Newdescription;
    @FXML
    private TableView<Paiement_Reservation_Evenement> table;
    @FXML
    private TableColumn<Paiement_Reservation_Evenement, Float> prix;
    @FXML
    private TableColumn<Paiement_Reservation_Evenement, String> description;
    @FXML
    private Button bModifier;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  ActionEvent event = new ActionEvent();
        afficherPaiement((ActionEvent) event);  // TODO
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
       
        table.setItems(list);
    }

    @FXML
    private void modifierPaiement(ActionEvent event) {
        ServicePaiement_Reservation_Evenement spre = new ServicePaiement_Reservation_Evenement();

        String  prix = Newprix.getText();
        if (Newprix.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else {
        
        Paiement_Reservation_Evenement e =  (Paiement_Reservation_Evenement) table.getSelectionModel().getSelectedItem();
        
//        e.setId_evenement(Integer.valueOf(Newid_evenement.getText()));
//        e.setId_reservation(Integer.valueOf(Newid_reservation.getText()));
        e.setPrix(Float.valueOf(Newprix.getText()));
        e.setDescription(Newdescription.getText());
        
        spre.modifier(e);
        spre.afficher();
        
    }
    
}

    @FXML
     private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    Newprix.setText(prix.getCellData(index).toString());
    Newdescription.setText(description.getCellData(index).toString());
    
       
    }
    }
