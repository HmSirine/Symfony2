/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Vehicule;
import services.ServiceVehicule;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class ModifierVehiculeController implements Initializable {

    @FXML
    private TextField tfMarque;
    @FXML
    private TextField tfCouleur;
    @FXML
    private Button bAfficher;
    @FXML
    private Button VModifier;
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
    private TableColumn<Vehicule, Integer> NbPlC1;
    @FXML
    private TableColumn<Vehicule, Integer> DispoC;
    @FXML
    private TableColumn<Vehicule, String> dateC1111;
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
    private Button VMenu1;
    private  Vehicule ger;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event = null;
         afficherVehicule(event);
         
        
         /*
         table.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
          
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("ModifierVehicule.fxml"));
                
                try {
                    Loader.load();
                } catch (IOException ex) {
                 ex.printStackTrace();
                    
                   // Logger.getLogger(ModifierVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
                }
              
                Vehicule ger =  (Vehicule) table.getSelectionModel().getSelectedItem();
                
                ModifierVehiculeController autorefil = Loader.getController();
                autorefil.settfCouleur(table.getSelectionModel().getSelectedItem().getCouleur());
                autorefil.settfDispo(table.getSelectionModel().getSelectedItem().getStatus()+"");
                autorefil.settfMarque(table.getSelectionModel().getSelectedItem().getMarque());
                autorefil.settfMatricule(table.getSelectionModel().getSelectedItem().getMatricule());
                autorefil.settfPrix(table.getSelectionModel().getSelectedItem().getPrix()+"");
                autorefil.settfNbplace(table.getSelectionModel().getSelectedItem().getNb_place()+"");
                autorefil.settfimage(table.getSelectionModel().getSelectedItem().getImage());
            //    table.getItems().
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                
                
                
            }
                    
        });
         */
         
} 
    @FXML
    public void afficherVehicule(ActionEvent event) {
              ServiceVehicule se = new ServiceVehicule();
   
        //ObservableList<Evenement> list = (ObservableList<Evenement>) se.afficher();
        ObservableList<Vehicule> list = FXCollections.observableList(se.afficher());
        MarqueC1.setCellValueFactory(new PropertyValueFactory<>("marque"));
        MatriculeC1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        CouleurC2.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        PrixC1.setCellValueFactory(new PropertyValueFactory<>("prix"));
        NbPlC1.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        DispoC.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateC1111.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list);  
    }

    @FXML
    private void ModifierVehicule(ActionEvent event) throws IOException {
           
        
        ServiceVehicule se = new ServiceVehicule();
        

        String lieu = tfMarque.getText();
        if (tfMarque.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else {
        
      Vehicule e =  (Vehicule) table.getSelectionModel().getSelectedItem();
      
       // Vehicule e =  new Vehicule();
       //  e.setVehicule_id(Integer.valueOf(table.getSelectionModel().getSelectedItem().getVehicule_id()));
        e.setMarque(tfMarque.getText());
        e.setMatricule(tfMatricule.getText());
        e.setCouleur(tfCouleur.getText());
        e.setPrix(Float.valueOf(tfPrix.getText()));
        e.setNb_place(Integer.valueOf(tfNbplace.getText()));
        e.setStatus(Integer.valueOf(tfDispo.getText()));
        e.setImage(tfimage.getText());
        
        se.modifier(e);
        //se.afficher();
        
        afficherVehicule(event);
         
    
        /*ServiceVehicule sa = new ServiceVehicule();

        String marque = tfMarque.getText();
        if (tfMarque.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else if (tfCouleur.getText().isEmpty()) {
            Alert al2 = new Alert(Alert.AlertType.ERROR);
            al2.setTitle("Erreur");
            al2.setHeaderText(null);
            al2.setContentText("vérifier vos informations");
            al2.showAndWait();
        } else {
        //Float prix = Float.parseFloat(tfPrix.getText());
       // Date date = java.sql.Date.valueOf(NewDate.getValue());
        Vehicule re =  table.getSelectionModel().getSelectedItem();
        
        //re.setDate(date);
        re.setMarque(marque);
        sa.modifier(re);
       sa.afficher();
         
    }*/
    } }


    @FXML
    private void MenuBack(ActionEvent event) throws IOException {
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuVehicule.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) VMenu1.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
         MenuVehiculeController dpc = loader.getController();
         dpc.showVehicule(event);
    }
      public void settfMarque(String prenom) {
      
        this.tfMarque.setText(prenom);
    }
        public void settfCouleur(String prenom) {
      
        this.tfCouleur.setText(prenom);
    }
          public void settfMatricule(String prenom) {
      
        this.tfMatricule.setText(prenom);
    }
            public void settfPrix(String prenom) {
      
        this.tfPrix.setText(prenom);
    }
            public void settfimage(String prenom) {
      
        this.tfimage.setText(prenom);
    }
            public void settfNbplace(String prenom) {
      
        this.tfNbplace.setText(prenom);
    }
      public void settfDispo(String prenom) {
      
        this.tfDispo.setText(prenom);
    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
   
        return;
    }
    tfMarque.setText(MarqueC1.getCellData(index).toString());
    tfMatricule.setText(MatriculeC1.getCellData(index).toString());
    tfCouleur.setText(CouleurC2.getCellData(index).toString());
    tfPrix.setText(PrixC1.getCellData(index).toString());
    tfNbplace.setText(NbPlC1.getCellData(index).toString());
    tfDispo.setText(DispoC.getCellData(index).toString());
    tfimage.setText(dateC1111.getCellData(index).toString());
       
    }
}
