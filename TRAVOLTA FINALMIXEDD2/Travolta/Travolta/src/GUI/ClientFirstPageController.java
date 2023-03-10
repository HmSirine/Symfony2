package GUI;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Activite;
import services.ActiviteService;


public class ClientFirstPageController implements Initializable {

    @FXML
    private GridPane activitesGrid;
    @FXML
    private Label totalLabel;
    @FXML
    private CheckBox promoCheckBox;
    @FXML
    private Label promoLabel;
    @FXML
    private Label prixLabel;
    
    private static  double montant;

    private double  totalPrix = 0;
    @FXML
    private Button excursionButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Récupération de la liste des activités avec leurs images
        List<Activite> activites = new ActiviteService().AfficherAvecImage();

        // Initialisation des variables de positionnement dans la grille
        int row = 0;
        int col = 0;

        // Boucle sur la liste des activités
        for (Activite activite : activites) {
            // Création de la VBox qui contient la card de l'activité
            VBox activiteCard = new VBox();
            activiteCard.setAlignment(Pos.CENTER);
            activiteCard.setSpacing(10);
            activiteCard.setPrefWidth(200);
            activiteCard.setPrefHeight(300);
            activiteCard.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-border-radius: 10; -fx-padding: 10;");

            // Création de l'image avec l'image de l'activité
            ImageView activiteImage = new ImageView(new Image(new ByteArrayInputStream(activite.getImageActivite())));
            activiteImage.setFitHeight(150);
            activiteImage.setFitWidth(150);

            // Création du label avec le nom de l'activité
            Label activiteName = new Label(activite.getNomActivite());
            activiteName.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

            // Création du label avec le type de l'activité
            Label activiteType = new Label(activite.getTypeActivite());
            activiteType.setStyle("-fx-font-size: 14px;");

            // Création du label avec le prix de l'activité
            Label activitePrix = new Label(String.valueOf(activite.getPrixActivite()) + " DT");
            activitePrix.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

            // Création du CheckBox pour l'activité
            CheckBox activiteCheckBox = new CheckBox();
            activiteCheckBox.setText("Réserver");

            // Ajout de l'image, du nom, du type, du prix et du CheckBox dans la card
            activiteCard.getChildren().addAll(activiteImage, activiteName, activiteType, activitePrix, activiteCheckBox);
            // Ajout de la card dans un HBox pour centrer la card dans la cellule de la grille
            HBox centeredBox = new HBox(activiteCard);
               centeredBox.setAlignment(Pos.CENTER);
                 // Ajout du HBox dans la grille
        activitesGrid.add(centeredBox, col, row);

        // Incrémentation des variables de positionnement dans la grille
        col++;
        if (col == 3) {
            col = 0;
            row++;
        }

        // Ajout de l'événement de changement d'état du CheckBox
        activiteCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                totalPrix += activite.getPrixActivite();
            } else {
                totalPrix -= activite.getPrixActivite();
            }
            updatePrixLabel();
        });
    }

    // Ajout de l'événement de changement d'état du CheckBox de promotion
    promoCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
        updatePrixLabel();
    });

    // Initialisation de la valeur du label de promotion
    promoLabel.setText("-10% sur le total pour toute réservation de 3 activités ou plus.");

    // Mise à jour de la valeur du label de prix
    updatePrixLabel();
}

/**
 * Met à jour la valeur du label de prix en fonction du total et de la promotion.
 */
private void updatePrixLabel() {
    double prixTotal = totalPrix;
    montant=totalPrix;
    if (promoCheckBox.isSelected() && activitesGrid.getChildren().size() >= 3) {
        prixTotal = totalPrix * 0.9;
        montant=prixTotal;
    }
    prixLabel.setText(String.valueOf(prixTotal) + " DT" );
    totalLabel.setText(String.valueOf(totalPrix) + " DT");
}

    @FXML
    private void ToExcursionCategory(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExcursionCategory.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
}
               
            