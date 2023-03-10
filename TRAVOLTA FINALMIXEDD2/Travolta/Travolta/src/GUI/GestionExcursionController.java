/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import static GUI.GestionReservationController.idReservation;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Activite;
import models.Excursion;
import models.ReservationExcursion;
import services.ActiviteService;
import services.ExcursionService;
import services.PDFGenerator;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GestionExcursionController implements Initializable {

    @FXML
    private TableView<Excursion> table_reservation;
   
    @FXML
    private TableColumn<Excursion, String> col_id_excursion;
    @FXML
    private TableColumn<Excursion, String>col_type_excursion;
   
    @FXML
    private Button ButtonAjouterExcursion;
    @FXML
    private Button ButtonSupprimerExcursion;
    @FXML
    private Button ButtonModifierExcursion;
    @FXML
    private Button ButtonGestionReservation;
    @FXML
    private Button ButtonGestionActivite;
        @FXML
   
    private Button btnPDF;

    @FXML
    private TableColumn<Excursion, String> col_nbrpersonnes;
    @FXML
    private TableColumn<Excursion, String> col_prrix;
    @FXML
    private Button ButtonImprimerActivite2;
    @FXML
    private Button ButtonImprimerActivite21;
    @FXML
    private Button ButtonImprimerActivite211;
    @FXML
    private Button ButtonImprimerActivite22;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherExcursions();
        // TODO
    }    

   

    @FXML
    private void ToAjouterExcursionPage(ActionEvent event) {
                ButtonAjouterExcursion.getScene().getWindow().hide();

        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterExcursionPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SupprimerExcursion(ActionEvent event) {
        if (idExcursion==0){
            
        }
        else{
        ExcursionService es=new ExcursionService();
        es.Supprimer(idExcursion);
        AfficherExcursions();
          
        }
        
    }

    @FXML
    private void ModifierExcursion(ActionEvent event) {
           ButtonAjouterExcursion.getScene().getWindow().hide();

        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifierExcursionPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ToGestionReservation(ActionEvent event) {
        ButtonAjouterExcursion.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AfficherExcursions(){
        ExcursionService es=new ExcursionService();
        col_id_excursion.setCellValueFactory(new PropertyValueFactory<>("IdExcursion"));
        col_type_excursion.setCellValueFactory(new PropertyValueFactory<>("TypeExcursion"));
        col_nbrpersonnes.setCellValueFactory(new PropertyValueFactory<>("NbPersonnes"));
        col_prrix.setCellValueFactory(new PropertyValueFactory<>("PrixUnitaire"));
                    table_reservation.setItems(es.Afficher());
                    

    }
     

    @FXML
    private void ToGestionActivite(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GestionActivite.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int idExcursion=0;
    @FXML
    private void getSelected(MouseEvent event) {
         Excursion r=table_reservation.getSelectionModel().getSelectedItem();
        int id=r.getIdExcursion();
        idExcursion=id;
    }

    
     @FXML
    void generatePDF2(ActionEvent event) {
        try {
            ArrayList<Excursion> activites = (ArrayList<Excursion>) new ExcursionService().Afficher2();
            PDFGenerator.generateExcursionPDF(activites);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF Generé");
            alert.setHeaderText(null);
            alert.setContentText("Le PDF des activites a été generé avec succès!");
            alert.showAndWait();
        } catch (FileNotFoundException | DocumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de la génération du PDF des activites: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void ImprimerActivite(ActionEvent event) {
    }

    
    
}
