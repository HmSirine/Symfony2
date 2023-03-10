/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.Reclamation;
import com.travolta.services.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class AjoutReclamationController implements Initializable {

    @FXML
    private TextField NewDescription;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bAjouter;
    @FXML
    private Button menu;
    @FXML
    private TextField NewMail;
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, String> mail;
    @FXML
    private TableColumn<Reclamation, String> description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  ActionEvent event = null;
        afficherReclamation((ActionEvent) event);
    }    

    @FXML
    private void afficherReclamation(ActionEvent event) {
        ServiceReclamation se = new ServiceReclamation();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Reclamation> list = FXCollections.observableList(se.afficher());
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        // Créez une liste observable à partir de vos données


// Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Reclamation> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Reclamation e1, Reclamation e2) -> e1.getMail().compareTo(e2.getMail()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);

        //table.setItems(list);
    }

    @FXML
    private void AjoutReclamation(ActionEvent event) {
        ServiceReclamation se = new ServiceReclamation();

        se.ajouter(new Reclamation(1,1,NewDescription.getText(), NewMail.getText()));

          JOptionPane.showMessageDialog(null, "reclamation ajoutée !");
          // Recipient's email address
        String to = "aghx01@gmail.com";
        
        // Sender's email address
        String from = "gharbi.ahmed@esprit.tn";
        
        // Sender's email password
        String password = "tiiwrimalibcyvjc";
        
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
        
        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            
            // Set the recipient, sender, subject, and content of the message
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Reponse à votre reclamation");
            message.setText("test test.");
            
            // Send the email
            Transport.send(message);
            
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReclamationInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }


    @FXML
    private void getSelected(MouseEvent event) {
    }
    
}
