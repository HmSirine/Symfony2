/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.ReservationChambreHotel;
import services.ServiceReservationChambreHotel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
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
 * @author Ghassen Chamakh
 */
public class InterfaceReservationChambreCLientController implements Initializable {

    @FXML
    private Button ajouterReservation;
    @FXML
    private Button afficherReservation;
    @FXML
    private Button modifierReservation;
    @FXML
    private Button supprimerReservation;
    @FXML
    private Button Retour;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bchercher;
    @FXML
    private Button imprimerButton;
    @FXML
    private TableView<ReservationChambreHotel> table;
    @FXML
    private TableColumn<ReservationChambreHotel, LocalDate> date_arrivee2;
    @FXML
    private TableColumn<ReservationChambreHotel, LocalDate> date_depart2;
    @FXML
    private TableColumn<ReservationChambreHotel, Float> traif2;
    @FXML
    private TableColumn<ReservationChambreHotel, String> nom1;
    @FXML
    private TableColumn<ReservationChambreHotel, String> prenom1;
    @FXML
    private TableColumn<?, ?> email1;
    @FXML
    private TableColumn<?, ?> nbchambre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ActionEvent event = null;
        
          
         afficherReservation(event);
    }    

    @FXML
    private void ajouterReservation(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReservation.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage)  ajouterReservation.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void afficherReservation(ActionEvent event) {
                    ServiceReservationChambreHotel srch = new ServiceReservationChambreHotel();
        ObservableList<ReservationChambreHotel> list = FXCollections.observableList(srch.afficher());
       date_arrivee2.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        date_depart2.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
       traif2.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
       prenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nbchambre.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
       email1.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        table.setItems(list);
        
        //table.setItems(list);
                    // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<ReservationChambreHotel> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((ReservationChambreHotel rh1, ReservationChambreHotel rh22) -> rh1.getNom().compareTo(rh22.getNom()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    

    @FXML
    private void modifierReservation(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReservationClient.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage)  modifierReservation.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void supprimerReservation(ActionEvent event) {
            ServiceReservationChambreHotel srch = new ServiceReservationChambreHotel();
        ReservationChambreHotel h = table.getSelectionModel().getSelectedItem();
        

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// alert de confirmation suppression
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER lA RESERVATION ?");
         // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\good.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            srch.supprimer(h);

            JOptionPane.showMessageDialog(null, " Reservation supprimer ");
        } else {
            JOptionPane.showMessageDialog(null, " Reservation non supprimer ");
        }
        srch.afficher();
    }

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Chercherevent(ActionEvent event) {
    }

    @FXML
    private void imprimerButton(ActionEvent event) {
        
    }
    
}
