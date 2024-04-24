package com.example.jushuapeterte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public Controller() {
        @FXML
        private void handleHomeButton(ActionEvent event) throws IOException {
            loadFXML("Home.fxml");
        }

        @FXML
        private void handlePage01Button(ActionEvent event) throws IOException {
            loadFXML("Page01.fxml");
        }

        @FXML
        private void handlePage02Button(ActionEvent event) throws IOException {
            loadFXML("Page02.fxml");
        }

        @FXML
        private void handlePage03Button(ActionEvent event) throws IOException {
            loadFXML("Page03.fxml");
        }

        private void loadFXML(String fxmlFile) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void up(ActionEvent e) {
        System.out.println("UP");
    }

    public void down(ActionEvent e) {
        System.out.println("DOWN");
    }

    public void left(ActionEvent e) {
        System.out.println("LEFT");
    }

    public void right(ActionEvent e) {
        System.out.println("RIGHT");
    }
}
