/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import utils.DataSource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.Activite;
import services.ActiviteService;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjouterActivitePageController implements Initializable {
    private File imageFile;


    @FXML
    private TextField NomActiviteLabel;
    @FXML
    private Label PrixTotal;
    @FXML
    private TextField EmplacementImageLabel;
    @FXML
    private Label PrixTotal2;
    @FXML
    private Label PrixTotal1;
    @FXML
    private Button AnnulerAjoutActiviteManually;
    @FXML
    private Button ButtonAjouterActiviteButton;
    @FXML
    private TextField PrixActiviteField;
    @FXML
    private TextField TypeActiviteField;
    @FXML
    private Label error_act;
    @FXML
    private Button ImageActiviteButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ToGestionActivite(ActionEvent event) {
        try {
            NomActiviteLabel.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("GestionActivite.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterActivitePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    @FXML
    private void AjouterActiviteManually(ActionEvent event) throws IOException {
         if (NomActiviteLabel.getText().isEmpty()||PrixActiviteField.getText().isEmpty()||TypeActiviteField.getText().isEmpty()){
            error_act.setVisible(true);
        }
         else{
        ActiviteService as=new ActiviteService();
        Activite a=new Activite(NomActiviteLabel.getText(),Float.parseFloat(PrixActiviteField.getText()),TypeActiviteField.getText());
        
        
        FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        // Convertir le fichier en tableau d'octets et l'affecter à l'attribut ImageActivite de l'objet a
        byte[] imageBytes = Files.readAllBytes(file.toPath());
        a.setImageActivite(imageBytes);
    }
        as.Ajouter(a);
// affecter les octets de l'image à l'attribut ImageActivite de l'objet a
        
        
         try {
            NomActiviteLabel.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("GestionActivite.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterActivitePageController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
    
    
    
    @FXML
    private void selectImage(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    // définir les filtres pour n'afficher que les fichiers image
    fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
    );
    // ouvrir la boîte de dialogue de sélection de fichier
    imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
}

    
}
