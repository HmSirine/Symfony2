/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Utilisateur;
import services.CrudUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MonCompteController implements Initializable {

    private Label lbNom;
    private Label lbPrenom;
    private Label lbAdresse;
     @FXML
    private Button btnlogout;
      @FXML
    private Button btnRec;
       @FXML
    private Button btnAcc;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private Button modifierCompte;
 
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     CrudUtilisateur se = new CrudUtilisateur();
    List<Utilisateur> list = new ArrayList<>();
   
      list.addAll(se.afficher());
       System.out.println(list.get(1).getNom());
      setLbNom(list.get(1).getNom());
      setLbPrenom(list.get(1).getPrenom());
      setLbAdresse(list.get(1).getAdresse());
      
      
    }    
    
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
    
    @FXML
    private void Reclamation(ActionEvent event) throws IOException {

        btnRec.getScene().getWindow().hide();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        //primaryStage.setTitle("Tfarhida!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private void Acceuil(ActionEvent event) throws IOException {

        btnAcc.getScene().getWindow().hide();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
     public void setLbNom(String user) {
        tfNom.setText(user);
    }

    public void setLbPrenom(String user) {
        tfPrenom.setText(user);
    }
    
    public void setLbAdresse(String user) {
        this.tfAdresse.setText(user);
    }

    @FXML
    private void modifierCompte(ActionEvent event) {
        CrudUtilisateur cu= new CrudUtilisateur();
        
    }
    public void modifierCompte() {
        CrudUtilisateur cu = new CrudUtilisateur();
          String nom = tfNom.getText();
          String prenom = tfPrenom.getText();
          String adresse = tfAdresse.getText();
          
         //int id = Integer.parseInt(tfId.getText());
        
        Utilisateur u = null ;
        
        u.setNom(tfNom.getText());
        u.setPrenom(tfPrenom.getText());
        u.setAdresse(tfAdresse.getText());
        
        
         try {
            JOptionPane.showMessageDialog(null, "Utilisateur modifié !");
            System.out.println(u.getId());
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        cu.modifier(u);
        cu.afficher();
         
        
    }
    
}
