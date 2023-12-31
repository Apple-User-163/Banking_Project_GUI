package com.apple163.banking_project_gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.util.Objects;

public class FD
{
    Boolean tme_check = false;
    Boolean prin_check = false;
    public FD()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("Logo.png");
        Image icon = new Image("Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("FIXED DEPOSIT");
        Text error = new Text();
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        TextField principal = new TextField();
        TextField time = new TextField();
        ComboBox<String> comboBox = new ComboBox<>();
        Button calculate = new Button("CALCULATE");

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);
        error.setFont(Font.font("Unispace", 20));
        error.setY(610);
        error.setX(500);
        error.setFill(Color.RED);

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

        principal.setLayoutX(500);
        principal.setLayoutY(400);
        principal.setPrefSize(500, 60);
        principal.setPromptText("Monthly Deposit");
        principal.setFont(Font.font("Unispace", 20));
        principal.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");
        time.setLayoutX(500);
        time.setLayoutY(500);
        time.setPrefSize(500, 60);
        time.setPromptText("Time Period");
        time.setFont(Font.font("Unispace", 20));
        time.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");

        calculate.setLayoutX(500);
        calculate.setLayoutY(650);
        calculate.setPrefSize(500, 60);
        calculate.setFont(Font.font("Unispace", 20));
        calculate.setTextFill(Color.rgb(82, 183, 136));
        calculate.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        calculate.setOnMouseEntered((MouseEvent event) -> {
            calculate.setTextFill(Color.rgb(1, 33, 24));
            calculate.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        calculate.setOnMouseExited((MouseEvent event) -> {
            calculate.setTextFill(Color.rgb(82, 183, 136));
            calculate.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        calculate.setOnAction((ActionEvent event) -> {
            error.setText("");
            int upper, lower;

            if (time.getText().isEmpty() || principal.getText().isEmpty() || comboBox.getValue() == null) {
                error.setText("PLEASE FILL ALL THE FIELDS");
            }
            else{
                String type = comboBox.getValue();
                switch (type) {
                    case "₹70,001 to ₹1,00,000; at 6%; for 1 to 3 years": upper = 3; break;
                    case "₹40,001 to ₹70,000; at 8%; for 1 to 5 years" : upper = 5; break;
                    case "₹10,001 to ₹40,000; at 10%; for 1 to 10 years" : upper = 10; break;
                    case "₹100 to ₹10,000; at 12%; for 1 to 10 years" : upper = 10; break;
                    default : upper = 0;
                }
                if (Integer.parseInt(time.getText()) > upper || Integer.parseInt(time.getText()) < 1) {
                    error.setText("PLEASE ENTER A VALID TIME PERIOD");
                    tme_check = false;
                }
                else {
                    tme_check = true;
                }
                switch (type) {
                    case "₹70,001 to ₹1,00,000; at 6%; for 1 to 3 years" : {
                        upper = 100000;
                        lower = 70001;
                        break;
                    }
                    case "₹40,001 to ₹70,000; at 8%; for 1 to 5 years" : {
                        upper = 70000;
                        lower = 40001;
                        break;
                    }
                    case "₹10,001 to ₹40,000; at 10%; for 1 to 10 years" : {
                        upper = 40000;
                        lower = 10001;
                        break;
                    }
                    case "₹100 to ₹10,000; at 12%; for 1 to 10 years" : {
                        upper = 10000;
                        lower = 100;
                        break;
                    }
                    default : lower = 0;
                }
                if (Integer.parseInt(principal.getText()) > upper || Integer.parseInt(principal.getText()) < lower) {
                    error.setText("PLEASE ENTER A VALID PRINCIPAL AMOUNT");
                    prin_check = false;
                }
                else {
                    prin_check = true;
                }

                if (tme_check && prin_check) {
                    error.setText("");
                    int pri = Integer.parseInt(principal.getText());
                    int tim = Integer.parseInt(time.getText());
                    double amount = getAmount(type, pri, tim);
                    double interest = amount - pri;
                    root.getChildren().removeAll(principal, time, comboBox, calculate);
                    Text amount_text = new Text("Amount: ₹" + amount);
                    Text interest_text = new Text("Interest: ₹" + interest);
                    amount_text.setFont(Font.font("Unispace", 30));
                    amount_text.setFill(Color.rgb(82, 183, 136));
                    amount_text.setX(500);
                    amount_text.setY(400);
                    interest_text.setFont(Font.font("Unispace", 30));
                    interest_text.setFill(Color.rgb(82, 183, 136));
                    interest_text.setX(500);
                    interest_text.setY(500);
                    root.getChildren().addAll(amount_text, interest_text);
                }
            }
        });

        comboBox.setEditable(false);
        comboBox.setLayoutX(500);
        comboBox.setLayoutY(300);
        comboBox.setPrefSize(500, 60);
        comboBox.setPromptText("Investment Options");
        comboBox.getItems().addAll("₹70,001 to ₹1,00,000; at 6%; for 1 to 3 years", "₹40,001 to ₹70,000; at 8%; for 1 to 5 years", "₹10,001 to ₹40,000; at 10%; for 1 to 10 years", "₹100 to ₹10,000; at 12%; for 1 to 10 years");

        root.getChildren().add(error);
        root.getChildren().add(calculate);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        root.getChildren().add(principal);
        root.getChildren().add(time);
        root.getChildren().add(comboBox);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("dropdown.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static double getAmount(String type, int pri, int tim) {
        int rate;
        switch (type) {
            case "₹70,001 to ₹1,00,000; at 6%; for 1 to 3 years" : rate = 6; break;
            case "₹40,001 to ₹70,000; at 8%; for 1 to 5 years" : rate = 8; break;
            case "₹10,001 to ₹40,000; at 10%; for 1 to 10 years" : rate = 10; break;
            case "₹100 to ₹10,000; at 12%; for 1 to 10 years" : rate = 12; break;
            default : rate = 0;
        }
        String round = String.format("%.2f", (pri + ((double) (pri * rate * tim) / 100)));
        return Double.parseDouble(round);
    }
}