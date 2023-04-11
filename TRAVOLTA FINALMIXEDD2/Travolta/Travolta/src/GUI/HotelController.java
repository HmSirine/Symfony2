/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Hotel;
import models.ReservationChambreHotel;
import services.ServiceHotel;
import services.ServiceReservationChambreHotel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class HotelController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private Button Afficher;
    @FXML
    private Button Ajouter;
    @FXML
    private TextField description;
    @FXML
    private ComboBox<Integer> etoile;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Hotel> table;
    private TableColumn<Hotel,String > prixC1;
    private TableColumn<Hotel, String> dateC111;
    private TableColumn<Hotel, String> dateC2;
    private TableColumn<Hotel, Integer> dateC1;
    @FXML
    private TextField adresse;
    @FXML
    private Button Retour;
    @FXML
    private TableColumn<Hotel, String> tit;
    @FXML
    private TableColumn<Hotel, String> desc;
    @FXML
    private TableColumn<Hotel, String> add;
    @FXML
    private TableColumn<Hotel, String> etoi;
    private TableColumn<Hotel, BufferedImage> img;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bchercher;
        String images ;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Integer []item = {2,3,4,5};
          etoile.getItems().addAll(item);
          etoile.setOnAction(event->{String data= etoile.getSelectionModel().getSelectedItem().toString();});
       ActionEvent event = null;
        
          
         afficherHotel(event);
    }    

    @FXML
    private void afficherHotel(ActionEvent event) {
         ServiceHotel se = new ServiceHotel();
        ObservableList<Hotel> list = FXCollections.observableList(se.afficher());
       tit.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        add.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        etoi.setCellValueFactory(new PropertyValueFactory<>("etoile"));
        //img.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Hotel> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Hotel e1, Hotel e2) -> e1.getTitre().compareTo(e2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    

    @FXML
    private void ajouterHotel(ActionEvent event) throws IOException {
        ServiceHotel se = new ServiceHotel();
       String tit = titre.getText();
       String desc = description.getText();
       String add = adresse.getText();
           int etoiles =etoile.getSelectionModel().getSelectedItem();

    //int etoil = Integer.parseInt(etoile.getText());
   
    // Créer un objet Chambre avec les valeurs récupérées
    Hotel hotel = new Hotel( tit ,desc, add, etoiles);
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        // Convertir le fichier en tableau d'octets et l'affecter à l'attribut image
    byte[] imageBytes = Files.readAllBytes(file.toPath());
        
    hotel.setImage(imageBytes);
    }
    se.ajouter(hotel);
 

    // Afficher un message de confirmation
    JOptionPane.showMessageDialog(null, "Hotel ajoutée !");



        
    }

    @FXML
    private void modifierHotel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierHotel.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) modifier.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    

    @FXML
    private void supprimerHotel(ActionEvent event) {
         ServiceHotel se = new ServiceHotel();
        Hotel h = table.getSelectionModel().getSelectedItem();
        

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// alert de confirmation suppression
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER le Hotel ?");
         // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\good.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(h);

            JOptionPane.showMessageDialog(null, " Hotel supprimer ");
        } else {
            JOptionPane.showMessageDialog(null, " Hotel non supprimer ");
        }
        se.afficher();
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
      
         ServiceHotel se = new ServiceHotel();
        ObservableList<Hotel> list = FXCollections.observableList(se.afficher());
       tit.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        add.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        etoi.setCellValueFactory(new PropertyValueFactory<>("etoile"));
        //image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        
SortedList<Hotel> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Hotel e1, Hotel e2) -> e1.getTitre().compareTo(e2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
        se.afficher();
      

        FilteredList<Hotel> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Hotel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void getSelect(MouseEvent event) {
    }

    private void ajoutImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    // définir les filtres pour n'afficher que les fichiers image
    fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
    );
        // ouvrir la boîte de dialogue de sélection de fichier
        File imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
         
        
    }
}
    
    
    
    

