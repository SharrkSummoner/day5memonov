package com.example.demoex;


import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;



public class order {
    @FXML
    private TextField idClient;
    @FXML
    private javafx.scene.control.CheckBox check;
    @FXML
    private TextField FIOClient;
    @FXML
    private TextField pass1;
    @FXML
    public javafx.scene.control.Label empty1;
    @FXML
    private TextField PasportData;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField password;
    @FXML
    public javafx.scene.control.Button back1;
    @FXML
    private TextField tel;
    @FXML
    private javafx.scene.control.Button accept1;
    @FXML
    private TextField address;
    db db = new db();
    public static String dolgnost = " ";

    public void BackToProfile(ActionEvent actionEvent) {
        System.out.println(dolgnost);
        if (Objects.equals(dolgnost, "Продавец")) {
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("seller.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            primaryStage.setTitle("Профиль");
            primaryStage.setScene(new Scene(root, 600, 330));
            primaryStage.getIcons().add(new Image("logo.png"));
            primaryStage.setResizable(false);
            primaryStage.show();
            Stage stage = (Stage) back1.getScene().getWindow();
            stage.close();
        }else{
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("seller.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            primaryStage.setTitle("Профиль");
            primaryStage.setScene(new Scene(root, 600, 330));
            primaryStage.getIcons().add(new Image("logo.png"));
            primaryStage.setResizable(false);
            primaryStage.show();
            Stage stage = (Stage) back1.getScene().getWindow();
            stage.close();
        }
    }

}
