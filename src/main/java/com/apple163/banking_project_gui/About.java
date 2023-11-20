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

public class About
{
    public About()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("/resources/Logo.png");
        Image icon = new Image(System.getProperty("user.dir") + "/resources/Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("ABOUT");
        Text body1 = new Text();
        Text body2 = new Text();
        Text body3 = new Text();
        Text body4 = new Text();
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        TextFlow textFlow = new TextFlow();
        TextFlow textFlow1 = new TextFlow();
        TextFlow textFlow2 = new TextFlow();
        TextFlow textFlow3 = new TextFlow();
        TextFlow textFlow4 = new TextFlow();

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);
        body1.setFill(Color.rgb(82, 183, 136));
        body1.setFont(Font.font("Unispace", 25));
        body1.setText("This Computer Applications Project for the year 2023-2024\nwas created by a team of students, Nikunj Negi and Ben Gary Leo, led by Aaron Vinu Mathew\n");
        body2.setFill(Color.rgb(82, 183, 136));
        body2.setFont(Font.font("Unispace", 25));
        body2.setText("The complete credits for the project can be found under the 'credits' button\n");
        body3.setFill(Color.rgb(82, 183, 136));
        body3.setFont(Font.font("Unispace", 25));
        body3.setText("The project was created using JavaFX and Java 16.0.1\nbut is backward compatible upto Java 8\n");
        body4.setFill(Color.rgb(82, 183, 136));
        body4.setFont(Font.font("Unispace", 25));
        body4.setText("The source code is also available on GitHub at:\nhttps://github.com/Apple-User-163/Banking_Project_GUI");
        textFlow1.getChildren().addAll(body1);
        textFlow1.setTextAlignment(TextAlignment.CENTER);
        textFlow1.setLineSpacing(10);
        textFlow2.getChildren().addAll(body2);
        textFlow2.setTextAlignment(TextAlignment.CENTER);
        textFlow2.setLineSpacing(10);
        textFlow3.getChildren().addAll(body3);
        textFlow3.setTextAlignment(TextAlignment.CENTER);
        textFlow3.setLineSpacing(10);
        textFlow4.getChildren().addAll(body4);
        textFlow4.setTextAlignment(TextAlignment.CENTER);
        textFlow4.setLineSpacing(10);
        textFlow.getChildren().add(textFlow1);
        textFlow.getChildren().add(new Text("\n"));
        textFlow.getChildren().add(textFlow2);
        textFlow.getChildren().add(new Text("\n"));
        textFlow.getChildren().add(textFlow3);
        textFlow.getChildren().add(new Text("\n"));
        textFlow.getChildren().add(textFlow4);
        textFlow.setLayoutX(100);
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
}