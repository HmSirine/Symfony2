/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Paiement_Reservation_Evenement;
import com.travolta.services.ServicePaiement_Reservation_Evenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class PaiementInterfaceController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bSupprimer;
    @FXML
    private TableView<Paiement_Reservation_Evenement> table;
    private TableColumn<Paiement_Reservation_Evenement, Integer> id_evenement;
    private TableColumn<Paiement_Reservation_Evenement, Integer> id_reservation;
    @FXML
    private TableColumn<Paiement_Reservation_Evenement, Float> prix;
    @FXML
    private TableColumn<Paiement_Reservation_Evenement, String> description;
    @FXML
    private Button menu;
    @FXML
    private Button bchercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
        afficherPaiement((ActionEvent) event);        
// TODO
    }    


    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void ajouterPaiement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutPaiement.fxml"));
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
    private void modifierPaiement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaiementUpdate.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void supprimerPaiement(ActionEvent event) {
        ServicePaiement_Reservation_Evenement spre = new ServicePaiement_Reservation_Evenement();
        Paiement_Reservation_Evenement r = table.getSelectionModel().getSelectedItem();
   

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER CETTE PAIEMENT ?");
        // Jouer le son
            String soundFile = "C:\\xampp\\htdocs\\Travolta.events\\src\\com\\travolta\\utils\\son\\alert.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            spre.supprimer(r);

            JOptionPane.showMessageDialog(null, " PAIEMENT SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " PAIEMENT NON SUPPRIME ");
        }
        spre.afficher();
    }

    @FXML
    private void Chercherevent(ActionEvent event) {
        ServicePaiement_Reservation_Evenement rs = new ServicePaiement_Reservation_Evenement();
        ObservableList<Paiement_Reservation_Evenement> list = FXCollections.observableList(rs.afficher());
        ServicePaiement_Reservation_Evenement e = new ServicePaiement_Reservation_Evenement();
        //ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
//        id_evenement.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
//        id_reservation.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        table.setItems(list);

        rs.afficher();
      table.setItems(list);

        FilteredList<Paiement_Reservation_Evenement> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Paiement_Reservation_Evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
    
}
