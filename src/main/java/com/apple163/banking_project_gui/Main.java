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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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

            about_btn.setLayoutX(1224);
            button(about_btn);

            credit_btn.setLayoutX(1374);
            button(credit_btn);

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

    public void button(Button button) {
        button.setLayoutY(14);
        button.setPrefSize(126, 26);
        button.setFont(Font.font("Unispace", 12));
        button.setTextFill(Color.rgb(82, 183, 136));
        button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        button.setOnMouseEntered((javafx.scene.input.MouseEvent event) -> {
            button.setTextFill(Color.rgb(1, 33, 24));
            button.setStyle("-fx-background-color: rgb(82, 183, 136); -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
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
    }
}