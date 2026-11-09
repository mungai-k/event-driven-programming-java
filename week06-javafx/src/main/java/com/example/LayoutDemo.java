package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutDemo extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        HBox topBox = new HBox();
        topBox.setPadding(new Insets(15));
        topBox.setStyle("-fx-background-color: #2c3e50;");
        Label headerLabel = new Label("JavaFX Layout Panes Showcase");
        headerLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        topBox.getChildren().add(headerLabel);
        root.setTop(topBox);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("First Name:"), 0, 0);
        grid.add(new TextField(), 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(new TextField(), 1, 1);
        root.setCenter(grid);

        HBox bottomBox = new HBox(10);
        bottomBox.setPadding(new Insets(15));
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        bottomBox.getChildren().addAll(new Button("Submit"), new Button("Cancel"));
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 500, 350);
        stage.setTitle("Activity 2 - Layout Panes Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
