/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Chambre;
import models.Hotel;
import services.ServiceChambre;
import services.ServiceHotel;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class ModifierChambreController implements Initializable {

    @FXML
    private TextField description;
    @FXML
    private ComboBox<Integer> nblit;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private ComboBox<String> status;
    @FXML
    private TextField prix;
    @FXML
    private Button afficher;
    @FXML
    private Button modifier;
    @FXML
    private TableView<Chambre> table3;
    @FXML
    private TableColumn<Chambre, Integer> c1;
    @FXML
    private TableColumn<Chambre, Integer> c2;
    @FXML
    private TableColumn<Chambre, String> c3;
    @FXML
    private TableColumn<Chambre, String> c4;
    @FXML
    private TableColumn<Chambre, String> c5;
    @FXML
  //  private TableColumn<Chambre, ?> c7;
    //@FXML
    private TableColumn<Chambre, Float> c8;
    @FXML
    private Button Retour;
    @FXML
    private TextField nombre_chambre;

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
    private void afficherChambre(ActionEvent event) {
         ServiceChambre sc = new ServiceChambre();
        ObservableList<Chambre> list = FXCollections.observableList(sc.afficher());
        c1.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
        c2.setCellValueFactory(new PropertyValueFactory<>("nb_lit"));
        c3.setCellValueFactory(new PropertyValueFactory<>("description"));
        c4.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        c5.setCellValueFactory(new PropertyValueFactory<>("status_hebergement"));
        //c6.setCellValueFactory(new PropertyValueFactory<>("id_hotel"));
        //c7.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        c8.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
       // table3.setItems(list);
       // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Chambre> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
sortedList.setComparator((Chambre c1, Chambre c2) -> Integer.compare(c1.getNombre_chambre(), c1.getNombre_chambre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table3.setItems(sortedList);
    }

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceChambre.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void modifierChambre(ActionEvent event) {
          ServiceChambre sc = new ServiceChambre();

    String lieu = description.getText();
    if (lieu.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez vérifier vos informations");
        // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\war.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        alert.showAndWait();
    } else {
        String desc = description.getText();
        Chambre c =  table3.getSelectionModel().getSelectedItem();
             String cat =categorie.getSelectionModel().getSelectedItem().toString();
                 String stat =status.getSelectionModel().getSelectedItem().toString();
    int nblitt =nblit.getSelectionModel().getSelectedItem();


        c.setNombre_chambre(Integer.valueOf(nombre_chambre.getText()));
        c.setNb_lit(nblitt);
        c.setDescription(desc); 
        c.setCategorie(cat);
        c.setStatus_hebergement(stat);
        JOptionPane.showMessageDialog(null, "Chambre modifiee !");
        sc.modifier(c);
        sc.afficher();  
    }
    }
}
         
    
    
   
    
