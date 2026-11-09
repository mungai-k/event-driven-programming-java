package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label statusLabel;

    @FXML
    private void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (user.equals("admin") && pass.equals("1234")) {
            statusLabel.setText("Login Successful!");
            statusLabel.setStyle("-fx-text-fill: green;");
        } else {
            statusLabel.setText("Invalid Username or Password.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
