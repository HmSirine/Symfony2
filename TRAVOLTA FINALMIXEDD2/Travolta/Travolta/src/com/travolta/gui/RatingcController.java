/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Rating;
import com.travolta.services.ServiceRating;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
 * @author aghx0
 */
public class RatingcController implements Initializable {

    @FXML
    private TextField id_evenement;
    @FXML
    private TableView<Rating> table;
    @FXML
    private Button bDislike;
    @FXML
    private Button bLike;
    @FXML
    private Button menu;
    @FXML
    private TableColumn<Rating, Integer> Id_evenement;
    @FXML
    private TableColumn<Rating, String> Etat;
    @FXML
    private Button bAfficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
        afficher((ActionEvent) event);        // TODO
    }    

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void dislike(ActionEvent event) {
          ServiceRating r = new ServiceRating();
          Rating e = table.getSelectionModel().getSelectedItem();
   

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT rating");
        alert.setHeaderText(null);
        alert.setContentText(" Dislike ?");
//        // Jouer le son
//            String soundFile = "C:\\xampp\\htdocs\\Travolta.events\\src\\com\\travolta\\utils\\son\\alert.wav";
//            Media sound = new Media(new File(soundFile).toURI().toString());
//            MediaPlayer mediaPlayer = new MediaPlayer(sound);
//            mediaPlayer.setOnReady(() -> mediaPlayer.play());
//            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           r.modifier(new Rating(Integer.valueOf(id_evenement.getText()), "Disliked"));

            JOptionPane.showMessageDialog(null, " Dislike ");
        } else {
            JOptionPane.showMessageDialog(null, " Annuler ");
        }
        r.afficher(); 
        
        
        //r.modifier(new Rating(Integer.valueOf(id_evenement.getText()), 0));
//    JOptionPane.showMessageDialog(null, "Dislike !");
//    r.afficher();
        
    
    }
    

    @FXML
    private void like(ActionEvent event) {
        ServiceRating r = new ServiceRating();
          Rating e = table.getSelectionModel().getSelectedItem();
   

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT rating");
        alert.setHeaderText(null);
        alert.setContentText(" like ?");
//        // Jouer le son
//            String soundFile = "C:\\xampp\\htdocs\\Travolta.events\\src\\com\\travolta\\utils\\son\\alert.wav";
//            Media sound = new Media(new File(soundFile).toURI().toString());
//            MediaPlayer mediaPlayer = new MediaPlayer(sound);
//            mediaPlayer.setOnReady(() -> mediaPlayer.play());
//            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            r.modifier(new Rating(Integer.valueOf(id_evenement.getText()), "liked"));

            JOptionPane.showMessageDialog(null, " like ");
        } else {
            JOptionPane.showMessageDialog(null, " Annuler ");
        }
        r.afficher(); 
        
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Eventc.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void afficher(ActionEvent event) {
         ServiceRating r = new ServiceRating();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Rating> list = FXCollections.observableList(r.afficher());
        Id_evenement.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        Etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        
        table.setItems(list);
        
    }
    
}
