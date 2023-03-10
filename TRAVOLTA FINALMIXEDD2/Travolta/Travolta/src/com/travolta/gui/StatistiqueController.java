package com.travolta.gui;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StatistiqueController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private StackPane chartPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      
        // Create data series
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Statistique 1");
        series1.getData().add(new XYChart.Data<>("EVENEMENT", 40));
        series1.getData().add(new XYChart.Data<>("RESERVATION", 20));
        series1.getData().add(new XYChart.Data<>("CATEGORIE", 10));
        series1.getData().add(new XYChart.Data<>("PAIEMENT", 30));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Statistique 2");
        series2.getData().add(new XYChart.Data<>("EVENEMENT", 30));
        series2.getData().add(new XYChart.Data<>("RESERVATION", 10));
        series2.getData().add(new XYChart.Data<>("CATEGORIE", 40));
        series2.getData().add(new XYChart.Data<>("PAIEMENT", 20));

        // Create chart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Statistique");
        chart.getData().addAll(series1, series2);

        // Add chart to the chart pane
        chartPane.getChildren().add(chart);
        chartPane.setPrefSize(600, 360);

        backButton.setVisible(true);
    }

    

    private void Statistique(ActionEvent event) {
        // Create data series
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Statistique 1");
        series1.getData().add(new XYChart.Data<>("EVENEMENT", 40));
        series1.getData().add(new XYChart.Data<>("RESERVATION", 20));
        series1.getData().add(new XYChart.Data<>("CATEGORIE", 10));
        series1.getData().add(new XYChart.Data<>("PAIEMENT", 30));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Statistique 2");
        series2.getData().add(new XYChart.Data<>("EVENEMENT", 30));
        series2.getData().add(new XYChart.Data<>("RESERVATION", 10));
        series2.getData().add(new XYChart.Data<>("CATEGORIE", 40));
        series2.getData().add(new XYChart.Data<>("PAIEMENT", 20));

        // Create chart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Statistique");
        chart.getData().addAll(series1, series2);

        // Add chart to a stack pane
        StackPane stackPane = new StackPane(chart);
        Scene scene = new Scene(stackPane, 600, 400);

        // Get the stage from the event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        backButton.setVisible(true);
    }

    @FXML
    private void goBack(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
        backButton.setVisible(false);
    }
}
