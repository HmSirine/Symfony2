/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Reclamation;

import services.CrudReclamation;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;

import java.util.Comparator;
import java.util.List;
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

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RecAdminController implements Initializable {

    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, Integer> Ref;
    @FXML
    private TableColumn<Reclamation, String> Objet;
    @FXML
    private TableColumn<Reclamation, String> Message;
    @FXML
    private Button menu;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CrudReclamation cr = new CrudReclamation();
        List<Reclamation> list = cr.afficher();
        Collections.sort(list, Comparator.comparing(Reclamation::getObjet));

        Ref.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("ref"));
        Objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
        Message.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("MSG"));

        ObservableList<Reclamation> observableList = FXCollections.observableList(list);
        table.setItems(observableList);

        UpdateTable();
        search_Rec();
    }
    
    private void afficher(ActionEvent event) {
        CrudReclamation cr = new CrudReclamation();
        List<Reclamation> list = cr.afficher();
        Collections.sort(list, Comparator.comparing(Reclamation::getObjet));

         Ref.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("ref"));
        Objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
        Message.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("MSG"));

        ObservableList<Reclamation> observableList = FXCollections.observableList(list);
        table.setItems(observableList);

        UpdateTable();
        search_Rec();
    }


    public Connection getConnection() {
        Connection cnx;
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/travolta", "root", "");
            return cnx;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public void UpdateTable() {
        CrudReclamation cr = new CrudReclamation();
        ObservableList<Reclamation> list = FXCollections.observableList(cr.afficher());
        Ref.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("ref"));
        Objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
        Message.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("MSG"));
        table.setItems(list);

    }

    void search_Rec() {
        CrudReclamation cr = new CrudReclamation();
        ObservableList<Reclamation> list = FXCollections.observableList(cr.afficher());
        Ref.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("ref"));
        Objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
        Message.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("MSG"));
        table.setItems(list);
        FilteredList<Reclamation> filteredData = new FilteredList<>(list, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getObjet().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches Objet

                } else if (person.getMSG().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches message
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Utilisateurs.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
}
