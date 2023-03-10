/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontFactory;
import com.travolta.entities.Reservation_Evenement;
import com.travolta.services.ServiceReservation_Evenement;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class ReservationInterfaceController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Reservation_Evenement> table;
    @FXML
    private TableColumn<Reservation_Evenement, String> nom;
    @FXML
    private TableColumn<Reservation_Evenement, String> prenom;
    @FXML
    private TableColumn<Reservation_Evenement, String> mail;
    @FXML
    private TableColumn<Reservation_Evenement, String> tel;
    @FXML
    private TableColumn<Reservation_Evenement, String> heure_arrivee;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bSupprimer;
    @FXML
    private Button menu;
    @FXML
    private Button bPdf;
    @FXML
    private Button bchercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ActionEvent event = null;
        afficherReservation((ActionEvent) event); // TODO
    }    


    @FXML
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void ajouterReservation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutReservation.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void afficherReservation(ActionEvent event) {
          ServiceReservation_Evenement sre = new ServiceReservation_Evenement();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Reservation_Evenement> list = FXCollections.observableList(sre.afficher());
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        heure_arrivee.setCellValueFactory(new PropertyValueFactory<>("heure_arriver"));
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Reservation_Evenement> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Reservation_Evenement e1, Reservation_Evenement e2) -> e1.getNom().compareTo(e2.getNom()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void modifierReservation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationUpdate.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void supprimerReservation(ActionEvent event) {
         ServiceReservation_Evenement sre = new ServiceReservation_Evenement();
        Reservation_Evenement r = table.getSelectionModel().getSelectedItem();
   

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER LA RESERVATION ?");
        // Jouer le son
            String soundFile = "C:\\xampp\\htdocs\\Travolta.events\\src\\com\\travolta\\utils\\son\\alert.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sre.supprimer(r);

            JOptionPane.showMessageDialog(null, " RESERVATION SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " RESERVATION NON SUPPRIME ");
        }
        sre.afficher();
        
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void getPdf(ActionEvent event) {
        {

        try {

            OutputStream file = new FileOutputStream(new File("C:\\Users\\DELL\\Desktop\\Activite PDF\\test22.pdf"));
          Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            ServiceReservation_Evenement sre = new ServiceReservation_Evenement();
            //get from table
            Reservation_Evenement pub = table.getSelectionModel().getSelectedItem();

          

            document.add(new Paragraph("************************Liste Des Reclamation ************************\n\n\n\n\n\n\n"));

            document.add(new Paragraph(" ___________________________________________________________________________\n"));
            document.add(new Paragraph(" Nom :  " + pub.getNom() + "  \n"));
            document.add(new Paragraph(" Prenom  :  " + pub.getPrenom() + "  \n"));
            document.add(new Paragraph(" Mail  :  " + pub.getMail() + "  \n"));
            document.add(new Paragraph(" Tel :  " + pub.getTel() + "  \n"));
            document.add(new Paragraph(" Heure arriver :  " + pub.getHeure_arriver() + "  \n"));

            //document.add(new Paragraph(" Date :  " + new Date().toString() + "\n"));

            document.add(new Paragraph(" ___________________________________________________________________________"));

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());

        }

    }
       
    
}

    @FXML
    private void Chercherevent(ActionEvent event) {
        ServiceReservation_Evenement rs = new ServiceReservation_Evenement();
        ObservableList<Reservation_Evenement> list = FXCollections.observableList(rs.afficher());
        ServiceReservation_Evenement e = new ServiceReservation_Evenement();
        //ObservableList<Categorie> list = FXCollections.observableList(sc.afficher());
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        heure_arrivee.setCellValueFactory(new PropertyValueFactory<>("heure_arriver"));
        table.setItems(list);

        rs.afficher();
      table.setItems(list);

        FilteredList<Reservation_Evenement> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Reservation_Evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
}
    
