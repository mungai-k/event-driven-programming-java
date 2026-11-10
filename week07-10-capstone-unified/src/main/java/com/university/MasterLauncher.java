package com.university;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MasterLauncher extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #1e293b;");

        Label title = new Label("Unified JavaFX Course Suite (Weeks 7 - 10)");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;");

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        // Week 7 Buttons
        grid.add(createHeaderLabel("Week 7: Events"), 0, 0);
        grid.add(createLaunchBtn("Activity 1: Propagation", () -> new com.university.week07.EventPropagationDemo().start(new Stage())), 0, 1);
        grid.add(createLaunchBtn("Activity 2: Mouse & Keys", () -> new com.university.week07.MouseKeyDemo().start(new Stage())), 0, 2);
        grid.add(createLaunchBtn("Activity 3: Drag & Drop", () -> new com.university.week07.DragDropDemo().start(new Stage())), 0, 3);
        grid.add(createLaunchBtn("Activity 4: Custom Events", () -> new com.university.week07.CustomEventDemo().start(new Stage())), 0, 4);

        // Week 8 Buttons
        grid.add(createHeaderLabel("Week 8: Bindings"), 1, 0);
        grid.add(createLaunchBtn("Activity 2: Listeners", () -> new com.university.week08.ListenerDemo().start(new Stage())), 1, 1);
        grid.add(createLaunchBtn("Activity 3: Unidirectional", () -> new com.university.week08.UnidirectionalDemo().start(new Stage())), 1, 2);
        grid.add(createLaunchBtn("Activity 4: Bidirectional", () -> new com.university.week08.BidirectionalDemo().start(new Stage())), 1, 3);
        grid.add(createLaunchBtn("Activity 5: Reactive Form", () -> new com.university.week08.ReactiveFormApp().start(new Stage())), 1, 4);

        // Week 10 Capstone Button
        grid.add(createHeaderLabel("Week 10: Final Capstone"), 2, 0);
        Button capstoneBtn = createLaunchBtn("University System App", () -> {
            try {
                new com.university.week10.App().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        capstoneBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold;");
        grid.add(capstoneBtn, 2, 1);

        root.getChildren().addAll(title, grid);

        Scene scene = new Scene(root, 750, 450);
        primaryStage.setTitle("Unified Event-Driven JavaFX Master Suite");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createHeaderLabel(String text) {
        Label lbl = new Label(text);
        lbl.setStyle("-fx-text-fill: #38bdf8; -fx-font-size: 14px; -fx-font-weight: bold;");
        return lbl;
    }

    private Button createLaunchBtn(String text, Runnable action) {
        Button btn = new Button(text);
        btn.setPrefWidth(210);
        btn.setStyle("-fx-background-color: #334155; -fx-text-fill: white;");
        btn.setOnAction(e -> action.run());
        return btn;
    }

    public static void main(String[] args) { launch(args); }
}
