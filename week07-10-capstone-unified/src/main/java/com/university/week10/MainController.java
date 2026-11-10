package com.university.week10;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class MainController {
    @FXML private StackPane centerPane;

    @FXML
    public void initialize() {
        showDashboard();
    }

    @FXML
    private void showDashboard() {
        centerPane.getChildren().setAll(new Label("Welcome to the University Management Dashboard!"));
    }

    @FXML
    private void showStudents() {
        try {
            Parent studentView = FXMLLoader.load(getClass().getResource("/com/university/week10/StudentView.fxml"));
            centerPane.getChildren().setAll(studentView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
