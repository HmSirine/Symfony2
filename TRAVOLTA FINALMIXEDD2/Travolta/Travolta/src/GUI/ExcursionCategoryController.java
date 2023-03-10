package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ExcursionCategoryController implements Initializable {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
    
    public static String SelectedExcursion;

    @FXML
    private FlowPane excursionFlowPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travolta", "root", "");
            PreparedStatement statement = conn.prepareStatement("SELECT DISTINCT TypeExcursion FROM excursion");
            ResultSet resultSet = statement.executeQuery();
            Set<String> types = new HashSet<>();
            while (resultSet.next()) {
                types.add(resultSet.getString("TypeExcursion"));
            }
            List<String> sortedTypes = new ArrayList<>(types);
            sortedTypes.sort(String::compareTo);
            for (String type : sortedTypes) {
                Button button = new Button(type);
                button.setOnAction((ActionEvent event) -> {
                   SelectedExcursion=type;
                    System.out.println("excursion selectionné"+SelectedExcursion);
                     try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientFirstPage.fxml"));
        Parent root = loader.load();
        ClientFirstPageController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) excursionFlowPane.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
                   
                });
                excursionFlowPane.getChildren().add(button);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String handleExcursionClick( ) {
        return SelectedExcursion;
        
    }
    
    
    @FXML
private void handleButtonClick(ActionEvent event) throws IOException {
    
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    
    
    
}
    
    
    
    
    
    
}