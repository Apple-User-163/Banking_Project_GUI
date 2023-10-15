package com.apple163.banking_project_gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        try {
            StackPane stackPane = new StackPane();
            Group root = new Group();
            Button about_btn = new Button("ABOUT");
            Button credit_btn = new Button("CREDITS");
            Button login_btn = new Button("LOGIN");
            Button fd_btn = new Button("FIXED DEPOSIT");
            Button rd_btn = new Button("RECURRING DEPOSIT");
            Button loan_btn = new Button("LOANS");
            Button shares_btn = new Button("SHARES");
            Button insurance_btn = new Button("INSURANCE");
            Button calculator_btn = new Button("CALCULATORS");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent fxmlRoot = loader.load();
            Scene scene = new Scene(root);
            Image logo = new Image("Logo.png");
            Image icon = new Image("Icon.png");
            Text title = new Text("THE BANKING PROJECT");


            title.setFill(Color.rgb(82, 183, 136));
            title.setFont(Font.font("Unispace", 22));
            title.setX(60);
            title.setY(36);
            ImageView imageView = new ImageView(logo);
            imageView.setFitHeight(50);
            imageView.setFitWidth(40);
            imageView.setX(10);
            imageView.setY(2);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);

            about_btn.setLayoutX(1074);
            menu_bttn(about_btn);
            credit_btn.setLayoutX(1224);
            menu_bttn(credit_btn);
            login_btn.setLayoutX(1374);
            menu_bttn(login_btn);

            scene.setFill(new RadialGradient(
                    1, 1, 1, 1, 1, true,
                    CycleMethod.NO_CYCLE,
                    new Stop(0, Color.rgb(4, 116, 114)),
                    new Stop(1, Color.rgb(1, 33, 24)))
            );

            primaryStage.getIcons().add(icon);
            primaryStage.setWidth(1533);
            primaryStage.setHeight(800);
            primaryStage.setTitle("The Banking Project");
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitHint("");
            primaryStage.setResizable(false);

            root.getChildren().add(login_btn);
            root.getChildren().add(credit_btn);
            root.getChildren().add(about_btn);
            root.getChildren().add(stackPane);
            root.getChildren().add(fxmlRoot);
            root.getChildren().add(title);
            root.getChildren().add(imageView);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void main_bttn (Button button) {
        button.setFont(Font.font("Unispace", 14));
        button.setPrefSize(200, 100);
        button.setTextFill(Color.rgb(72, 191, 227));
        button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(72, 191, 227); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        button.setOnMouseEntered((javafx.scene.input.MouseEvent event) -> {
            button.setTextFill(Color.rgb(1, 33, 24));
            button.setStyle("-fx-background-color: rgb(83, 144, 217); -fx-border-color: rgb(83, 144, 217); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        button.setOnMouseExited((javafx.scene.input.MouseEvent event) -> {
            button.setTextFill(Color.rgb(72, 191, 227));
            button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(72, 191, 227); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
    }
    public void menu_bttn(Button button) {
        button.setLayoutY(14);
        button.setPrefSize(126, 26);
        button.setFont(Font.font("Unispace", 12));
        button.setTextFill(Color.rgb(82, 183, 136));
        button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        button.setOnMouseEntered((javafx.scene.input.MouseEvent event) -> {
            button.setTextFill(Color.rgb(1, 33, 24));
            button.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        button.setOnMouseExited((javafx.scene.input.MouseEvent event) -> {
            button.setTextFill(Color.rgb(82, 183, 136));
            button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

        if (button.getText().equals("CREDITS"))
        {
            button.setOnAction((ActionEvent event) -> {
                try {
                    //enter the code to open the credits page here
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        else if (button.getText().equals("ABOUT"))
        {
            button.setOnAction((ActionEvent event) -> {
                try {
                    //enter the code to open the about page here
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        else if (button.getText().equals("LOGIN"))
        {
            button.setOnAction((ActionEvent event) -> {
                try {
                    //enter the code to open the login page here
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}