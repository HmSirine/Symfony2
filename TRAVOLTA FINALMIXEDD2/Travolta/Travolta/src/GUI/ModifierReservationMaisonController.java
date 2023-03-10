/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.ReservationChambreHotel;
import models.ReservationMaison;
import services.ServiceReservationMaison;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Properties;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class ModifierReservationMaisonController implements Initializable {

    @FXML
    private Button ModifierReservation;
    @FXML
    private Button AfficherReservation;
  
    @FXML
    private Button Retour;
    @FXML
    private TableView<ReservationMaison> table;
    @FXML
    private DatePicker date_arrivee1;
    @FXML
    private DatePicker date_depart1;
    private TableColumn<ReservationMaison, Float> tarif1;
    @FXML
    private TextField email1;
    private TextField client1;
    @FXML
    private TableColumn<ReservationMaison, LocalDate> date_arrivee2;
    @FXML
    private TableColumn<ReservationMaison, LocalDate> date_depart2;
    @FXML
    private TableColumn<ReservationMaison, Float> traif212;
    @FXML
    private TableColumn<ReservationMaison, String> nom12;
    @FXML
    private TableColumn<ReservationMaison, String> prenom2;
    @FXML
    private TableColumn<ReservationMaison, String> email2;
    @FXML
    private TextField nom1;
    private TextField maison;
    @FXML
    private TextField prenom1;
    @FXML
    private TextField prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ActionEvent event = null;
        
          
         AfficherReservation(event);
    }    

    @FXML
    private void modifierReservation(ActionEvent event) throws AddressException, MessagingException {
                      ServiceReservationMaison srm = new ServiceReservationMaison ();

        LocalDate date =  date_arrivee1.getValue();
                if (date.toString().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
         // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\war.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
            alert.showAndWait();
        } else { String mail = email1.getText(); 
             if ( nom1.getText().equals("")|| prenom1.getText().equals("")|| email1.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
       
        }  
                 
    
              else if (nom1.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+") || prenom1.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" doit pas contenir un symbole ");
            a.setHeaderText(null);
            a.showAndWait();
             if (mail.charAt(0) != '@' && mail.contains("@") && mail.endsWith(".com") || mail.endsWith(".tn") || mail.endsWith(".fr")) {
                  Alert b = new Alert(Alert.AlertType.WARNING);
            b.setContentText("Please enter a valide email");
             }
           
              }
        ReservationMaison m =  (ReservationMaison) table.getSelectionModel().getSelectedItem();
   m.setDate_arrivee(date_arrivee1.getValue());
        m.setDate_depart(date_depart1.getValue());
        m.setNom(nom1.getText());
        m.setPrenom(prenom1.getText());
        m.setEmail(email1.getText());
        m.setTarif(Float.valueOf(prix.getText()));
       // m.setUser_id(Integer.valueOf(client1.getText()));
       // m.setId_maison(Integer.valueOf(maison.getText()));
        
    JOptionPane.showMessageDialog(null, "Reservation modifiee !");
        
        srm.modifier(m);
        srm.afficher();
        
      // Recipient's email address
        String to = mail;
        
        // Sender's email address
        String from = "ghassen.chamakh@esprit.tn";
        
        // Sender's email password
        String password = "rnoekfxhjylfkilx";
        
        // Setup properties for the SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        // Authenticate the sender's email account
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        // Create a new email session
        Session session = Session.getInstance(props, auth);
        
        // Create a new email message
        Message message = new MimeMessage(session);
        // Set the recipient, sender, subject, and content of the message
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Resevation Maison Modifier");
        message.setText("Madame, Monsieur,\n" +"\n" +"Je fais suite par la présente à votre courrier . J'ai pris note des conditions de la location et du descriptif du logement. Aussi, je vous confirme mon intention de louer votre logement situé  pour nouveau periode la période du "+ date_arrivee1.getValue() +" au" +date_depart1.getValue()+", pour le prix de" +Float.valueOf(prix.getText()) +" Dinars");
        // Send the email
        Transport.send(message);
        System.out.println("Email envoyé avec succes.");
    

    }
    }

    @FXML
    private void AfficherReservation(ActionEvent event) {
            ServiceReservationMaison srm = new ServiceReservationMaison ();
        ObservableList<ReservationMaison> list = FXCollections.observableList(srm.afficher());
        date_arrivee2.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        date_depart2.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
       traif212.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        nom12.setCellValueFactory(new PropertyValueFactory<>("nom"));
       prenom2.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       email2.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        table.setItems(list);
         //table.setItems(list);
                    // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<ReservationMaison> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((ReservationMaison rh1, ReservationMaison rh22) -> rh1.getNom().compareTo(rh22.getNom()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationMaison.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    

    @FXML
    private void selectEvent(MouseEvent event) {
    }
    
}
