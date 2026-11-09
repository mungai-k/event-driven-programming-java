package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DashboardApp extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane mainLayout = new BorderPane();

        HBox navbar = new HBox();
        navbar.setPadding(new Insets(15));
        navbar.setStyle("-fx-background-color: #1e293b;");
        Label brand = new Label("Analytics Dashboard");
        brand.setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;");
        navbar.getChildren().add(brand);
        mainLayout.setTop(navbar);

        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(15));
        sidebar.setPrefWidth(180);
        sidebar.setStyle("-fx-background-color: #334155;");
        
        String[] menuItems = {"Overview", "Reports", "Users", "Settings"};
        for (String item : menuItems) {
            Button btn = new Button(item);
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-alignment: CENTER-LEFT;");
            sidebar.getChildren().add(btn);
        }
        mainLayout.setLeft(sidebar);

        VBox content = new VBox(20);
        content.setPadding(new Insets(20));

        Label overviewHeader = new Label("Key Metrics");
        overviewHeader.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        HBox cards = new HBox(15);
        cards.getChildren().addAll(
            createCard("Total Revenue", "$48,250", "#0ea5e9"),
            createCard("Active Users", "1,240", "#10b981"),
            createCard("Conversion Rate", "3.42%", "#f59e0b")
        );

        content.getChildren().addAll(overviewHeader, cards);
        mainLayout.setCenter(content);

        Scene scene = new Scene(mainLayout, 850, 550);
        stage.setTitle("Activity 5 - Modern JavaFX Dashboard Capstone");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createCard(String title, String value, String hexColor) {
        VBox card = new VBox(5);
        card.setPadding(new Insets(15));
        card.setPrefWidth(200);
        card.setStyle("-fx-background-color: " + hexColor + "; -fx-background-radius: 8px;");

        Label titleLbl = new Label(title);
        titleLbl.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");

        Label valLbl = new Label(value);
        valLbl.setStyle("-fx-text-fill: white; -fx-font-size: 22px; -fx-font-weight: bold;");

        card.getChildren().addAll(titleLbl, valLbl);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
