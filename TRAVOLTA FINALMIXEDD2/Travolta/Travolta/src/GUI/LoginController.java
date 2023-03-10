/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Utilisateur;
import services.CrudUtilisateur;
import services.PasswordHasher;
import utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class LoginController implements Initializable {

    @FXML
    private TextField loginMessageLabel;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void IntInscription(ActionEvent event) throws IOException {

        // Load the login.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
        Parent root = loader.load();

        // Create a new stage for the login.fxml file
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current stage (the stage containing the "Mon compte" button)
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void mdpOubliee(ActionEvent event) throws IOException {

        // Load the login.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgPwd.fxml"));
        Parent root = loader.load();

        // Create a new stage for the login.fxml file
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current stage (the stage containing the "Mon compte" button)
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    public void LoginUserController() {
        Connection cnx = DataSource.getInstance().getCnx();
    }

    private boolean validateFields() {
        boolean isValid = true;

        // Vérification du champ email
        if (Adresse.getText().isEmpty() || !Adresse.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une adresse email valide");
            alert.showAndWait();
            isValid = false;
        }

        // Vérification du champ mdp
        if (Mdp.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre mot de passe");
            alert.showAndWait();
            isValid = false;
        }
        return isValid;
    }
//    @FXML
//    private void loginButtonOnAction(ActionEvent event) throws IOException {
//             if (validateFields()) {
//        CrudUtilisateur cu = new CrudUtilisateur();
//        String adresse = Adresse.getText();
//        String mdp = Mdp.getText();
//
//        if (adresse.length() == 0 || mdp.length() == 0) {
//            System.out.println("Veuillez saisir vos informations");
//        } else {
//             boolean exist = cu.ValidateLogin(adresse, PasswordHasher.hash(mdp));
//         //   boolean exist = cu.ValidateLogin(adresse, mdp);
//            if (exist == false) {
//                loginMessageLabel.setText("Veuillez verifier les champs");
//                //loginButtonOnAction(event);
//            } else {
//
//                // recuperer les infos du user
//               
//                Utilisateur u = cu.SessionDetails(adresse);
//
//             //   UtilisateurSession US = UtilisateurSession.getInstance(u.getId(), u.getNom(), u.getPrenom(), u.getAdresse(), u.getMdp(), u.getRole());
//                System.out.println("bienvenue");
//
//                // rediriger vers la page d'accueil en fonction du rôle
//                Node node = (Node) event.getSource();
//                Stage stage = (Stage) node.getScene().getWindow();
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(getClass().getResource("Acceuil.fxml"));
//
//
////                if (u.getRole().equals("ROLE_USER")) {
////                    loader.setLocation(getClass().getResource("AdminPage.fxml"));
////                } else {
////                    loader.setLocation(getClass().getResource("Acceuil.fxml"));
////                }
//
//                try {
//                    loader.load();
//
//                } catch (IOException ex) {
//                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                    System.out.println("failed to load");
//                    System.out.println(ex);
//                }
//                Parent parent = loader.getRoot();
//                stage.setScene(new Scene(parent));
//                stage.show();
//            }
//        }
//
//    }
//    }

    @FXML
    private void loginButtonOnAction(ActionEvent event) throws IOException {
        if (validateFields()) {
            CrudUtilisateur cu = new CrudUtilisateur();
            String adresse = Adresse.getText();
            String mdp = Mdp.getText();

            if (adresse.length() == 0 || mdp.length() == 0) {
                System.out.println("Veuillez saisir vos informations");
            } else {
                boolean exist = cu.ValidateLogin(adresse, PasswordHasher.hash(mdp));
                //   boolean exist = cu.ValidateLogin(adresse, mdp);
                if (exist == false) {
                    loginMessageLabel.setText("Veuillez verifier les champs");
                    //loginButtonOnAction(event);
                } else {

                    // recuperer les infos du user
                    Utilisateur u = cu.SessionDetails1(adresse);
                    if (u == null) {
                        System.out.println("Impossible de récupérer les informations utilisateur");
                        return;
                    }
//                Utilisateur u = cu.SessionDetails(adresse);
                    String role = u.getRole();
                    System.out.println("Role value from database: " + role);
                    if (role.equalsIgnoreCase("ROLE_ADMIN")) {
                        // rediriger vers la page d'accueil pour les admins
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
                        Parent parent = loader.load();
                        AdminPageController controller = loader.getController();
                        controller.initData(u);
                        Scene scene = new Scene(parent);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        // rediriger vers la page d'accueil pour les utilisateurs simples
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                        Parent parent = loader.load();
                        AcceuilController controller = loader.getController();
                        controller.initData(u);
                        Scene scene = new Scene(parent);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    }

                }
            }

        }
    }
}
