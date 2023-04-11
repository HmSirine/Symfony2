
package GUI;

import models.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import GUI.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class AcceuilController implements Initializable {
    
    @FXML
    private Button btnlogout;
    @FXML
    private Label usernameLabel;
    @FXML
    private Button UserRediriction;
    @FXML
    private Button buttonaffiche;
    @FXML
    private Button Voitur;
    @FXML
    private Button clientcrud;
    @FXML
    private Button hotel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   
    
    @FXML
    private void AfficherCompte (ActionEvent event) throws IOException {
        
//        CrudUtilisateur cu = new CrudUtilisateur();
//        String nom = tfNom.getText();
//        String prenom = tfPrenom.getText();
//        String adresse = tfAdresse.getText(); // update the value of "adresse"
//        
//        // recuperer les infos du user
//        Utilisateur u = cu.SessionDetails(adresse, nom, prenom);
//        if (u == null) {
//            System.out.println("Impossible de récupérer les informations utilisateur");
//            return;
//        }
//        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MonCompte.fxml"));
        Parent parent = loader.load();
        AcceuilController controller = loader.getController();
//        controller.setLbNom(u);
//        controller.setLbPrenom(u);
//        controller.setLbAdresse(u);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
//        MonCompteController mc = loader.getController();
//        mc.setLbNom(tfNom.getText());
//        mc.setLbPrenom(tfPrenom.getText());
//        mc.setLbAdresse(tfAdresse.getText());


//        AnchorPane root = FXMLLoader.load(getClass().getResource("MonCompte.fxml"));
//        Scene scene = new Scene(root);
//        Stage primaryStage = new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

        
//        CrudUtilisateur cu = new CrudUtilisateur();
//        String nom = tfNom.getText();
//        String prenom = tfPrenom.getText();
//        String adresse = tfAdresse.getText();
//        // recuperer les infos du user
//        Utilisateur u = cu.SessionDetails(nom, prenom, adresse);
//        if (u == null) {
//        System.out.println("Impossible de récupérer les informations utilisateur");
//                        return;
//                    }
//    
//
//        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MonCompte.fxml"));
//        Scene scene = new Scene(root);
//        Stage primaryStage = new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    
////         MonCompteController mc = loader.getController();
////         mc.setLbNom(tfNom.getText());
////         mc.setLbPrenom(tfPrenom.getText());
////         mc.setLbAdresse(tfAdresse.getText());
//// 
       
           
     @FXML
    private void logOut(ActionEvent event) throws IOException {

        btnlogout.getScene().getWindow().hide();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        //primaryStage.setTitle("Tfarhida!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
     public void initData(Utilisateur user) {
        usernameLabel.setText("Welcome, " + user.getNom());
        // do other initialization tasks
    }

//     public void settfNom(Utilisateur user) {
//        tfNom.setText(user.getNom());
//    }
//
//    public void settfPrenom(Utilisateur user) {
//        tfPrenom.setText(user.getPrenom());
//    }
//    
//    public void settfAdresse(Utilisateur user) {
//        tfAdresse.setText(user.getAdresse());
//    }

    @FXML
    private void ToClientFirstPage(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ExcursionCategory.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void ToLocation(ActionEvent event) {
          try {
            Parent root = FXMLLoader.load(getClass().getResource("ClientInterface.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Clientcrud(ActionEvent event)throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../com/travolta/gui/ClientInterface.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) clientcrud.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Hotel(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) hotel.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
}