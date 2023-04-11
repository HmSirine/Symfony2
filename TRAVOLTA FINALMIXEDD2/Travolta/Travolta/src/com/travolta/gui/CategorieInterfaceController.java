/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Categorie;
import com.travolta.services.ServiceCategorie;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CategorieInterfaceController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie,String> type;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bSupprimer;
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
        AfficherCategorie((ActionEvent) event);  // TODO
    }    
public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travolta", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    private void addEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutCategorie.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void ajouterCategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutCategorie.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bAjouter.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void AfficherCategorie(ActionEvent event) {
        ServiceCategorie sc = new ServiceCategorie();

        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
SortedList<Categorie> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Categorie e1, Categorie e2) -> e1.getType().compareTo(e2.getType()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);       
// table.setItems(list);
    }

    @FXML
    private void modifierCategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategorieUpdate.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bModifier.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void SupprimerCategorie(ActionEvent event) throws Exception{
        ServiceCategorie sc = new ServiceCategorie();
        Categorie c = table.getSelectionModel().getSelectedItem();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER LA CATEGORIE ?");
        // Jouer le son
            String soundFile = "C:\\xampp\\htdocs\\Travolta.events\\src\\com\\travolta\\utils\\son\\alert.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sc.supprimer(c);

            JOptionPane.showMessageDialog(null, " CATEGORIE SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " CATEGORIE NON SUPPRIME ");
        }
        sc.afficher();
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
    private void Chercherevent(ActionEvent event) {
        ServiceCategorie rs = new ServiceCategorie();
        ObservableList<Categorie> list = FXCollections.observableList(rs.afficher());
        ServiceCategorie e = new ServiceCategorie();
        //ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        table.setItems(list);

        rs.afficher();
      table.setItems(list);

        FilteredList<Categorie> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getType().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Categorie> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
    
}
