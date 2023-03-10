/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class PaymentController implements Initializable {

    @FXML
    private Button bAfficher;
    @FXML
    private Button VMenu1;
    @FXML
    private TextField CreditCard;
    @FXML
    private TextField CCV;
    @FXML
    private ChoiceBox<String> MMChoice;
    private    String[] MM ={"1","2","3","4","5","6","7","8","9","10","11","12"};
    @FXML
    private ChoiceBox<String> YYChoice;
     private    String[] YY ={"23","24","25","26","27","28","29","30"};
    @FXML
    private Label Getmontant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MMChoice.getItems().addAll(MM);
        MMChoice.setOnAction(this::getMM);
        YYChoice.getItems().addAll(YY);
        YYChoice.setOnAction(this::getYY);
    }    

    @FXML
    private void payy(ActionEvent event) {
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }
    public void getMM(ActionEvent  event) {
    String MMS=MMChoice.getValue() ;
    }
       public void getYY(ActionEvent  event) {
    String YYS=YYChoice.getValue();
    }
}
