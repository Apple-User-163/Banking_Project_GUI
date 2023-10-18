package com.apple163.banking_project_gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
import javafx.stage.Stage;

public class Login
{

    public Login()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("Logo.png");
        Image icon = new Image("Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("LOGIN");
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        Button login_btn = new Button("SIGN IN");
        Button signup_btn = new Button("SIGN UP");
        TextField username = new TextField();
        PasswordField password = new PasswordField();

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);

        username.setLayoutX(500);
        username.setLayoutY(300);
        username.setPrefSize(500, 60);
        username.setPromptText("Username");
        username.setFont(Font.font("Unispace", 20));
        username.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");
        password.setLayoutX(500);
        password.setLayoutY(400);
        password.setPrefSize(500, 60);
        password.setPromptText("Password");
        password.setFont(Font.font("Unispace", 20));
        password.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");

        login_btn.setLayoutX(500);
        login_btn.setLayoutY(500);
        login_btn.setPrefSize(240, 60);
        login_btn.setFont(Font.font("Unispace", 20));
        login_btn.setTextFill(Color.rgb(82, 183, 136));
        login_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        button(login_btn);

        signup_btn.setLayoutX(760);
        signup_btn.setLayoutY(500);
        signup_btn.setPrefSize(240, 60);
        signup_btn.setFont(Font.font("Unispace", 20));
        signup_btn.setTextFill(Color.rgb(82, 183, 136));
        signup_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        button(signup_btn);

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

        root.getChildren().add(login_btn);
        root.getChildren().add(signup_btn);
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void button (Button button)
    {
        button.setOnMouseEntered((MouseEvent event) -> {
            button.setTextFill(Color.rgb(1, 33, 24));
            button.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        button.setOnMouseExited((MouseEvent event) -> {
            button.setTextFill(Color.rgb(82, 183, 136));
            button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
    }
}