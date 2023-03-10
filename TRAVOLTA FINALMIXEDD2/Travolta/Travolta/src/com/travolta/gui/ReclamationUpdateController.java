/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Reclamation;
import com.travolta.services.ServiceReclamation;
import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class ReclamationUpdateController implements Initializable {

    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private Button menu;
    @FXML
    private TextField NewDescription;
    @FXML
    private TextField NewMail;
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, String> mail;
    @FXML
    private TableColumn<Reclamation, String> description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                       ActionEvent event = new ActionEvent();
        afficherReclamation((ActionEvent) event); // TODO
    }    

    @FXML
    private void afficherReclamation(ActionEvent event) {
    ServiceReclamation se = new ServiceReclamation();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Reclamation> list = FXCollections.observableList(se.afficher());
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        // Créez une liste observable à partir de vos données


// Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Reclamation> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Reclamation e1, Reclamation e2) -> e1.getMail().compareTo(e2.getMail()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);

        //table.setItems(list);
    }

    @FXML
    private void updateReclamation(ActionEvent event) {
        ServiceReclamation se = new ServiceReclamation();

        String mail = NewMail.getText();
        if (NewMail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
         // Jouer le son
            String soundFile = "C:\\xampp\\htdocs\\Travolta.events\\src\\com\\travolta\\utils\\son\\alert.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());  
         alert.showAndWait();
        } else {
        
        Reclamation e =  (Reclamation) table.getSelectionModel().getSelectedItem();
        
        e.setMail(NewMail.getText());
        e.setDescription(NewDescription.getText());
        
        
        se.modifier(e);
        se.afficher();
         
    }
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ReclamationInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void getSelected() {
        int index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    NewMail.setText(mail.getCellData(index).toString());
    NewDescription.setText(description.getCellData(index).toString());
    
       
    }
    
}
