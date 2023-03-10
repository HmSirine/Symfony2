/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Utilisateur;
import services.CrudUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import utils.DataSource;
import java.sql.Statement;
import static java.util.Collections.list;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import utils.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.input.ContextMenuEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UtilisateursController implements Initializable {

//    @FXML
//    private Button btnAjouter;
//    @FXML
//    private Button Afficher;
//    @FXML
//    private Button Supprimer;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfMdp;

    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur, Integer> Id;
    @FXML
    private TableColumn<Utilisateur, String> Nom;
    @FXML
    private TableColumn<Utilisateur, String> Prenom;
    @FXML
    private TableColumn<Utilisateur, String> Adresse;
    @FXML
    private TableColumn<Utilisateur, String> MotDePasse;
    @FXML
    private Button menu;
    @FXML
    private TextField filterField;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnAfficheRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CrudUtilisateur cu = new CrudUtilisateur();
        List<Utilisateur> list = cu.afficher();
        Collections.sort(list, Comparator.comparing(Utilisateur::getNom));

        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MotDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));

        ObservableList<Utilisateur> observableList = FXCollections.observableList(list);
        table.setItems(observableList);

        UpdateTable();
        search_user();
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

    @FXML
    private void ajoutUser(ActionEvent event) {

        CrudUtilisateur cu = new CrudUtilisateur();

        cu.Ajouter(new Utilisateur(tfNom.getText(), tfPrenom.getText(), tfAdresse.getText(), tfMdp.getText()));
        try {
            JOptionPane.showMessageDialog(null, "Utilisateur ajoutée !");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UpdateTable() {
        CrudUtilisateur cu = new CrudUtilisateur();
        ObservableList<Utilisateur> list = FXCollections.observableList(cu.afficher());
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MotDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        table.setItems(list);

    }

    @FXML
    void search_user() {
        CrudUtilisateur cu = new CrudUtilisateur();
        ObservableList<Utilisateur> list = FXCollections.observableList(cu.afficher());
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MotDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        table.setItems(list);
        FilteredList<Utilisateur> filteredData = new FilteredList<>(list, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                } else if (person.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                } else if (person.getAdresse().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                } else if (String.valueOf(person.getMdp()).indexOf(lowerCaseFilter) != -1) {
                    return true;// Filter matches email
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    private void afficher(ActionEvent event) {
        CrudUtilisateur cu = new CrudUtilisateur();
        List<Utilisateur> userList = cu.afficher();
        Collections.sort(userList, Comparator.comparing(Utilisateur::getNom));

        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MotDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));

        ObservableList<Utilisateur> observableList = FXCollections.observableList(userList);
        table.setItems(observableList);

        UpdateTable();
        search_user();
    }

    //Select//
    int index = -1;

    @FXML
    void getSelected(MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        //tfId.setText(Id.getCellData(index).toString());
        tfNom.setText(Nom.getCellData(index).toString());
        tfPrenom.setText(Prenom.getCellData(index).toString());
        tfAdresse.setText(Adresse.getCellData(index).toString());
      //  tfMdp.setText(MotDePasse.getCellData(index).toString());

    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void AfficherRec(ActionEvent event) throws IOException {

        // Load the login.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecAdmin.fxml"));
        Parent root = loader.load();

        // Create a new stage for the login.fxml file
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current stage (the stage containing the "Mon compte" button)
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }


    
    
     @FXML
    public void Edit() {
        CrudUtilisateur cu = new CrudUtilisateur();
          String nom = tfNom.getText();
          String prenom = tfPrenom.getText();
          String adresse = tfAdresse.getText();
          
         //int id = Integer.parseInt(tfId.getText());
        
        Utilisateur u =  (Utilisateur) table.getSelectionModel().getSelectedItem();
        
        u.setNom(tfNom.getText());
        u.setPrenom(tfPrenom.getText());
        u.setAdresse(tfAdresse.getText());
        u.setId(u.getId());
        
         try {
            JOptionPane.showMessageDialog(null, "Utilisateur modifié !");
            System.out.println(u.getId());
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        cu.modifier(u);
        cu.afficher();
         UpdateTable();
        search_user();
        
    }
    

    @FXML
    public void Delete() {
        CrudUtilisateur cu = new CrudUtilisateur();
  Utilisateur u =  (Utilisateur) table.getSelectionModel().getSelectedItem();
        
        cu.supprimer(u);
        try {
            JOptionPane.showMessageDialog(null, "Utilisateur supprimeé !");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void ajoutUser(ContextMenuEvent event) {
    }

}
