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
public class AjoutCategorieController implements Initializable {

    @FXML
    private TextField NewType;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, String> type;
    private Button bModifier;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
        afficherCategorie((ActionEvent) event);        
// TODO
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

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void afficherCategorie(ActionEvent event) {
                ServiceCategorie sc = new ServiceCategorie();

        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Categorie> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Categorie e1, Categorie e2) -> e1.getType().compareTo(e2.getType()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void AjoutCategorie(ActionEvent event) {
         ServiceCategorie sc = new ServiceCategorie();

         sc.ajouter(new Categorie(NewType.getText() ));
          JOptionPane.showMessageDialog(null, "Categorie ajoutée !");
    }

    private void modifierCategorie(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("CategorieUpdate.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bModifier.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    private void supprimerCategorie(ActionEvent event) {
        ServiceCategorie sc = new ServiceCategorie();
        Categorie c = table.getSelectionModel().getSelectedItem();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        
        alert.setContentText(" VOULEZ VOUS SUPPRIMER cette categorie ?");
         
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sc.supprimer(c);

            JOptionPane.showMessageDialog(null, " categorie SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " categorie NON SUPPRIME ");
        }
        sc.afficher();
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategorieInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    }
    

