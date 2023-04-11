/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.ReservationExcursion;
import services.ExcursionService;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GestionReservationController implements Initializable {

    @FXML
    private TableView<ReservationExcursion> table_reservation;
    @FXML
    private Button ButtonAjouterReservation;
    @FXML
    private Button ButtonSupprimerReservation;
    @FXML
    private Button ButtonModifierReservation;
    @FXML
    private Button ButtonGestionExcursion;
    @FXML
    private Button ButtonImprimerReservation;
    @FXML
    private Button ButtonGestionActivite;
    @FXML
    private TableColumn<ReservationExcursion, String>col_id;
    @FXML
    private TableColumn<ReservationExcursion, String> col_idClient;
    @FXML
    private TableColumn<ReservationExcursion, String>col_dateRes;
    @FXML
    private TableColumn<ReservationExcursion, String> col_prixTot;
    @FXML
    private Button ButtonImprimerActivite21;
    @FXML
    private Button messi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherReservations();
        // TODO 
    }    
    public static int idReservation=0;

    

    @FXML
    private void ToAjouterReservationPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterReservationPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AfficherReservations(){
        
        ReservationService rs=new ReservationService();
        col_id.setCellValueFactory(new PropertyValueFactory<>("IdReservation"));
        col_idClient.setCellValueFactory(new PropertyValueFactory<>("IdClient"));
        col_dateRes.setCellValueFactory(new PropertyValueFactory<>("DateReservation"));
        col_prixTot.setCellValueFactory(new PropertyValueFactory<>("PrixTotal"));
                    table_reservation.setItems(rs.Afficher());
                    

    }

    @FXML
    private void SupprimerReservation(ActionEvent event) {
        if(idReservation==0){
            
        }
        else{
                    ReservationService rs=new ReservationService();
                    rs.Supprimer(idReservation);
                    AfficherReservations();

            
        }
    }

    @FXML
    private void ModifierReservation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifierReservationPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ImprimerReservation(ActionEvent event) {
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
            Logger.getLogger(GestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    private void RetourFirstPage(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
       
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
             } catch (IOException ex) {
            Logger.getLogger(GestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void getSelected(MouseEvent event) {
        ReservationExcursion r=table_reservation.getSelectionModel().getSelectedItem();
        int id=r.getIdReservation();
        idReservation=id;
    }

    @FXML
    private void ImprimerActivite(ActionEvent event) {
    }

    @FXML
    private void ToAdminPage(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
    
}
