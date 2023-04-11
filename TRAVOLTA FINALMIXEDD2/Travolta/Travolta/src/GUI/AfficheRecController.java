/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficheRecController implements Initializable {

    @FXML
    private Label lbObjet;
    @FXML
    private Label lbMessage;
    @FXML
    private Label Objet;
    @FXML
    private Label Message;
    @FXML
    private Label titre;
    @FXML
    private Button btnImprimer;

    private Window primaryStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setLbObjet(String objet) {
        this.lbObjet.setText(objet);
    }

    public void setLbMessage(String message) {
        this.lbMessage.setText(message);
    }

    @FXML
    private void ImpPDF(ActionEvent event) throws IOException {

        System.out.println("To Printer!");
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            Window primaryStage = null;
            job.showPrintDialog(this.primaryStage);
            Node root1 = this.titre;
            Node root2 = this.Objet;
            Node root3 = this.lbObjet;

            Node root4 = this.Message;
            Node root5 = this.lbMessage;

            Group rootGroup = new Group(root1, root2, root3, root4, root5);
            job.printPage(rootGroup);
            job.endJob();

            // Load the login.fxml file
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
            Parent root = loader.load();

            // Create a new stage for the login.fxml file
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
//
        }
    }

}
