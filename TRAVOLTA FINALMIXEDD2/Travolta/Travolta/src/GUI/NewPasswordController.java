/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import services.CrudUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class NewPasswordController implements Initializable {

    private PasswordField NewPwPf;
    private PasswordField ConfirmPwPf;
    @FXML
    private Button SaveButton;
    @FXML
    private Label PassMatchLabel;
    @FXML
    private Button returnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void Newpw(String Email) {
        CrudUtilisateur cu = new CrudUtilisateur();

        SaveButton.setOnAction((ActionEvent event) -> {

            if (!NewPwPf.getText().equals(ConfirmPwPf.getText())) {
                PassMatchLabel.setText("les deux mots de passe sont differents");
            } else {
                cu.NewPw(Email, NewPwPf.getText());

            }

        });
    }

    @FXML
    private void returnLogin(ActionEvent event) throws IOException {

        returnLogin.getScene().getWindow().hide();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("LoginUser.fxml"));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
