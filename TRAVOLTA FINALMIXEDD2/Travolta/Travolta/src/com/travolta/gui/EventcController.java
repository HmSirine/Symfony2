/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.itextpdf.text.pdf.parser.Path;
import com.travolta.entities.Evenement;
import com.travolta.entities.Rating;
import com.travolta.services.ServiceEvenement;
import com.travolta.services.ServiceRating;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class EventcController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private TableColumn<Evenement, String> Lieu;
    @FXML
    private TableColumn<Evenement, String> Titre;
    @FXML
    private TableColumn<Evenement, Integer> Nbreplaces;
    @FXML
    private TableColumn<Evenement, Integer> Nbreparticipants;
    @FXML
    private TableColumn<Evenement, String> Datedebut;
    @FXML
    private TableColumn<Evenement, String> Datefin;
    @FXML
    private TableColumn<Evenement, String> Image;
    String path;
    BufferedImage bufferedImage;
    @FXML
    private Button bSupprimer;
    @FXML
    private TextField eChercher;
    @FXML
    private Button menu;
    @FXML
    private Button bchercher;
    @FXML
    private Button bLike;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = new ActionEvent();
        afficher((ActionEvent) event);
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
    private void afficher(ActionEvent event) {
        ServiceEvenement se = new ServiceEvenement();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Evenement> list = FXCollections.observableList(se.afficher());
        Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        Titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        Nbreplaces.setCellValueFactory(new PropertyValueFactory<>("nbreplaces"));
        Nbreparticipants.setCellValueFactory(new PropertyValueFactory<>("nbreparticipants"));
        Datedebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        Datefin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        Image.setCellValueFactory(new PropertyValueFactory<>("image"));
        // Créez une liste observable à partir de vos données


// Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Evenement> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Evenement e1, Evenement e2) -> e1.getTitre().compareTo(e2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);

        //table.setItems(list);
        
    }


    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Chercherevent(ActionEvent event) {
        ServiceEvenement rs = new ServiceEvenement();
        ObservableList<Evenement> list = FXCollections.observableList(rs.afficher());
        ServiceEvenement e = new ServiceEvenement();
        Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        Titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        Nbreplaces.setCellValueFactory(new PropertyValueFactory<>("nbreplaces"));
        Nbreparticipants.setCellValueFactory(new PropertyValueFactory<>("nbreparticipants"));
        Datedebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        Datefin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        Image.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list);

        rs.afficher();
      table.setItems(list);

        FilteredList<Evenement> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getLieu().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

   
    @FXML
    private void Rating(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ratingc.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bLike.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

}