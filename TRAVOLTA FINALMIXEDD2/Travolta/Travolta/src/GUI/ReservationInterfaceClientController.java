/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Locations;
import models.Vehicule;
import services.ServiceLocation;
import tests.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class ReservationInterfaceClientController implements Initializable {

    @FXML
    private ScrollPane scroll;
    
    private List<Locations> locations = new ArrayList<>();
    private MyListener myListener;
    @FXML
    VBox reservationLayouts;
    @FXML
    private GridPane grid;
    @FXML
    private Button acceuilsss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
            ServiceLocation se = new ServiceLocation();
     locations.addAll(se.afficher());
     int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < locations.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./ItemReservation.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemReservationController itemController = fxmlLoader.getController();
                itemController.setData(locations.get(i));

                if (column == 1) {
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

                GridPane.setMargin(anchorPane, new Insets(0));
            }
     
     
     } 
                        catch (IOException e)  { e.printStackTrace();
}
     
     
     
     
     
     
     
     
    /* for (int i=0; i<locations.size(); i++)
     {
        
                        FXMLLoader fxmlLoader = new FXMLLoader () ;
                        fxmlLoader.setLocation(getClass().getResource("./ItemReservation.fxml"));
                        try {
                        HBox hBox = fxmlLoader. load();
                        ItemReservationController cic = new ItemReservationController();
                        cic.setData(locations.get(i));
                        reservationLayouts.getChildren().add(hBox);
} 
                        catch (IOException e)  { e.printStackTrace();
}

    }   
   */
}

    @FXML
    private void GetmeAccueil(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) acceuilsss.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
}