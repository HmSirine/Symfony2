/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Hotel;
import services.ServiceHotel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField address;
    @FXML
    private TextField description;
    @FXML
    private ComboBox<Integer> etoile;
    private TextField image;
    @FXML
    private AnchorPane table;
    @FXML
    private Button afficher;
    @FXML
    private Button Retour;
    @FXML
    private TableView<Hotel> table1;
    @FXML
    private TableColumn<Hotel, String> titre1;
    @FXML
    private TableColumn<Hotel, String> description1;
    @FXML
    private TableColumn<Hotel, String> address1;
    @FXML
    private TableColumn<Hotel, Integer> etoile1;
    @FXML
    private Button modifier;
    private TableColumn<Hotel, BufferedImage> image1;
    //private TableColumn<Hotel, ?> image1;

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
    private void modifierHotel(ActionEvent event) throws IOException {
         ServiceHotel sh = new ServiceHotel();

        String tit = titre.getText();
        if (titre.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
          // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\war.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
            alert.showAndWait();
        } else {
        
        Hotel h =  (Hotel) table1.getSelectionModel().getSelectedItem();
                   int etoiles =etoile.getSelectionModel().getSelectedItem();

        h.setTitre(titre.getText());
        h.setDescription(description.getText());
        h.setAdresse(address.getText());
        h.setEtoile(etoiles);
      
    JOptionPane.showMessageDialog(null, "Hotel modifiee !");
        
        sh.modifier(h);
        sh.afficher();
         
    }
    }


    @FXML
    private void afficherHotel(ActionEvent event) {
            ServiceHotel sh = new ServiceHotel();
        ObservableList<Hotel> list = FXCollections.observableList(sh.afficher());
        titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
        description1.setCellValueFactory(new PropertyValueFactory<>("description"));
        address1.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        etoile1.setCellValueFactory(new PropertyValueFactory<>("etoile"));
        //image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        //table1.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Hotel> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Hotel e1, Hotel e2) -> e1.getTitre().compareTo(e2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table1.setItems(sortedList);
    }

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Hotel.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void getSeelect(MouseEvent event) {
            int index = table1.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    titre.setText(titre1.getCellData(index).toString());
 
    description.setText(description1.getCellData(index).toString());
   address.setText(address1.getCellData(index).toString());
    
   
    }
    
    
}
