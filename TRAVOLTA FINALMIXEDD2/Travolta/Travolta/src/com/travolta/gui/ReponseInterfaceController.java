/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import com.travolta.entities.ReponseReclamation;
import com.travolta.services.ServiceReponseReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
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
public class ReponseInterfaceController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private TableView<ReponseReclamation> table;
    @FXML
    private TableColumn<ReponseReclamation, String> reponse;
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
    private Button bchercher;
    @FXML
    private Button bSupprimer1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ActionEvent event = null;
        afficherReponse((ActionEvent) event);  
    }    

    @FXML
    private void ajouterReponse(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutReponse.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
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

    @FXML
    private void modifierReponse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseUpdate.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void SupprimerReponse(ActionEvent event) {
        ServiceReponseReclamation sre = new ServiceReponseReclamation();
        ReponseReclamation r = table.getSelectionModel().getSelectedItem();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        
        alert.setContentText(" VOULEZ VOUS SUPPRIMER cette categorie ?");
         
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sre.supprimer(r);

            JOptionPane.showMessageDialog(null, " Reponse SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " Reponse NON SUPPRIME ");
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
    private void Chercherevent(ActionEvent event) {
    }
//iyed.zidi@esprit.tn 181JMT1037
    @FXML
    private void mail(ActionEvent event)  {
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
}