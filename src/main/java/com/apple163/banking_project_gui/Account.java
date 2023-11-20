package com.apple163.banking_project_gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class Account
{
    JSONArray balance_array = new JSONArray();
    public static boolean flag = false;

    public Account()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("Logo.png");
        Image icon = new Image("Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("ACCOUNT");
        Text error = new Text();
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        TextField balance = new TextField();
        Button deposit = new Button("DEPOSIT");
        Button withdraw = new Button("WITHDRAW");
        Button sign_out = new Button("SIGN OUT");
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("user_data.json"))
        {
            balance_array = (JSONArray) parser.parse(reader);
        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }

        JSONObject updater = (JSONObject) balance_array.get(Login.user_id);

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);
        error.setFill(Color.rgb(255, 0, 0));
        error.setFont(Font.font("Unispace", 20));
        error.setX(500);
        error.setY(510);

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

        sign_out.setLayoutX(1224);
        sign_out.setLayoutY(14);
        sign_out.setPrefSize(126, 26);
        sign_out.setFont(Font.font("Unispace", 12));
        sign_out.setTextFill(Color.rgb(82, 183, 136));
        sign_out.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        sign_out.setOnMouseEntered((MouseEvent event) -> {
            sign_out.setTextFill(Color.rgb(1, 33, 24));
            sign_out.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        sign_out.setOnMouseExited((MouseEvent event) -> {
            sign_out.setTextFill(Color.rgb(82, 183, 136));
            sign_out.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

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

        deposit.setLayoutX(500);
        deposit.setLayoutY(550);
        deposit.setPrefSize(240, 60);
        deposit.setFont(Font.font("Unispace", 20));
        deposit.setTextFill(Color.rgb(82, 183, 136));
        deposit.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        deposit.setOnMouseEntered((MouseEvent event) -> {
            deposit.setTextFill(Color.rgb(1, 33, 24));
            deposit.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        deposit.setOnMouseExited((MouseEvent event) -> {
            deposit.setTextFill(Color.rgb(82, 183, 136));
            deposit.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

        withdraw.setLayoutX(760);
        withdraw.setLayoutY(550);
        withdraw.setPrefSize(240, 60);
        withdraw.setFont(Font.font("Unispace", 20));
        withdraw.setTextFill(Color.rgb(82, 183, 136));
        withdraw.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        withdraw.setOnMouseEntered((MouseEvent event) -> {
            withdraw.setTextFill(Color.rgb(1, 33, 24));
            withdraw.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        withdraw.setOnMouseExited((MouseEvent event) -> {
            withdraw.setTextFill(Color.rgb(82, 183, 136));
            withdraw.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

        balance.setLayoutX(500);
        balance.setLayoutY(400);
        balance.setPrefSize(500, 60);
        balance.setFont(Font.font("Unispace", 20));
        balance.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-text-fill: rgb(82, 183, 136); -fx-border-radius: 5px; -fx-background-radius: 5px;");
        balance.setPromptText("Enter Amount");
        Text text1 = new Text();
        text1.setFill(Color.rgb(82, 183, 136));
        text1.setFont(Font.font("Unispace", 25));
        Text text2 = new Text();
        text2.setFill(Color.rgb(82, 183, 136));
        text2.setFont(Font.font("Unispace", 25));
        TextFlow textFlow = new TextFlow(text1, text2);
        textFlow.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLayoutX(500);
        textFlow.setLayoutY(300);
        textFlow.setLineSpacing(50);

        withdraw.setOnAction((ActionEvent event) -> {
            try {
                BigDecimal amount = new BigDecimal(balance.getText());
                BigDecimal Balance = new BigDecimal(updater.get("Balance").toString());
                if (balance.getText().trim().isEmpty()) {
                    error.setText("Please enter an amount");
                } else {
                    if (amount.compareTo(Balance) > 0) {
                        error.setText("Insufficient Balance");
                    } else {
                        root.getChildren().remove(textFlow);
                        root.getChildren().remove(error);
                        root.getChildren().remove(balance);
                        root.getChildren().remove(deposit);
                        root.getChildren().remove(withdraw);
                        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
                        Balance = Balance.setScale(2, BigDecimal.ROUND_HALF_UP);
                        updater.put("Balance", Double.parseDouble(Balance.subtract(amount).toString()));
                        try (FileWriter file = new FileWriter("user_data.json")) {
                            file.write(balance_array.toJSONString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        text1.setText("Amount Withdrawn: " + amount + "\n");
                        text2.setText("New Balance: " + updater.get("Balance"));
                        root.getChildren().add(textFlow);
                    }
                }
            } catch (NumberFormatException e) {
                error.setText("Please enter a valid amount");
            }
        });
        deposit.setOnAction((ActionEvent event1) -> {
            try {
                BigDecimal amount1 = new BigDecimal(balance.getText());
                BigDecimal Balance1 = new BigDecimal(updater.get("Balance").toString());
                if (balance.getText().trim().isEmpty()) {
                    error.setText("Please enter an amount");
                } else {
                    root.getChildren().remove(textFlow);
                    root.getChildren().remove(error);
                    root.getChildren().remove(balance);
                    root.getChildren().remove(deposit);
                    root.getChildren().remove(withdraw);
                    amount1 = amount1.setScale(2, BigDecimal.ROUND_HALF_UP);
                    Balance1 = Balance1.setScale(2, BigDecimal.ROUND_HALF_UP);
                    updater.put("Balance", Double.parseDouble(Balance1.add(amount1).toString()));
                    try (FileWriter file = new FileWriter("user_data.json")) {
                        file.write(balance_array.toJSONString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    text1.setText("Amount Deposited: " + amount1 + "\n");
                    text2.setText("New Balance: " + updater.get("Balance"));
                    root.getChildren().add(textFlow);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter a valid amount");
            }
        });
        sign_out.setOnAction((ActionEvent event) -> {
            Login.user_id = -1;
            Login.signed_in = false;
            flag = true;
            new Main().start(new Stage());
            primaryStage.close();
        });
        primaryStage.setOnHidden(event -> {
            if (!flag)
            {
                new Main().start(new Stage());
            }
        });
        root.getChildren().add(sign_out);
        root.getChildren().add(error);
        root.getChildren().add(deposit);
        root.getChildren().add(withdraw);
        root.getChildren().add(balance);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}