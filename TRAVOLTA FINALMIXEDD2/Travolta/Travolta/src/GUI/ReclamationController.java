/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Reclamation;
import services.CrudReclamation;
import services.SendMail;
import static java.awt.SystemColor.menu;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField tfObjet;
    @FXML
    private TextField tfMessage;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
     @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MonCompte.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    private boolean validateFields() {
        boolean isValid = true;

        // Vérification du champ nom
        if (tfObjet.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre objet");
            alert.showAndWait();
            isValid = false;
        }

        // Vérification du champ prénom
        if (tfMessage.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre message");
            alert.showAndWait();
            isValid = false;
        }

        return isValid;
    }

    @FXML
    private void AjouterReclamation(ActionEvent event) throws IOException, MessagingException {
        if (validateFields()) {
            String objet = tfObjet.getText();
            String message = tfMessage.getText();

            Reclamation reclamation = new Reclamation(objet, message);

            CrudReclamation cr = new CrudReclamation();

            if (cr.reclamationExists(reclamation)) {
                // La réclamation existe déjà, afficher un message d'erreur ou une notification
                System.out.println("Cette réclamation existe déjà !");
            } else {
                // La réclamation n'existe pas, l'ajouter à la base de données
                cr.Ajouter(reclamation);
                System.out.println("Réclamation ajoutée !");

                // Get the email address of the administrator
                String adminEmailAddress = "travolta.voyage@gmail.com";

                try {
                    // Send notification to the administrator
                    SendMail.sendReclamationNotification(adminEmailAddress, reclamation);
                } catch (MessagingException e) {
                    System.out.println("Erreur lors de l'envoi de la notification à l'administrateur : " + e.getMessage());
                }

                // Notify the user that their reclamation has been submitted
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Réclamation envoyée");
                alert.setHeaderText("Votre réclamation a été soumise avec succès.");
                alert.setContentText("Nous avons reçu votre réclamation et nous y répondrons dès que possible.");

                alert.showAndWait();

                // Load the AfficheRec.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheRec.fxml"));
                Parent root = loader.load();

                // Create a new stage for the AfficheRec.fxml file
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Close the current stage (the stage containing the "Mon compte" button)
                ((Node) (event.getSource())).getScene().getWindow().hide();

                AfficheRecController dpc = loader.getController();
                dpc.setLbObjet(tfObjet.getText());
                dpc.setLbMessage(tfMessage.getText());
            }
        }
    }

    @FXML
    private void menu(MouseEvent event) {
    }
}
