/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;

import static com.itextpdf.text.SpecialSymbol.index;
import com.travolta.entities.Evenement;
import com.travolta.services.ServiceEvenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author aghx0
 */
public class EventUpdateController implements Initializable {

    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private TextField NewLieu;
    @FXML
    private TextField NewNbrelpaces;
    @FXML
    private TextField NewTitre;
    @FXML
    private TextField Nbreparticipants;
    @FXML
    private TextField NewImage;
    @FXML
    private DatePicker NewDatefin;
    @FXML
    private DatePicker NewDatedebut;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private TableColumn<Evenement, String> lieu;
    @FXML
    private TableColumn<Evenement, String> titre;
    @FXML
    private TableColumn<Evenement, Integer> nbreplaces;
    @FXML
    private TableColumn<Evenement, Integer> nbreparticipants;
    @FXML
    private TableColumn<Evenement, LocalDate> datedebut;
    @FXML
    private TableColumn<Evenement, LocalDate> datefin;
    @FXML
    private TableColumn<Evenement, String> image;
    @FXML
    private Button menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
ActionEvent event = new ActionEvent();
         afficherEvent(event);
         
        
         
//         table.setOnMouseClicked(new EventHandler<MouseEvent>(){
//
//            @Override
//            public void handle(MouseEvent event) {
//          
//                FXMLLoader Loader = new FXMLLoader();
//                Loader.setLocation(getClass().getResource("EventUpdate.fxml"));
//                
//                try {
//                    Loader.load();
//                } catch (IOException ex) {
//                 ex.printStackTrace();
//                    
//                   // Logger.getLogger(ModifierVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//              
//                Evenement ger =  (Evenement) table.getSelectionModel().getSelectedItem();
//                
//                EventUpdateController autorefil = Loader.getController();
//                autorefil.setNewLieu(table.getSelectionModel().getSelectedItem().getLieu());
//                autorefil.setNewNbrelpaces(table.getSelectionModel().getSelectedItem().getNbreplaces()+"");
//                autorefil.setNewTitre(table.getSelectionModel().getSelectedItem().getTitre());
//                autorefil.setNbreparticipants(table.getSelectionModel().getSelectedItem().getNbreparticipants()+"");
//                autorefil.setNewImage(table.getSelectionModel().getSelectedItem().getImage());
//                autorefil.setNewDatefin(table.getSelectionModel().getSelectedItem().getDateFin());
//                autorefil.setNewDatedebut(table.getSelectionModel().getSelectedItem().getDateDebut());
//            //    table.getItems().
//                Parent p = Loader.getRoot();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(p));
//                stage.show();
//                
//                
//                
//            }
//                    
//        });
         
                 
// TODO
    }    

    @FXML
    private void afficherEvent(ActionEvent event) {
        ServiceEvenement se = new ServiceEvenement();
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Evenement> list = FXCollections.observableList(se.afficher());
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        nbreplaces.setCellValueFactory(new PropertyValueFactory<>("nbreplaces"));
        nbreparticipants.setCellValueFactory(new PropertyValueFactory<>("nbreparticipants"));
        datedebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        datefin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        //table.setItems(list);
        // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Evenement> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Evenement e1, Evenement e2) -> e1.getTitre().compareTo(e2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table.setItems(sortedList);
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        ServiceEvenement se = new ServiceEvenement();

        String lieu = NewLieu.getText();
        if (NewLieu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
         // Jouer le son
            String soundFile = "C:\\Users\\DELL\\Documents\\NetBeansProjects\\amir+sirine+ghacen+dhaker\\TRAVOLTA FINALMIXEDD2\\Travolta\\Travolta\\src\\com\\travolta\\utils\\son\\alert.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());  
         alert.showAndWait();
        } else {
        
        Evenement e =  (Evenement) table.getSelectionModel().getSelectedItem();
            LocalDate dateDebut = NewDatedebut.getValue();
LocalDate dateFin = NewDatefin.getValue();
        e.setLieu(NewLieu.getText());
        e.setTitre(NewTitre.getText());
        e.setNbreplaces(Integer.valueOf(NewNbrelpaces.getText()));
        e.setNbreparticipants(Integer.valueOf(Nbreparticipants.getText()));
e.setDateDebut(dateDebut);
e.setDateFin(dateFin);
        e.setImage(NewImage.getText());
        
        se.modifier(e);
        se.afficher();
         
    }
    }
    
    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    

    @FXML
     private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    NewLieu.setText(lieu.getCellData(index).toString());
    NewNbrelpaces.setText(nbreplaces.getCellData(index).toString());
    NewTitre.setText(titre.getCellData(index).toString());
    Nbreparticipants.setText(nbreparticipants.getCellData(index).toString());

    NewImage.setText(image.getCellData(index).toString());
       
    }
    
}
