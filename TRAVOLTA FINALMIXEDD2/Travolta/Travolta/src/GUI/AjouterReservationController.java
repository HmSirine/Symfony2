/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.ReservationChambreHotel;
import services.ServiceChambre;
import services.ServiceReservationChambreHotel;
import tests.SendTest;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class AjouterReservationController implements Initializable {

    private Button menu;
    @FXML
    private TableView<ReservationChambreHotel> table;
    @FXML
    private Button AfficherReservation;
    @FXML
    private Button AjouterReservation;
    @FXML
    private TextField tarif;
    private TextField client;
    private TextField chambre;
    @FXML
    private DatePicker date_depart;
    @FXML
    private DatePicker date_arrivee;
    @FXML
    private Button Retour;
    @FXML
    private TableColumn<ReservationChambreHotel, LocalDate> date_arrivee2;
    @FXML
    private TableColumn<ReservationChambreHotel, LocalDate> date_depart2;
    @FXML
    private TableColumn<ReservationChambreHotel, Float> traif2;
    @FXML
    private TextField email;
    @FXML
    private TextField nom;
    @FXML
    private TextField nombre_chambre;
    @FXML
    private TextField prenom;
    @FXML
    private TableColumn<ReservationChambreHotel, String> nom1;
    @FXML
    private TableColumn<ReservationChambreHotel, String> prenom1;
    @FXML
    private TableColumn<ReservationChambreHotel, String> email1;
    @FXML
    private TableColumn<ReservationChambreHotel, Integer> nbchambre;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
        
          
        afficherReservation(event);
    }    

    @FXML
    private void afficherReservation(ActionEvent event) {
                 ServiceReservationChambreHotel srch = new ServiceReservationChambreHotel();
        ObservableList<ReservationChambreHotel> list = FXCollections.observableList(srch.afficher());
       date_arrivee2.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        date_depart2.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
       traif2.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
       prenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nbchambre.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
       email1.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        table.setItems(list);
         //table.setItems(list);
                    // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<ReservationChambreHotel> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((ReservationChambreHotel rh1, ReservationChambreHotel rh22) -> rh1.getNom().compareTo(rh22.getNom()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }
    
       

    @FXML
    private void AjouterReservation(ActionEvent event) throws IOException {
        SendTest Sms= new SendTest();
                 ServiceReservationChambreHotel srch = new ServiceReservationChambreHotel();
                  String mail = email.getText();  
                 if ( nom.getText().equals("")|| prenom.getText().equals("")|| email.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
       
        }  
                 
    
              else if (nom.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+") || prenom.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
              ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" doit pas contenir un symbole ");
            a.setHeaderText(null);
            a.showAndWait();
             if (mail.charAt(0) != '@' && mail.contains("@") && mail.endsWith(".com") || mail.endsWith(".tn") || mail.endsWith(".fr")) {
                  Alert b = new Alert(Alert.AlertType.WARNING);
            b.setContentText("Please enter a valide email");
             }
           
              }
              else{
            
LocalDate sqldate_arrivee = date_arrivee.getValue();
LocalDate sqldate_depart = date_depart.getValue();
int chb = Integer.parseInt(nombre_chambre.getText());
 String noms = nom.getText();
  String prenoms = prenom.getText();
  
    int tariif = Integer.parseInt(tarif.getText());
   // int chbr = Integer.parseInt(chambre.getText());
   int chbr=23;
//int id = Integer.parseInt(client.getText());
int id=2;
     ReservationChambreHotel res = new ReservationChambreHotel( sqldate_arrivee ,sqldate_depart, chb, noms, prenoms, mail, tariif, chbr ,id);
                      ServiceReservationChambreHotel service = new ServiceReservationChambreHotel();

    service.ajouter(res);
  //  Sms.SendSMS();
 
          JOptionPane.showMessageDialog(null, "Reservation ajoutee !");
          service.afficher();
    }
    }
   private void menu(ActionEvent event) throws IOException {
         
    }

    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReservation.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    
}
