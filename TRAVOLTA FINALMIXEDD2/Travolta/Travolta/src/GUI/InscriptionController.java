/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Utilisateur;
import services.CrudUtilisateur;
import services.PasswordHasher;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfMdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean validateFields() {
        boolean isValid = true;

        // Vérification du champ nom
        if (tfNom.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre nom");
            alert.showAndWait();
            isValid = false;
        }

        // Vérification du champ prénom
        if (tfPrenom.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre prénom");
            alert.showAndWait();
            isValid = false;
        }

        // Vérification du champ email
        if (tfAdresse.getText().isEmpty() || !tfAdresse.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une adresse email valide");
            alert.showAndWait();
            isValid = false;
        }

        // Vérification du champ mot de passe
        if (tfMdp.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre mot de passe");
            alert.showAndWait();
            isValid = false;
        }

        return isValid;
    }

    @FXML
    private void AjouterPersonne(ActionEvent event) throws IOException {
        if (validateFields()) {
            CrudUtilisateur cu = new CrudUtilisateur();
            cu.Ajouter(new Utilisateur(tfNom.getText(), tfPrenom.getText(), tfAdresse.getText(), PasswordHasher.hash(tfMdp.getText())));

            // Load the login.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
            Parent root = loader.load();

            // Create a new stage for the login.fxml file
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current stage (the stage containing the "Mon compte" button)
            ((Node) (event.getSource())).getScene().getWindow().hide();

        }
    }

    @FXML
    private void Cnnx(ActionEvent event) throws IOException {

        //ButtonCompte.getScene().getWindow().hide();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        //primaryStage.setTitle("Tfarhida!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
