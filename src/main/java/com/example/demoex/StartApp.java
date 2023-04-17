package com.example.demoex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ControllerApp.class.getResource("Auth.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 330);
        stage.setTitle("Авторизация");
        stage.getIcons().addAll(new Image("logo.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}