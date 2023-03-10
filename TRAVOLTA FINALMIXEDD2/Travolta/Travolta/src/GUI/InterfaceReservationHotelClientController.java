/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Chambre;
import models.Hotel;
import services.ServiceChambre;
import services.ServiceHotel;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class InterfaceReservationHotelClientController implements Initializable {

    @FXML
    private GridPane activitesGrid;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO   // Récupération de la liste des activités avec leurs images
            List<Chambre> chambres = new ServiceChambre().AfficherAvecImage();
            
            // Initialisation des variables de positionnement dans la grille
            int row = 0;
            int col = 0;
            
            // Boucle sur la liste des activités
            for (Chambre chambre : chambres) {
                // Création de la VBox qui contient la card de l'activité
                VBox activiteCard = new VBox();
                activiteCard.setAlignment(Pos.CENTER);
                activiteCard.setSpacing(10);
                activiteCard.setPrefWidth(200);
                activiteCard.setPrefHeight(300);
                activiteCard.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-border-radius: 10; -fx-padding: 10;");
                
                // Création de l'image avec l'image de l'activité
                ImageView activiteImage = new ImageView(new Image(new ByteArrayInputStream(chambre.getImage())));
                activiteImage.setFitHeight(150);
                activiteImage.setFitWidth(150);
                
                // Création du label avec description chambre
                Label chambreName = new Label(chambre.getDescription());
                chambreName.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                
                // Création du label avec numero chambre
                Label NombreDeLit = new Label(" Chambre Numero  "+ String.valueOf(chambre.getNombre_chambre()) );
                NombreDeLit.setStyle("-fx-font-size: 14px;");
                  // Création du label avec le prix chambre
                Label categorie = new Label(chambre.getCategorie());
                categorie.setStyle("-fx-font-size: 14px;");
                // Création du label avec le prix  chambre
                Label activitePrix = new Label(String.valueOf(chambre.getPrix()) + " DT");
                activitePrix.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
                
//                // Création du CheckBox pour l'activité
//                CheckBox activiteCheckBox = new CheckBox();
//                activiteCheckBox.setText("Réserver");
                Button btn=new Button();
                btn.setText("Réserver");
   btn.setOnAction(event -> {
                    try {
                        // Get the current scene
                        Scene currentScene = btn.getScene();
                        
                        // Load the FXML file and create the root node of the other interface
                        Parent root = FXMLLoader.load(getClass().getResource("AjouterClientHotel.fxml"));
                        
                        // Set the root node of the current scene to the root node of the other interface
                        currentScene.setRoot(root);
                    } catch (IOException ex) {
                        Logger.getLogger(InterfaceReservationHotelClientController.class.getName()).log(Level.SEVERE, null, ex);
                    }
});    
                // Ajout de l'image, du nom, du type, du prix et du CheckBox dans la card
                activiteCard.getChildren().addAll(activiteImage, chambreName, NombreDeLit, activitePrix, btn);
                
                // Ajout de la card dans un HBox pour centrer la card dans la cellule de la grille
                HBox centeredBox = new HBox();
                centeredBox.setAlignment(Pos.CENTER);
                centeredBox.getChildren().add(activiteCard);
                
                // Ajout de l'HBox dans la cellule de la grille correspondante
                activitesGrid.add(centeredBox, col, row);
                activitesGrid.setMargin(centeredBox, new Insets(10));
                
                // Incrémentation des variables de positionnement
                col++;
                if (col == 3) { // ou 4 si on veut 4 colonnes par ligne
                    col = 0;
                    row++;
                }
            }   } catch (SQLException ex) {
            Logger.getLogger(InterfaceReservationHotelClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
}    

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    }
    
    

