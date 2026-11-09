package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Welcome to Modern JavaFX!");
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button button = new Button("Click Me");
        button.setOnAction(e -> label.setText("Button Clicked!"));

        VBox root = new VBox(15, label, button);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Activity 1 - First JavaFX Window");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
