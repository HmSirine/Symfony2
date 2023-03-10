/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.travolta.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author mr.rhimi
 */
public class FileUpload extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            // Define the target directory to upload the file to
            
                      String targetDirectory = "/Users/mr.rhimi/NetBeansProjects/Travolta/src/com/travolta/utils/images/";
            //String targetDirectory = "../uploads\\";

            try {
                // Create the target directory if it doesn't exist
                Path directoryPath = Paths.get(targetDirectory);
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                // Copy the selected file to the target directory
                Path selectedFilePath = Paths.get(selectedFile.getAbsolutePath());
                Path targetFilePath = Paths.get(targetDirectory + selectedFile.getName());
                Files.copy(selectedFilePath, targetFilePath);

                System.out.println("File uploaded successfully to: " + targetFilePath.toString());

            } catch (IOException e) {
                System.out.println("Error uploading file: " + e.getMessage());
            }
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
