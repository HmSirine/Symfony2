/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.PaymentFlouci;
import services.ServicePayment;
import tests.Flouci;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author mr.rhimi
 */
public class WebviewFlouciController implements Initializable {

    @FXML
    private WebView webview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          WebEngine webEngine =webview.getEngine();
          ServicePayment newPayment =new ServicePayment();
       
         // Flouci flous ;
           Flouci api =new Flouci();
        try {
            //;
            //float total=100 ;
            String link = (String) api.MakeFlous().get("link");
             String trasacntion_id = (String) api.MakeFlous().get("payment_id");
          //   Float montant = (Float) api.MakeFlous().get("montant");
             newPayment.ajouter(new PaymentFlouci(1,1,100,trasacntion_id,0));
                
            System.out.println(link);
               webEngine.load(link);
         // WebHistory webHistroy webEngine.getHistory();
          System.out.println(webEngine.getUserAgent());
          
        //  webEngine.setUserAgent(value);
        } catch (IOException ex) {
            Logger.getLogger(WebviewFlouciController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
       
          
    
}
}