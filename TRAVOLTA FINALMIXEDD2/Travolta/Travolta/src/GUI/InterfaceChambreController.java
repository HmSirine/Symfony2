/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Chambre;
import models.Hotel;
import  services.ServiceChambre;
import services.ServiceHotel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class InterfaceChambreController implements Initializable {
    private File imageFile;

    @FXML
    private TextField numero_chambre;
    @FXML
    private TextField description;
    @FXML
    private ComboBox<Integer> nblit;
    @FXML
    private ComboBox<String> categorie;
    private TextField hotel;
    @FXML
    private ComboBox<String> status;
    @FXML
    private TextField prix;
    @FXML
    private Button supprimer;
    @FXML
    private Button Ajouter;
    @FXML
    private Button modifier;
    @FXML
    private TableView<Chambre> table3;
    private TableColumn<Chambre,String> c1;
    private TableColumn<Chambre,String> c2;
    private TableColumn<Chambre,String> c3;
    private TableColumn<Chambre,String> c4;
    private TableColumn<Chambre,String> c5;
    private TableColumn<Chambre,String> c6;
    @FXML
    //private TableColumn<Chambre, String> c7;
    //@FXML
    private Button Retour;
    private TableColumn<Chambre, Float> c8;
    //@FXML
   // private TableColumn<?, ?> c7;
    @FXML
    private TableColumn<Chambre, Integer> c11;
    @FXML
    private TableColumn<Chambre, Integer> c21;
    @FXML
    private TableColumn<Chambre, String> c31;
    @FXML
    private TableColumn<Chambre, String> c41;
    @FXML
    private TableColumn<Chambre, String> c51;
    //@FXML
   // private TableColumn<Chambre, String> c71;
    @FXML
    private TableColumn<Chambre, Float> c81;
    private TableColumn<?, ?> c71;
    @FXML
    private Button bchercher;
    private TextField eChercher;
    @FXML
    private TextField eChercher1;
    @FXML
    private Button Afficher;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         String[]items = {"Reservé ","Non reservé"};
          status.getItems().addAll(items);
          status.setOnAction(event->{String data= status.getSelectionModel().getSelectedItem().toString();});
          String[]ites = {"VIP ","SINGLE","DOUBLE"};
          categorie.getItems().addAll(ites);
          categorie.setOnAction(event->{String data= categorie.getSelectionModel().getSelectedItem().toString();});
          Integer []item = {1,2, 3};
          nblit.getItems().addAll(item);
          nblit.setOnAction(event->{String data= nblit.getSelectionModel().getSelectedItem().toString();});
          ActionEvent event = null;
        
          
         afficherChambre(event);
    }    

    @FXML
    private void supprimerChambre(ActionEvent event) {
           ServiceChambre sc = new ServiceChambre();
        Chambre c = table3.getSelectionModel().getSelectedItem();
    
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// alert de confirmation suppression
        alert.setTitle("ALERT SUPPRESSION");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER LA CHAMBRE?");
        // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\good.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sc.supprimer(c);

            JOptionPane.showMessageDialog(null, " Chambre supprimer ");
        } else {
            JOptionPane.showMessageDialog(null, " Chambre non supprimer ");
        }
        sc.afficher();
    
    }

    @FXML
    private void ajouterChambre(ActionEvent event) throws IOException {
         ServiceChambre sc = new ServiceChambre();
    int numeroChambre = Integer.parseInt(numero_chambre.getText());
      String desc = description.getText();
    //int nbLit = Integer.parseInt(nblit.getText());
    int nblitt =nblit.getSelectionModel().getSelectedItem();
//    String cat = categorie.getText();
        String cat =categorie.getSelectionModel().getSelectedItem().toString();

    float px = Float.parseFloat(prix.getText());
    //String stat = status.getText();
    String stat =status.getSelectionModel().getSelectedItem().toString();
    

    int idHotel = 21;

    // Créer un objet Chambre avec les valeurs récupérées

    Chambre chambre = new Chambre( numeroChambre ,desc, nblitt, cat, px, stat, idHotel);
   FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        // Convertir le fichier en tableau d'octets et l'affecter à l'attribut ImageActivite de l'objet a
    byte[] imageBytes = Files.readAllBytes(file.toPath());
        
    chambre.setImage(imageBytes);
    }
        sc.ajouter(chambre);

    // Afficher un message de confirmation
    JOptionPane.showMessageDialog(null, "Chambre ajoutée !");
    
    
    }


    @FXML
    private void afficherChambre(ActionEvent event) {
          ServiceChambre sc = new ServiceChambre();
        ObservableList<Chambre> list = FXCollections.observableList(sc.afficher());
        c11.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
        c21.setCellValueFactory(new PropertyValueFactory<>("nb_lit"));
        c31.setCellValueFactory(new PropertyValueFactory<>("description"));
        c41.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        c51.setCellValueFactory(new PropertyValueFactory<>("status_hebergement"));
        
        //c7.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        c81.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        //table3.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Chambre> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
sortedList.setComparator((Chambre c1, Chambre c2) -> Integer.compare(c1.getNombre_chambre(), c1.getNombre_chambre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table3.setItems(sortedList);
    }

    @FXML
    private void modifierChambre(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierChambre.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) modifier.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Chercherevent(ActionEvent event) {
    ServiceChambre sc = new ServiceChambre();
        ObservableList<Chambre> list = FXCollections.observableList(sc.afficher());
        c11.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
        c21.setCellValueFactory(new PropertyValueFactory<>("nb_lit"));
        c31.setCellValueFactory(new PropertyValueFactory<>("description"));
        c41.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        c51.setCellValueFactory(new PropertyValueFactory<>("status_hebergement"));
        c71.setCellValueFactory(new PropertyValueFactory<>("image"));
        c81.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        table3.setItems(list);

        sc.afficher();
      table3.setItems(list);

        FilteredList<Chambre> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Chambre> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table3.comparatorProperty());
        table3.setItems(sortedData);
    }

    



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





    
    
    
    

    

