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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterUserController implements Initializable {
    
    
    private TextField tfNom;
    private TextField tfPrenom;
    private TextField tfAdresse;
    private TextField tfMdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void AjouterPersonne(ActionEvent event) throws IOException {
        CrudUtilisateur cu = new CrudUtilisateur();
       // String hashedPassword = PasswordHasher.hash(tfMdp.getText());
        cu.Ajouter(new Utilisateur(tfNom.getText(), tfPrenom.getText(), tfAdresse.getText(), tfMdp.getText()));
        JOptionPane.showMessageDialog(null, "Utilisateur ajoutée !");
        

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
