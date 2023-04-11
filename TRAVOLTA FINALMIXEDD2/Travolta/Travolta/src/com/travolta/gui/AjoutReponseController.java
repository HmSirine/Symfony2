/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.ReponseReclamation;
import com.travolta.services.ServiceReponseReclamation;
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
import javafx.scene.control.Button;
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
public class AjoutReponseController implements Initializable {

    @FXML
    private TextField Newreponse;
    @FXML
    private Button menu;
    @FXML
    private Button bAjouter;
    @FXML
    private TableView<ReponseReclamation> table;
    @FXML
    private TableColumn<ReponseReclamation, String> reponse;
    @FXML
    private Button bAfficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ActionEvent event = null;
        afficherReponse((ActionEvent) event);  
    }    

    @FXML
    private void menu(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void ajouterReponse(ActionEvent event) {
         ServiceReponseReclamation sc = new ServiceReponseReclamation();

         sc.ajouter(new ReponseReclamation(Newreponse.getText() ));
          JOptionPane.showMessageDialog(null, "Reponse ajoutée !");
    }

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void afficherReponse(ActionEvent event) {
         ServiceReponseReclamation sre = new ServiceReponseReclamation();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<ReponseReclamation> list = FXCollections.observableList(sre.afficher());
        reponse.setCellValueFactory(new PropertyValueFactory<>("reponse"));
        
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<ReponseReclamation> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((ReponseReclamation e1, ReponseReclamation e2) -> e1.getReponse().compareTo(e2.getReponse()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }
    
}
