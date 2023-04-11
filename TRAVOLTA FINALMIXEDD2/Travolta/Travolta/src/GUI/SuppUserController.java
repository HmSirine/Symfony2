/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Utilisateur;
import services.CrudUtilisateur;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SuppUserController implements Initializable {

    @FXML
    private TextField tfAdresse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travolta", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
 
         @FXML
    private void supprimer(ActionEvent event) throws Exception {
        CrudUtilisateur cu = new CrudUtilisateur();
        cu.supprimer(new Utilisateur(tfAdresse.getText()));
        JOptionPane.showMessageDialog(null, "UTILISATEUR  SUPPRIME !");
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
    
    
}
