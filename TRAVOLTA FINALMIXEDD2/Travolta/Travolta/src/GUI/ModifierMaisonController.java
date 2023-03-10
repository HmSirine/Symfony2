/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Hotel;
import models.Maison;
import services.ServiceHotel;
import services.ServiceMaison;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ModifierMaisonController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private TextField prix;
    @FXML
    private TextField adresse;
    private TextField image;
    private TextField nombre_chambre;
    @FXML
    private ComboBox<String> status;
    @FXML
    private Button Afficher;
    @FXML
    private Button modifier;
    @FXML
    private TableView<Maison> table3;
    @FXML
    private TableColumn<Maison, String> c1;
    @FXML
    private TableColumn<Maison, Float> c2;
    @FXML
    private TableColumn<Maison, String> c3;
    @FXML
    private TableColumn<Maison, String> c4;
    @FXML
    private TableColumn<Maison, String> c5;
    @FXML
    private TableColumn<Maison, Integer> c6;
    private TableColumn<Maison, BufferedImage> c7;
    @FXML
    private Button Retour;
    @FXML
    private ComboBox<Integer> chambre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[]items = {"Reservé ","Non reservé"};
          status.getItems().addAll(items);
          status.setOnAction(event->{String data= status.getSelectionModel().getSelectedItem().toString();});
         
          Integer []item = {1,2,3,4,5,6};
          chambre.getItems().addAll(item);
          chambre.setOnAction(event->{String data= chambre.getSelectionModel().getSelectedItem().toString();});
        ActionEvent event = null;
        
          
         afficherMison(event);
    }    

    @FXML
    private void afficherMison(ActionEvent event) {
             ServiceMaison sm = new ServiceMaison();
        ObservableList<Maison> list = FXCollections.observableList(sm.afficher());
        c1.setCellValueFactory(new PropertyValueFactory<>("titre"));
        c2.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c3.setCellValueFactory(new PropertyValueFactory<>("description"));
        c4.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        c5.setCellValueFactory(new PropertyValueFactory<>("status_hebergement"));
        c6.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
       // c7.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        
        //table3.setItems(list);
                // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Maison> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Maison m1, Maison m2) -> m1.getTitre().compareTo(m2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table3.setItems(sortedList);
    }

    @FXML
    private void modifierMaison(ActionEvent event) {
         ServiceMaison sh = new ServiceMaison();

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
        
        Maison m =  (Maison) table3.getSelectionModel().getSelectedItem();
                   String stat =status.getSelectionModel().getSelectedItem().toString();
                  int chambres =chambre.getSelectionModel().getSelectedItem();

        m.setTitre(tit);
        m.setPrix(Float.valueOf(prix.getText()));
        m.setDescription(description.getText());
        m.setAdresse(adresse.getText());
        m.setStatus_hebergement(stat);
        
        m.setChambre(chambres);
    
    
    
    JOptionPane.showMessageDialog(null, "chambre modifiee !");
        
        sh.modifier(m);
        sh.afficher();
         
    }
    }
    

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceMaison.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void getSelected(MouseEvent event) {
        int index = table3.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    titre.setText(c1.getCellData(index).toString());
    prix.setText(c2.getCellData(index).toString());
    description.setText(c3.getCellData(index).toString());
    adresse.setText(c4.getCellData(index).toString());

    
       
    }
    }
    

