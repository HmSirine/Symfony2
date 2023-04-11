/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Locations;
import models.Vehicule;
import services.ServiceLocation;
import services.ServiceVehicule;
import telegram.SendMessage;
import tests.GeolocationExample;
import tests.MyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class ClientInterfaceController implements Initializable {

    //@FXML
   // private VBox CarContainer;
    @FXML
    private Label setCouleur;
    @FXML
    private Label SetMatricule;
    @FXML
    private Label SetNBPlace;
    @FXML
    private Label SetMontant;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label SetMarque;
    @FXML
    private Label SetPrice;
    @FXML
    private ImageView SetImage;
    private Image image;
    private List<Vehicule> Vehicules = new ArrayList<>();
    private MyListener myListener;
    private MyListener myListener1;
    @FXML
    private HBox Debut;
    @FXML
    private DatePicker Debuts;
    @FXML
    private DatePicker Fins;
    @FXML
    private TextField Destination;
    @FXML
    private Button Rserverbtn;
    @FXML
    private Button Reservation;
    @FXML
    private Button retourdhakersirine;



    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceVehicule se = new ServiceVehicule();
     Vehicules.addAll(se.afficher());
               if (Vehicules.size() > 0) {
                   setChosenCar(Vehicules.get(0));
                    
            myListener = new MyListener() {
                @Override
                public void onClickListener(Vehicule vehicule) {
                    setChosenCar(vehicule);
                   
                }
                
                
                
            };
        }
            int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Vehicules.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./items.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemsController itemController = fxmlLoader.getController();
                itemController.setData(Vehicules.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                } 
                  grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    } 

    @FXML
    private void GetMyLocalisation(MouseEvent event) throws IOException {
        GeolocationExample ip =new GeolocationExample();
         String city = ip.GetLocationfromip();
      
        Destination.setText(city);
    }

    @FXML
    private void Search(ActionEvent event) {
    }

    @FXML
    private void Reserver(ActionEvent event) throws IOException {
        
        
        
       ServiceLocation sp1 = new ServiceLocation();
       LocalDate sqldate_arrivee = Debuts.getValue();
LocalDate sqldate_depart = Fins.getValue();
      sp1.ajouter(new Locations(1,1,sqldate_arrivee, sqldate_depart, Destination.getText(), Float.parseFloat( SetMontant.getText()) , 0  ));
    SendMessage tele = new SendMessage() ;
          tele.sendToTelegram();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("WebviewFlouci.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Rserverbtn.getScene().getWindow();
        stage.setScene(newScene);
    
        
    }
     /*   catch (IOException ex) {
            Logger.getLogger(ClientInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
         catch (IOException ex) {
            Logger.getLogger(ClientInterfaceController.class.getName()).log(Level.SEVERE, null, ex);*/
    
private Double MontantTotale(DatePicker D1,DatePicker D2 ,Double p) {
    LocalDate startDate = D1.getValue();
LocalDate endDate = D2.getValue();
long diffDays = ChronoUnit.DAYS.between(startDate, endDate);
double montant =diffDays* p;
        return montant;
   
}
private void setChosenCar(Vehicule vehicule) {  
    
     SetMarque.setText(vehicule.getMarque());
     setCouleur.setText(vehicule.getCouleur());
      SetNBPlace.setText(vehicule.getNb_place()+"");
     SetMatricule.setText(vehicule.getMatricule());
     // CalculateMontant(vehicule.getPrix());
        SetPrice.setText( vehicule.getPrix()+"");
         String imagePath  = vehicule.getImage();
        image = new Image(getClass().getResourceAsStream(imagePath));
        SetImage.setImage(image);
}

    @FXML
     public void CalculateMontant() {
         
        LocalDate startDate = Debuts.getValue();
        LocalDate endDate = Fins.getValue();
        
        if (startDate != null && endDate != null) {
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
      float montant = daysBetween *100;
            SetMontant.setText(String.valueOf(montant));
        } else {
            SetMontant.setText(" select dates");
        }
    }

    @FXML
    private void MesReservations(ActionEvent event) throws IOException {
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationInterfaceClient.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Reservation.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void dhakerToSirine(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
}
