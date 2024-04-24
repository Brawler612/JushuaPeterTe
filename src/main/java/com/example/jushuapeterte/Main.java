package com.example.jushuapeterte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double xOffset = 0.0;
    private double yOffset = 0.0;

    public Main() {
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("Main.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed((event) -> {
            this.xOffset = event.getSceneX();
            this.yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((event) -> {
            primaryStage.setX(event.getScreenX() - this.xOffset);
            primaryStage.setY(event.getScreenY() - this.yOffset);
        });
        primaryStage.setScene(new Scene(root, 780.0, 550.0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}