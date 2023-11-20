package com.apple163.banking_project_gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Currency
{
    public Currency()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("Logo.png");
        Image icon = new Image("Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("CURRENCY CONVERSION");
        Text error = new Text();
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        Button convert_btn = new Button("CONVERT");
        TextField amount = new TextField();
        ComboBox<String> currency = new ComboBox<>();

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

        amount.setLayoutX(500);
        amount.setLayoutY(300);
        amount.setPrefSize(500, 60);
        amount.setFont(Font.font("Unispace", 20));
        amount.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-text-fill: rgb(82, 183, 136); -fx-border-radius: 5px; -fx-background-radius: 5px;");
        amount.setPromptText("Enter amount in INR");

        currency.setLayoutX(500);
        currency.setLayoutY(400);
        currency.setPrefSize(500, 60);
        currency.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-text-fill: rgb(82, 183, 136); -fx-border-radius: 5px; -fx-background-radius: 5px;");
        currency.setPromptText("Select currency");
        currency.getItems().addAll("USD", "EUR", "GBP", "AUD", "CAD", "SGD", "JPY", "CNY", "NZD", "THB", "HKD", "MXN", "SEK", "CHF", "ZAR", "SAR", "AED", "BRL");

        convert_btn.setLayoutX(500);
        convert_btn.setLayoutY(550);
        convert_btn.setPrefSize(500, 60);
        convert_btn.setFont(Font.font("Unispace", 20));
        convert_btn.setTextFill(Color.rgb(82, 183, 136));
        convert_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        convert_btn.setOnMouseEntered((MouseEvent event) -> {
            convert_btn.setTextFill(Color.rgb(1, 33, 24));
            convert_btn.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        convert_btn.setOnMouseExited((MouseEvent event) -> {
            convert_btn.setTextFill(Color.rgb(82, 183, 136));
            convert_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        root.getChildren().add(error);
        convert_btn.setOnAction((ActionEvent event) -> {
            try {
                if (amount.getText().trim().isEmpty() || currency.getValue() == null)
                    throw new NumberFormatException();
                else
                {
                    BigDecimal amt = BigDecimal.valueOf(Double.parseDouble(amount.getText()));
                    String cur = currency.getValue();
                    BigDecimal val = calculate(amt, cur);
                    val = val.setScale(2, BigDecimal.ROUND_HALF_UP);
                    Text result = new Text("The converted amount is " + val + " " + cur + "\n");
                    Text rate = new Text("The conversion rate is " + val.divide(amt, 2, BigDecimal.ROUND_HALF_UP));
                    result.setFill(Color.rgb(82, 183, 136));
                    result.setFont(Font.font("Unispace", 25));
                    rate.setFill(Color.rgb(82, 183, 136));
                    rate.setFont(Font.font("Unispace", 25));
                    TextFlow textFlow = new TextFlow(result, rate);
                    textFlow.setTextAlignment(TextAlignment.CENTER);
                    textFlow.setLayoutX(500);
                    textFlow.setLayoutY(350);
                    textFlow.setLineSpacing(50);
                    root.getChildren().remove(currency);
                    root.getChildren().remove(amount);
                    root.getChildren().remove(convert_btn);
                    root.getChildren().add(textFlow);
                }
            }
            catch (NumberFormatException e) {
                if (amount.getText().trim().isEmpty() || currency.getValue() == null)
                    error.setText("Please enter all the details");
                else
                    error.setText("Please enter a valid amount");
            }
        });
        root.getChildren().add(currency);
        root.getChildren().add(amount);
        root.getChildren().add(convert_btn);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("dropdown.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    BigDecimal calculate (BigDecimal amt, String cur)
    {
        BigDecimal converted_amt = new BigDecimal(0);
        double rate;
        if (cur.equals("USD")) {
            rate = variable(0.015, 0.01);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("EUR")) {
            rate = variable(0.013, 0.009);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("GBP")) {
            rate = variable(0.0013, 0.0004);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("AUD")) {
            rate = variable(0.02, 0.015);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("CAD")) {
            rate = variable(0.02, 0.016);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("SGD")) {
            rate = variable(0.019, 0.013);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("JPY")) {
            rate = variable(2.0, 1.5);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("CNY")) {
            rate = variable(0.12, 0.053);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("NZD")) {
            rate = variable(0.023, 0.016);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("THB")) {
            rate = variable(0.5, 0.37);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("HKD")) {
            rate = variable(0.1, 0.079);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("MXN")) {
            rate = variable(0.3, 0.18);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("SEK")) {
            rate = variable(0.15, 0.06);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        } else if (cur.equals("CHF")) {
            rate = variable(0.02, 0.009);
            converted_amt = amt.multiply(BigDecimal.valueOf(rate));
        }
        return converted_amt;
    }
    double variable (double max, double min)
    {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double tem_price = (Math.random() * (max-min)) + min;
        String formattedPrice = decimalFormat.format(tem_price);
        return Double.parseDouble(formattedPrice);
    }
}