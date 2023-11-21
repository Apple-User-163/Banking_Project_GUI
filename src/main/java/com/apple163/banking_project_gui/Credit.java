package com.apple163.banking_project_gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Credit
{
    public Credit()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("\\resources\\Logo.png");
        Image icon = new Image( "\\resources\\Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("CREDITS");
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        Text credit1 = new Text("Team Lead - Aaron Mathew\n");
        Text credit2 = new Text("UI Integration - Aaron Mathew\n");
        Text credit3 = new Text("UI Design - Aaron Mathew, Nikunj Negi\n");
        Text credit4 = new Text("Frontend - Aaron Mathew\n");
        Text credit5 = new Text("Backend - Aaron Mathew\n");
        Text credit6 = new Text("Paramenters - Ben Gary Leo, Nikunj Negi\n");
        Text credit7 = new Text("Testing - Aaron Mathew, Nikunj Negi\n");
        Text credit8 = new Text("Music - Sweden (Synthwave Remix) by Astrophysics");
        TextFlow textFlow = new TextFlow(credit1, credit2, credit3, credit4, credit5, credit6, credit7, credit8);

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);
        text(credit1);
        text(credit2);
        text(credit3);
        text(credit4);
        text(credit5);
        text(credit6);
        text(credit7);
        text(credit8);
        textFlow.setLayoutX(400);
        textFlow.setLayoutY(200);
        textFlow.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLineSpacing(50);

        imageView.setX(10);
        imageView.setY(5);
        imageView.setFitHeight(50);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        back_btn.setLayoutX(1374);
        back_btn.setLayoutY(14);
        back_btn.setPrefSize(126, 26);
        back_btn.setFont(Font.font("Unispace", 12));
        back_btn.setTextFill(Color.rgb(82, 183, 136));
        back_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        back_btn.setOnMouseEntered((MouseEvent event) -> {
            back_btn.setTextFill(Color.rgb(1, 33, 24));
            back_btn.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        back_btn.setOnMouseExited((MouseEvent event) -> {
            back_btn.setTextFill(Color.rgb(82, 183, 136));
            back_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        back_btn.setOnAction((ActionEvent event) -> primaryStage.close());

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

        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        root.getChildren().add(textFlow);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    void text(Text text)
    {
        text.setFill(Color.rgb(82, 183, 136));
        text.setFont(Font.font("Unispace", 25));
    }
}