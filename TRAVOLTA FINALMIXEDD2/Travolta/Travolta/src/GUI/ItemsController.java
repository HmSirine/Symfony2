/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Vehicule;
import tests.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class ItemsController implements Initializable {

    @FXML
    private Label SetMarque;
    @FXML
    private Label setPrice;
    @FXML
    private ImageView SetImage;
    private MyListener myListener;
     private Vehicule vehicule;
     @FXML
    private void click(MouseEvent mouseEvent) {
        
        myListener.onClickListener(vehicule);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /* public void setData(Vehicule vehicule, MyListener myListener) {
        this.vehicule = vehicule;
        this.myListener = myListener;
        SetMarque.setText(vehicule.getMarque());
        setPrice.setText(vehicule.getPrix()+"");
        Image image = new Image(getClass().getResourceAsStream(vehicule.getImage()));
        SetImage.setImage(image);
    }*/
    public void setData(Vehicule vehicule, MyListener myListener) {
    this.vehicule = vehicule;
    this.myListener = myListener;
    SetMarque.setText(vehicule.getMarque());
    setPrice.setText(String.valueOf(vehicule.getPrix())); // Convert int to String
    
    try {
        Image image = new Image(getClass().getResourceAsStream(vehicule.getImage()));
        SetImage.setImage(image);
    } catch (NullPointerException e) {
        System.err.println("Error loading image: " + e.getMessage());
        SetImage.setImage(null); // Set image to null if there's an error
    }
}

}
