/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Locations;
import tests.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class ItemReservationController implements Initializable {

    @FXML
    private Label setDateD;
    @FXML
    private Label setDateF;
    @FXML
    private Label setMontantLabel;
    @FXML
    private Label LabelDesti;
    @FXML
    private Label LabelMatricule;
    @FXML
    private Label LabelStatus;
    @FXML
    private Button Buttonnotpaid;
    
     private MyListener myListener;
     private Locations loca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData(Locations loca) {
    this.loca = loca;
   
   // setDateD.setText(loca.getDebut_location());
   LabelDesti.setText(loca.getDestination());
   java.sql.Date sqldate_d= java.sql.Date.valueOf(   loca.getDebut_location());
      java.sql.Date sqldate_fin = java.sql.Date.valueOf(   loca.getFin_location());
   setDateD.setText(sqldate_d+"");
    setDateF.setText(sqldate_fin+"");
    LabelMatricule.setText("189TU1828");
    if (loca.getStatus()==0){
         LabelStatus.setText("Paiment en attend"); 
      }else if (loca.getStatus() ==1){
        LabelStatus.setText("Confirmee");  
        Buttonnotpaid.setVisible(false);
    }else { LabelStatus.setText("Annulee");  
             Buttonnotpaid.setVisible(false);
      }
   
 setMontantLabel.setText(String.valueOf(loca.getMontant())); 
    
  
}

  

}
