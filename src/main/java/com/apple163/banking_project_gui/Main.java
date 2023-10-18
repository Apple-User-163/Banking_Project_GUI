package com.apple163.banking_project_gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
//import javafx.scene.text.TextAlignment;
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
            Button rd_btn = new Button("RECURRING  \nDEPOSIT");
            Button loan_btn = new Button("LOANS");
            Button shares_btn = new Button("SHARES");
            Button insurance_btn = new Button("INSURANCE");
            Button calculator_btn = new Button("CALCULATORS");
            /* FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent fxmlRoot = loader.load(); */
            Scene scene = new Scene(root);
            Image logo = new Image("Logo.png");
            Image icon = new Image("Icon.png");
            //Image fd = new Image("Fd.png");
            Image rd = new Image("Rd.png");
            //Image calculator = new Image("Cal.png");
            Image loan = new Image("Loan.png");
            //Image insurance = new Image("Insurance.png");
            //Image shares = new Image("Shares.png");
            Text title = new Text("THE BANKING PROJECT");
            Text sub_title = new Text("SERVICES");

            title.setFill(Color.rgb(82, 183, 136));
            title.setFont(Font.font("Unispace", 25));
            title.setX(60);
            title.setY(36);
            sub_title.setFill(Color.rgb(82, 183, 136));
            sub_title.setFont(Font.font("Unispace", 40));
            sub_title.setX(60);
            sub_title.setY(180);

            about_btn.setLayoutX(1074);
            menu_bttn(about_btn);
            credit_btn.setLayoutX(1224);
            menu_bttn(credit_btn);
            login_btn.setLayoutX(1374);
            menu_bttn(login_btn);

            fd_btn.setLayoutX(87);
            fd_btn.setLayoutY(247);
            main_bttn(fd_btn);
            rd_btn.setLayoutX(593);
            rd_btn.setLayoutY(247);
            main_bttn(rd_btn);
            loan_btn.setLayoutX(1101);
            loan_btn.setLayoutY(247);
            main_bttn(loan_btn);
            shares_btn.setLayoutX(87);
            shares_btn.setLayoutY(545);
            main_bttn(shares_btn);
            insurance_btn.setLayoutX(593);
            insurance_btn.setLayoutY(545);
            main_bttn(insurance_btn);
            calculator_btn.setLayoutX(1101);
            calculator_btn.setLayoutY(545);
            main_bttn(calculator_btn);

            ImageView imageView = new ImageView(logo);
            //ImageView fd_img = new ImageView(fd);
            ImageView rd_img = new ImageView(rd);
            //ImageView calculator_img = new ImageView(calculator);
            ImageView loan_img = new ImageView(loan);
            //ImageView insurance_img = new ImageView(insurance);
            //ImageView shares_img = new ImageView(shares);
            imageView.setX(10);
            imageView.setY(5);
            imageView.setFitHeight(50);
            imageView.setFitWidth(40);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);

            //Icons(fd_img, fd_btn);
            Icons(rd_img, rd_btn);
            Icons(loan_img, loan_btn);

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

            //root.getChildren().add(fd_img);
            root.getChildren().add(insurance_btn);
            root.getChildren().add(calculator_btn);
            root.getChildren().add(shares_btn);
            root.getChildren().add(loan_btn);
            root.getChildren().add(rd_btn);
            root.getChildren().add(fd_btn);
            root.getChildren().add(login_btn);
            root.getChildren().add(credit_btn);
            root.getChildren().add(about_btn);
            root.getChildren().add(stackPane);
            //root.getChildren().add(fxmlRoot);
            root.getChildren().add(sub_title);
            root.getChildren().add(title);
            root.getChildren().add(imageView);
            primaryStage.setScene(scene);
            primaryStage.show();

            fd_btn.setOnAction((ActionEvent event) -> {
                try {
                    new FD();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void main_bttn (Button button) {
        button.setFont(Font.font("Unispace", 22));
        button.setPrefSize(350, 150);
        button.setTextFill(Color.rgb(72, 191, 227));
        button.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
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
    public void Icons (ImageView view, Button button)
    {
        view.fitWidthProperty().bind(button.heightProperty().multiply(0.4));
        view.fitWidthProperty().bind(button.widthProperty().multiply(0.4));
        button.setGraphic(view);
        button.setGraphicTextGap(-10);
        button.setAlignment(Pos.BASELINE_LEFT);
        view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setCache(true);
        if (button.getText().equals("FIXED DEPOSIT"))
            button.setGraphicTextGap(0);
    }
}