package com.apple163.banking_project_gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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

    @FXML
    private void onHelloButtonClick(ActionEvent event)
    {
        System.out.println("Hello!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane gridPane = new GridPane();
        Group root = new Group();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent fxmlRoot = loader.load();
        Scene scene = new Scene(root,1300, 700);
        Image logo = new Image("Logo.png");
        Image icon = new Image("Icon.png");
        Text title = new Text("THE BANKING PROJECT");

        ColumnConstraints coli1 = new ColumnConstraints();
        coli1.setPercentWidth(50);
        ColumnConstraints coli2 = new ColumnConstraints();
        coli2.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(coli1, coli2);

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 22));
        title.setX(60);
        title.setY(36);
        ImageView imageView = new ImageView(logo);
        imageView.setFitHeight(50);
        imageView.setFitWidth(40);
        imageView.setX(10);
        imageView.setY(2);

        scene.setFill(new RadialGradient(
                1, 1, 1, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(4, 116, 114)),
                new Stop(1, Color.rgb(1, 33, 24)))
        );

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Banking Project");
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");

        root.getChildren().add(gridPane);
        root.getChildren().add(fxmlRoot);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}