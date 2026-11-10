package com.university.week10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends Application {
    private ScheduledExecutorService scheduler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/university/week10/MainView.fxml"));
        primaryStage.setTitle("Week 10 Capstone - University Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        // LO3: Scheduled Tasks (Background Heartbeat Auto-Refresh)
        scheduler = Executors.newScheduledThreadPool(1);
        Runnable heartbeat = () -> System.out.println("System Heartbeat: Checking DB sync at " + new Date());
        scheduler.scheduleAtFixedRate(heartbeat, 0, 5, TimeUnit.SECONDS);
    }

    @Override
    public void stop() throws Exception {
        if (scheduler != null) scheduler.shutdown();
        super.stop();
    }

    public static void main(String[] args) { launch(args); }
}
