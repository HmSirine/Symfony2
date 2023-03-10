/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Categorie;
import com.travolta.services.ServiceCategorie;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class CategorieUpdateController implements Initializable {

    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private TextField NewType;
    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, String> type;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              ActionEvent event = null;
        afficherEvent((ActionEvent) event);    // TODO
    }    

    @FXML
    private void afficherEvent(ActionEvent event) {
        ServiceCategorie sc = new ServiceCategorie();

        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
       // table.setItems(list);
       SortedList<Categorie> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Categorie e1, Categorie e2) -> e1.getType().compareTo(e2.getType()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        ServiceCategorie sc = new ServiceCategorie();

        String type = NewType.getText();
        if (NewType.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else {
        
        Categorie c =  (Categorie) table.getSelectionModel().getSelectedItem();
        
        c.setType(type);
        sc.modifier(c);
        sc.afficher();
         
    }
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

    @FXML
     private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    NewType.setText(type.getCellData(index).toString());
    
       
    }
}
