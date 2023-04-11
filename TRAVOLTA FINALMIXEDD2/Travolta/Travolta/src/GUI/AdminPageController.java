/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Utilisateur;
import services.CrudUtilisateur;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdminPageController implements Initializable {

    @FXML
    private Button btnlogout;
    @FXML
    private Label usernameLabel;
    @FXML
    private Button AdminEventRediriction;
    @FXML
    private Button dhakersirineadmin;
    @FXML
    private Button sirinetoghacenadmin;
    @FXML
    private Button evenement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AfficherUser(ActionEvent event) throws IOException {
        CrudUtilisateur cu = new CrudUtilisateur();

        // Load the login.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Utilisateurs.fxml"));
        Parent root = loader.load();

        // Create a new stage for the login.fxml file
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current stage (the stage containing the "Mon compte" button)
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }
    

    @FXML
    private void logOut(ActionEvent event) throws IOException {

        btnlogout.getScene().getWindow().hide();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        //primaryStage.setTitle("Tfarhida!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    public void initData(Utilisateur user) {
        usernameLabel.setText("Welcome, " + user.getNom());
        // do other initialization tasks
    }
    
    // other methods and fields

    @FXML
    private void toExcursionCategory(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionReservation.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void DhakerToSirineAdmin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipale.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SirineToGhacenAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipalAdmin.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void Eventcrud(ActionEvent event)  throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../com/travolta/gui/InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) evenement.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }


}
