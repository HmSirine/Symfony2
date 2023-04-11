/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import static GUI.GestionExcursionController.idExcursion;
import utils.DataSource;
import com.itextpdf.text.DocumentException;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Activite;
import services.ActiviteService;
import services.ActiviteService;
import services.PDFGenerator;




/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GestionActiviteController implements Initializable {

    @FXML
    private TableView<Activite> table_reservation;
    @FXML
    private TableColumn<Activite, String> col_id;
    @FXML
    private Button ButtonAjouterActivite;
    @FXML
    private Button ButtonSupprimerActivite;
    @FXML
    private Button ButtonModifierActivite;
    @FXML
    private Button ButtonGestionExcursion;
    @FXML
    private Button ButtonImprimerActivite;
    @FXML
    private Button ButtonGestionReservation;
    @FXML
    private TableColumn<Activite, String>col_nomAct;
    @FXML
    private TableColumn<Activite, String>col_typeAct;
    @FXML
    private TableColumn<Activite, String> col_PrixAct;
    @FXML
    private Button btnPDF;
    @FXML
    private Label ActiviteSommeTotaleLabel;
    @FXML
    private Button ButtonImprimerActivite1;
    @FXML
    private Button ButtonImprimerActivite3;
    @FXML
    private Button ButtonImprimerActivite2;
    @FXML
    private Button ButtonImprimerActivite21;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        AfficherActivites();
        float somme = calculerSommeTotale();
        ActiviteSommeTotaleLabel.setText("Somme totale : " + somme);
        // TODO
    }    

     public float calculerSommeTotale() {
        float somme = 0.0f;
        String requete = "SELECT PrixActivite FROM activite";
        try (PreparedStatement pst = new DataSource().getCnx().prepareStatement(requete);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                float prix = rs.getFloat("PrixActivite");
                somme += prix;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return somme;
    }

    @FXML
    private void ToAjouterActivitePage(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterActivitePage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SupprimerActivite(ActionEvent event) {
        ActiviteService as=new ActiviteService();
        as.Supprimer(idActivite);
        AfficherActivites();
  }

    @FXML
    private void ModifierActivite(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifierActivitePage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionActiviteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ToGestionExcursion(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GestionExcursion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionActiviteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

     public void  AfficherActivites(){
        
         
        ActiviteService as=new ActiviteService();

        
        col_id.setCellValueFactory(new PropertyValueFactory<>("IdActivite"));
        col_nomAct.setCellValueFactory(new PropertyValueFactory<>("NomActivite"));
        col_typeAct.setCellValueFactory(new PropertyValueFactory<>("TypeActivite"));
        col_PrixAct.setCellValueFactory(new PropertyValueFactory<>("PrixActivite"));
        
        table_reservation.setItems(as.Afficher());
                

        
        
       
                    

    }
    

    @FXML
    private void ToGestionReservation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionActiviteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static int idActivite=0;
    @FXML
    private void getSelected(MouseEvent event) {
                    Activite r=table_reservation.getSelectionModel().getSelectedItem();
             int id=r.getIdActivite();
             idActivite=id;

    }
        
    
        
    

  @FXML
    void generatePDF(ActionEvent event) {
        try {
            ArrayList<Activite> activites = (ArrayList<Activite>) new ActiviteService().Afficher1();
            PDFGenerator.generateActivitePDF(activites);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("PDF Generé");
            alert.setHeaderText(null);
            alert.setContentText("Le PDF des activites a été generé avec succès!");
            alert.showAndWait();
        } catch (FileNotFoundException | DocumentException e) {
            Alert alert = new Alert(AlertType.ERROR);
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

    
    

   

