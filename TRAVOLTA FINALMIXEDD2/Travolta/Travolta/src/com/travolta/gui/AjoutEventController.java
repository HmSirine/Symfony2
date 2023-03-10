/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Evenement;
import com.travolta.services.ServiceEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
public class AjoutEventController implements Initializable {

    @FXML
    private TextField NewLieu;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private TableColumn<Evenement, String> lieu;
    @FXML
    private TableColumn<Evenement, String> titre;
    @FXML
    private TableColumn<Evenement, Integer> nbreplaces;
    @FXML
    private TableColumn<Evenement, Integer> nbreparticipants;
    @FXML
    private TableColumn<Evenement, LocalDate> datedebut;
    @FXML
    private TableColumn<Evenement, LocalDate> datefin;
    @FXML
    private TableColumn<Evenement, String> image;
    @FXML
    private TextField NewTitre;
    @FXML
    private TextField Nbreparticipants;
    @FXML
    private TextField NewNbrelpaces;
    @FXML
    private TextField NewImage;
    @FXML
    private DatePicker NewDatefin;
    @FXML
    private DatePicker NewDatedebut;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
        afficherEvent((ActionEvent) event);        
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
    private void afficherEvent(ActionEvent event) {
        ServiceEvenement se = new ServiceEvenement();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Evenement> list = FXCollections.observableList(se.afficher());
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        nbreplaces.setCellValueFactory(new PropertyValueFactory<>("nbreplaces"));
        nbreparticipants.setCellValueFactory(new PropertyValueFactory<>("nbreparticipants"));
        datedebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        datefin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Evenement> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Evenement e1, Evenement e2) -> e1.getTitre().compareTo(e2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }


    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void ajoutEvent(ActionEvent event) {
        
        ServiceEvenement se = new ServiceEvenement();
LocalDate sqldate_DateDebut = NewDatedebut.getValue();
LocalDate sqldate_DateFin = NewDatefin.getValue();
         se.ajouter(new Evenement(NewLieu.getText(), NewTitre.getText(),Integer.parseInt(NewNbrelpaces.getText()),Integer.parseInt(Nbreparticipants.getText()), NewDatedebut.getValue(), NewDatefin.getValue(), NewImage.getText()));
        JOptionPane.showMessageDialog(null, "Evenement ajoutée !");
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    
}
