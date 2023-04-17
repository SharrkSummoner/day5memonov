package com.example.demoex;


import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;


public class ControllerApp {

    @FXML
    public ImageView img2;
   @FXML
    public TextField asd;
    @FXML
    public TextField zxc;
    public CheckBox check;
    public PasswordField pass;
    public Label nomer;
    public Label parol;
    public Label kod;
    public Button but;
    public Label log;


    @FXML
    TextField num;
    @FXML
    javafx.scene.control.Label num1;
    db db = new db();
    String random;
    String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#($*%&^)1234567890";
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        img2.setImage(new Image("reload.jpg"));
        img2.setVisible(false);

        num.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)){
                    String number = num.getText();
                    ArrayList<String> n = null;
                    try {
                        n = db.Login();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    int b =0;
                    for (int i=0; i<n.size();i++) {
                        if (number.equals(n.get(i))) {
                            b = 1;
                        }
                    }
                    if (b==1) {
                        but.setVisible(true);
                        kod.setVisible(true);
                        parol.setVisible(true);
                        check.setVisible(true);
                        zxc.setVisible(true);
                        pass.setVisible(true);
                        img2.setVisible(true);
                        asd.setVisible(true);
                    } else {
                        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0));
                        pauseTransition.setOnFinished(e -> log.setVisible(true));
                        PauseTransition pauseTransition1 = new PauseTransition(Duration.seconds(2));
                        pauseTransition1.setOnFinished(e -> log.setVisible(false));
                        pauseTransition.play();
                        pauseTransition1.play();
                    }
                }
            }
        });
    }
    public void enter() throws SQLException, ClassNotFoundException, IOException {
        String number = num.getText();
        String passw = pass.getText();
        ArrayList<String> n = db.Login();
        ArrayList<String> a = db.Password();
        int b =0;
        for (int i=0; i<n.size();i++) {
            if (number.equals(n.get(i))) {
                b = 1;
            }
        }
        int z =0;
        int g =0;
        for (int i=0; i<a.size();i++) {
            if (passw.equals(a.get(i))) {
                z = 1;
                g=i;
            }
        }
        if (b==1 && z==1) {
            if (asd.getText().equals(random)) {
                ArrayList<String> as = db.Role();
                ArrayList<String> fio = db.FIO();
             //   admin.firstName =fio.get(g);
              //  admin.dolgnost = as.get(g);
                seller.firstName =fio.get(g);
                seller.dolgnost = as.get(g);
              //  Employee1.firstName =fio.get(g);
              //  Employee1.dolgnost = as.get(g);
                db.Update(num.getText());
                if (as.get(g).equals(2)) {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                    primaryStage.setTitle("Профиль");
                    primaryStage.getIcons().add(new Image("logo.png"));
                    primaryStage.setScene(new Scene(root, 600, 400));
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    Stage stage = (Stage) asd.getScene().getWindow();
                    stage.close();
                }else if(as.get(3).equals(3)){
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
                    primaryStage.setTitle("Профиль");
                    primaryStage.getIcons().add(new Image("logo.png"));
                    primaryStage.setScene(new Scene(root, 600, 400));
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    Stage stage = (Stage) asd.getScene().getWindow();
                    stage.close();
                } else {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("seller.fxml"));
                    primaryStage.setTitle("Профиль");
                    primaryStage.getIcons().add(new Image("logo.png"));
                    primaryStage.setScene(new Scene(root, 600, 400));
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    Stage stage = (Stage) asd.getScene().getWindow();
                    stage.close();
                }


            } else {
                random = new Random().ints(8, 0, symbols.length())
                        .mapToObj(symbols::charAt)
                        .map(Object::toString)
                        .collect(Collectors.joining());
                System.out.println(random);
                PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0));
                pauseTransition.setOnFinished(e -> num1.setVisible(true));
                PauseTransition pauseTransition1 = new PauseTransition(Duration.seconds(2));
                pauseTransition1.setOnFinished(e -> num1.setVisible(false));
                pauseTransition.play();
                pauseTransition1.play();

            }
        }
    }

    public void zxc(MouseEvent mouseEvent) {
        random = new Random().ints(8, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println(random);
    }

    public void clear(ActionEvent actionEvent) {
        asd.setText("");
        num.setText("");
        zxc.setText("");
    }

    public void set(ActionEvent actionEvent) {
        if(check.isSelected()){
            zxc.setText(pass.getText());
            zxc.setVisible(true);
            pass.setVisible(false);
        }else {
            pass.setText(zxc.getText());
            pass.setVisible(true);
            zxc.setVisible(false);
        }
    }
}