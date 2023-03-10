/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Vehicule;
import services.ServiceVehicule;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class AjouterVehiculeController implements Initializable {

    @FXML
    private TextField tfMarque;
    @FXML
    private TextField tfCouleur;
    @FXML
    private Button bAfficher;
    @FXML
    private Button VAjouter;
    @FXML
    private TableView<Vehicule> table;
    @FXML
    private TableColumn<Vehicule, String> MarqueC1;
    @FXML
    private TableColumn<Vehicule, String> MatriculeC1;
    @FXML
    private TableColumn<Vehicule, String> CouleurC2;
    @FXML
    private TableColumn<Vehicule, Float> PrixC1;
    @FXML
    private TableColumn<Vehicule, Integer> NbPC1;
    @FXML
    private TableColumn<Vehicule, Integer> DispoC1;
    @FXML
    private TableColumn<Vehicule, String> ImageC1;
    @FXML
    private TextField tfMatricule;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField tfNbplace;
    @FXML
    private TextField tfDispo;
    @FXML
    private Button bMenu1;
    @FXML
    private Button VFile;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ActionEvent event = null;
        
          
        afficherVehicule(event);
    }    

    @FXML
    private void afficherVehicule(ActionEvent event) {
        ServiceVehicule se = new ServiceVehicule();
   
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Vehicule> list = FXCollections.observableList(se.afficher());
        MarqueC1.setCellValueFactory(new PropertyValueFactory<>("marque"));
        MatriculeC1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        CouleurC2.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        PrixC1.setCellValueFactory(new PropertyValueFactory<>("prix"));
        NbPC1.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        DispoC1.setCellValueFactory(new PropertyValueFactory<>("status"));
        ImageC1.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list);  
    }

    @FXML
    private void AjouterVehicule(ActionEvent event) {
         ServiceVehicule sp = new ServiceVehicule();

         sp.ajouter(new Vehicule(tfMarque.getText(), tfMatricule.getText(), tfCouleur.getText(), Float.parseFloat(tfPrix.getText()), Integer.parseInt(tfNbplace.getText()), Integer.parseInt(tfDispo.getText()),tfimage.getText() ));
         // JOptionPane.showMessageDialog(null, "Vehicule ajoutée !");
         
        
          
        afficherVehicule(event);
    }

    @FXML 
    private void selectEvent(MouseEvent event) {
    }

    @FXML
    private void MenuBack(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuVehicule.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) bMenu1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
           MenuVehiculeController dpc = loader.getController();
         dpc.showVehicule(event);
    }

    @FXML
    private void UploadFile1(ActionEvent event) {
     /*   FileChooser fileChooser = new FileChooser();
        fileChooser.showOpenDialog(ownerWindow)
        */
            }
    }
    


   