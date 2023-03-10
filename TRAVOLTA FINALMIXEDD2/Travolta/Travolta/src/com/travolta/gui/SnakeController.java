package com.travolta.gui;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SnakeController implements Initializable {
    private LinkedList<Rectangle> snake;
    // Constants for game settings
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int STARTING_LENGTH = 3;
    private static final Color BACKGROUND_COLOR = Color.WHITE;

    // Variables for game state
    
    private Rectangle food;
    private int directionX, directionY;
    private boolean gameRunning;
    private int score;

    @FXML
    private VBox root;
    @FXML
    private Label scoreLabel;
    @FXML
    private Pane gamePane;
    @FXML
    private Button menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameRunning = false;
        score = 0;
        snake = new LinkedList<>();
       
        // Add the initial rectangle to the snake
        Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE, Color.RED);
        snake.add(rect);
        if (gamePane != null) {
            gamePane.getChildren().add(rect);
        } else {
            System.out.println("gamePane is null");
        }
    }

    @FXML
    private void startGame() {
        if (gameRunning) {
            return;
        }
        gameRunning = true;
        score = 0;
        scoreLabel.setText("0");

        // Initialize game state
        if (snake == null) {
            snake = new LinkedList<>();
        }
        for (int i = 0; i < STARTING_LENGTH; i++) {
            Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE, Color.RED);
            rect.setX(TILE_SIZE * i);
            rect.setY(0);
            snake.add(rect);
            if (gamePane != null) {
                gamePane.getChildren().add(rect);
            } else {
                System.out.println("gamePane is null");
            }
        }
        if (food == null) {
            food = new Rectangle(TILE_SIZE, TILE_SIZE, Color.RED);
            if (gamePane != null) {
                gamePane.getChildren().add(food);
            } else {
                System.out.println("gamePane is null");
            }
        }
        placeFood();
        directionX = TILE_SIZE;
        directionY = 0;

        // Set up game loop
        gamePane.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT && directionX != TILE_SIZE) {
                directionX = -TILE_SIZE;
                directionY = 0;
            } else if (event.getCode() == KeyCode.RIGHT && directionX != -TILE_SIZE) {
                directionX = TILE_SIZE;
                directionY = 0;
            } else if (event.getCode() == KeyCode.UP && directionY != TILE_SIZE) {
                directionX = 0;
                directionY = -TILE_SIZE;
            } else if (event.getCode() == KeyCode.DOWN && directionY != -TILE_SIZE) {
                directionX = 0;
                directionY = TILE_SIZE;
            }
        });

                   new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long now) {
            if (now - lastUpdate >= 100_000_000) {
                lastUpdate = now;
                updateGame();
            }
        }
    }.start();
}

private void updateGame() {
    // Move the snake
    Rectangle head = snake.getLast();
    double newX = head.getX() + directionX;
    double newY = head.getY() + directionY;

    // Check for collision with walls
    if (newX < 0 || newX >= WIDTH || newY < 0 || newY >= HEIGHT) {
        gameRunning = false;
        endGame();
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" masit fel 7it");
            alert.showAndWait();
        return;
    }

    // Check for collision with food
    if (newX == food.getX() && newY == food.getY()) {
        score++;
        scoreLabel.setText(String.valueOf(score));
        placeFood();
        Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE, Color.RED);
        rect.setX(newX);
        rect.setY(newY);
        snake.add(rect);
        gamePane.getChildren().add(rect);
    } else {
        // Move the tail to the front
        Rectangle tail = snake.remove();
        tail.setX(newX);
        tail.setY(newY);
        snake.add(tail);
    }

    // Check for collision with itself
    for (int i = 0; i < snake.size() - 1; i++) {
        Rectangle rect = snake.get(i);
        if (newX == rect.getX() && newY == rect.getY()) {
            gameRunning = false;
            endGame();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(" KLIT ROUHEK");
            alert.showAndWait();
            return;
        }
    }
}

private void placeFood() {
    Random rand = new Random();
    int x = rand.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
    int y = rand.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
    food.setX(x);
    food.setY(y);
}

private void endGame() {
    // Show game over dialog
    Dialog<ButtonType> gameOverDialog = new Dialog<>();
    gameOverDialog.setTitle("Game Over");
    gameOverDialog.setHeaderText("Your Score: " + score);
    ButtonType restartButton = new ButtonType("Restart");
    ButtonType quitButton = new ButtonType("Quit");
    gameOverDialog.getDialogPane().getButtonTypes().addAll(restartButton, quitButton);
    gameOverDialog.showAndWait().ifPresent(buttonType -> {
        if (buttonType == restartButton) {
            startGame();
        } else if (buttonType == quitButton) {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.close();
        }
    });

}

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
}