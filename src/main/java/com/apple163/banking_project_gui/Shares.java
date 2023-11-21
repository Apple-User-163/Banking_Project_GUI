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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class Shares
{
    JSONArray updater;
    public Shares()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Group root = new Group();
        Scene scene = new Scene(root);
        Image logo = new Image("\\resources\\Logo.png");
        Image icon = new Image("\\resources\\Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("SHARES");
        Text sub_sub_title = new Text("YOUR SHARES");
        Text msft = new Text();
        Text aapl = new Text();
        Text intc = new Text();
        Text amd = new Text();
        Text nvda = new Text();
        Text googl = new Text();
        Text error = new Text();
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        Button buy = new Button("BUY SHARES");
        Button sell = new Button("SELL SHARES");
        Button confirm = new Button("BUY");
        ComboBox<String> comboBox = new ComboBox<>();
        TextField number = new TextField();
        JSONParser parser = new JSONParser();
        JSONArray shares;
        Object g_obj;
        try {
            try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\resources\\json\\user_data.json"))
            {
                g_obj = parser.parse(reader);
            }
            updater = (JSONArray) g_obj;
            shares = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + "\\resources\\json\\user_data.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject sh_ud = (JSONObject) updater.get(Login.user_id);
        JSONObject obj = (JSONObject) shares.get(Login.user_id);

        long msft_shares = (long) obj.get("MSFT");
        long aapl_shares = (long) obj.get("AAPL");
        long intc_shares = (long) obj.get("INTC");
        long amd_shares = (long) obj.get("AMD");
        long nvda_shares = (long) obj.get("NVDA");
        long googl_shares = (long) obj.get("GOOGL");
        double balance = (double) obj.get("Balance");

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);
        sub_sub_title.setFill(Color.rgb(82, 183, 136));
        sub_sub_title.setFont(Font.font("Unispace", 25));
        sub_sub_title.setX(100);
        sub_sub_title.setY(180);
        msft.setFill(Color.rgb(82, 183, 136));
        msft.setFont(Font.font("Unispace", 30));
        msft.setX(270);
        msft.setY(280);
        aapl.setFill(Color.rgb(82, 183, 136));
        aapl.setFont(Font.font("Unispace", 30));
        aapl.setX(270);
        aapl.setY(430);
        googl.setFill(Color.rgb(82, 183, 136));
        googl.setFont(Font.font("Unispace", 30));
        googl.setX(670);
        googl.setY(280);
        intc.setFill(Color.rgb(82, 183, 136));
        intc.setFont(Font.font("Unispace", 30));
        intc.setX(670);
        intc.setY(430);
        amd.setFill(Color.rgb(82, 183, 136));
        amd.setFont(Font.font("Unispace", 30));
        amd.setX(1120);
        amd.setY(280);
        nvda.setFill(Color.rgb(82, 183, 136));
        nvda.setFont(Font.font("Unispace", 30));
        nvda.setX(1120);
        nvda.setY(430);
        msft.setText("MSFT: " + msft_shares);
        aapl.setText("AAPL: " + aapl_shares);
        intc.setText("INTC: " + intc_shares);
        amd.setText("AMD: " + amd_shares);
        nvda.setText("NVDA: " + nvda_shares);
        googl.setText("GOOGL: " + googl_shares);
        error.setFill(Color.RED);
        error.setFont(Font.font("Unispace", 20));
        error.setX(500);
        error.setY(610);

        confirm.setLayoutX(500);
        confirm.setLayoutY(650);
        confirm.setPrefSize(500, 60);
        confirm.setFont(Font.font("Unispace", 20));
        confirm.setTextFill(Color.rgb(82, 183, 136));
        confirm.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        comboBox.setEditable(false);
        comboBox.setLayoutX(500);
        comboBox.setLayoutY(400);
        comboBox.setPrefSize(500, 60);
        comboBox.setPromptText("Company");
        comboBox.getItems().addAll("MSFT", "AAPL", "INTC", "AMD", "NVDA", "GOOGL");

        number.setLayoutX(500);
        number.setLayoutY(500);
        number.setPrefSize(500, 60);
        number.setPromptText("Number of shares");
        number.setFont(Font.font("Unispace", 20));
        number.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");

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

        confirm.setOnMouseEntered((MouseEvent event) -> {
            confirm.setTextFill(Color.rgb(1, 33, 24));
            confirm.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        confirm.setOnMouseExited((MouseEvent event) -> {
            confirm.setTextFill(Color.rgb(82, 183, 136));
            confirm.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
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

        buy.setLayoutX(500);
        buy.setLayoutY(600);
        buy.setPrefSize(240, 60);
        buy.setFont(Font.font("Unispace", 20));
        buy.setTextFill(Color.rgb(82, 183, 136));
        buy.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        buy.setOnMouseEntered((MouseEvent event) -> {
            buy.setTextFill(Color.rgb(1, 33, 24));
            buy.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        buy.setOnMouseExited((MouseEvent event) -> {
            buy.setTextFill(Color.rgb(82, 183, 136));
            buy.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

        sell.setLayoutX(760);
        sell.setLayoutY(600);
        sell.setPrefSize(240, 60);
        sell.setFont(Font.font("Unispace", 20));
        sell.setTextFill(Color.rgb(82, 183, 136));
        sell.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        sell.setOnMouseEntered((MouseEvent event) -> {
            sell.setTextFill(Color.rgb(1, 33, 24));
            sell.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        sell.setOnMouseExited((MouseEvent event) -> {
            sell.setTextFill(Color.rgb(82, 183, 136));
            sell.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

        root.getChildren().add(buy);
        root.getChildren().add(sell);
        root.getChildren().add(msft);
        root.getChildren().add(aapl);
        root.getChildren().add(intc);
        root.getChildren().add(amd);
        root.getChildren().add(nvda);
        root.getChildren().add(googl);
        root.getChildren().add(sub_sub_title);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();

        buy.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(buy);
            root.getChildren().remove(sell);
            sub_sub_title.setText("MARKET VALUES");
            msft.setY(230);
            aapl.setY(340);
            googl.setY(230);
            intc.setY(340);
            amd.setY(230);
            nvda.setY(340);
            msft.setFont(Font.font("Unispace", 25));
            aapl.setFont(Font.font("Unispace", 25));
            googl.setFont(Font.font("Unispace", 25));
            intc.setFont(Font.font("Unispace", 25));
            amd.setFont(Font.font("Unispace", 25));
            nvda.setFont(Font.font("Unispace", 25));
            double msft_price = val(msft, 37300.32, 15234.95, "MSFT: ");
            double aapl_price = val(aapl, 25425.44, 8425.51, "AAPL: ");
            double googl_price = val(googl, 18407.76, 4682.58, "GOOGL: ");
            double intc_price = val(intc, 11499.57, 532.68, "INTC: ");
            double amd_price = val(amd, 12822.34, 4089.96, "AMD: ");
            double nvda_price = val(nvda, 45132.83, 27498.39, "NVDA: ");

            confirm.setOnAction((ActionEvent e) -> {

                if (comboBox.getValue() == null || number.getText().isEmpty() || number.getText().trim().isEmpty()) {
                    error.setText("Please fill all the fields");
                } else {
                    error.setText("");
                    try {
                        long num = Long.parseLong(number.getText());
                        double price = 0;
                        int dividend = 0;
                        double nv = 0;
                        switch (comboBox.getValue())
                        {
                            case "MSFT": price = msft_price; dividend = 8; nv = 300; break;
                            case "AAPL": price = aapl_price; dividend = 12; nv = 100; break;
                            case "GOOGL": price = googl_price; dividend = 5; nv = 500; break;
                            case "INTC": price = intc_price; dividend = 14; nv = 50; break;
                            case "AMD": price = amd_price; dividend = 7; nv = 325; break;
                            case "NVDA": price = nvda_price; dividend = 3; nv = 1000; break;
                            default: break;
                        }
                        price *= num;
                        if (balance >= price)
                        {
                            root.getChildren().remove(confirm);
                            root.getChildren().remove(comboBox);
                            root.getChildren().remove(number);
                            root.getChildren().remove(error);
                            root.getChildren().remove(intc);
                            root.getChildren().remove(amd);
                            root.getChildren().remove(nvda);
                            root.getChildren().remove(msft);
                            root.getChildren().remove(aapl);
                            root.getChildren().remove(googl);
                            sub_sub_title.setText("BUY SHARES");
                            Text t_1 = new Text();
                            Text t_2 = new Text();
                            Text t_3 = new Text();
                            t_1.setFill(Color.rgb(82, 183, 136));
                            t_1.setFont(Font.font("Unispace", 25));
                            t_2.setFill(Color.rgb(82, 183, 136));
                            t_2.setFont(Font.font("Unispace", 25));
                            t_3.setFill(Color.rgb(82, 183, 136));
                            t_3.setFont(Font.font("Unispace", 25));
                            if (num == 1)
                                t_1.setText("Bought " + num + " share of " + comboBox.getValue() + "\n");
                            else
                                t_1.setText("Bought " + num + " shares of " + comboBox.getValue() + "\n");
                            t_2.setText(comboBox.getValue() + " distributes an annual dividend of " + dividend + "% on the nominal value of \u20B9" + nv + "\n");
                            t_3.setText("The annual dividend is \u20B9" + (num * nv * dividend) / 100);

                            TextFlow textFlow = new TextFlow();
                            textFlow.getChildren().addAll(t_1, t_2, t_3);
                            textFlow.setTextAlignment(TextAlignment.CENTER);
                            textFlow.setLineSpacing(50);
                            textFlow.setLayoutX(200);
                            textFlow.setLayoutY(350);
                            root.getChildren().add(textFlow);

                            String round = String.format("%.2f", (balance - price));
                            price = Double.parseDouble(round);

                            sh_ud.put("Balance", price);
                            sh_ud.put(comboBox.getValue(), num + (long) obj.get(comboBox.getValue()) );
                            try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "\\resources\\json\\user_data.json")) {
                                file.write(updater.toJSONString());
                            } catch (IOException e_) {
                                e_.printStackTrace();
                            }
                        }
                        else
                        {
                            error.setText("Insufficient Funds");
                        }
                    }
                    catch (NumberFormatException q) {
                        error.setText("Please enter valid values");
                    }
                }
            });
            root.getChildren().add(comboBox);
            root.getChildren().add(confirm);
            root.getChildren().add(number);
            root.getChildren().add(error);
            scene.getStylesheets().add("/resources/com/apple163/banking_project_gui/dropdown.css");
        });
        sell.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(buy);
            root.getChildren().remove(sell);
            sub_sub_title.setText("MARKET VALUES");
            msft.setY(230);
            aapl.setY(340);
            googl.setY(230);
            intc.setY(340);
            amd.setY(230);
            nvda.setY(340);
            msft.setFont(Font.font("Unispace", 25));
            aapl.setFont(Font.font("Unispace", 25));
            googl.setFont(Font.font("Unispace", 25));
            intc.setFont(Font.font("Unispace", 25));
            amd.setFont(Font.font("Unispace", 25));
            nvda.setFont(Font.font("Unispace", 25));
            double msft_price = val(msft, 37300.32, 15234.95, "MSFT: ");
            double aapl_price = val(aapl, 25425.44, 8425.51, "AAPL: ");
            double googl_price = val(googl, 18407.76, 4682.58, "GOOGL: ");
            double intc_price = val(intc, 11499.57, 532.68, "INTC: ");
            double amd_price = val(amd, 12822.34, 4089.96, "AMD: ");
            double nvda_price = val(nvda, 45132.83, 27498.39, "NVDA: ");
            confirm.setText("SELL");
            confirm.setOnAction((ActionEvent e) -> {

                if (comboBox.getValue() == null || number.getText().isEmpty() || number.getText().trim().isEmpty()) {
                    error.setText("Please fill all the fields");
                } else {
                    error.setText("");
                    try {
                        long num = Long.parseLong(number.getText());
                        double s_price = 0;
                        switch (comboBox.getValue())
                        {
                            case "MSFT": s_price = msft_price;
                                break;
                            case "AAPL": s_price = aapl_price;
                                break;
                            case "GOOGL": s_price = googl_price;
                                break;
                            case "INTC": s_price = intc_price;
                                break;
                            case "AMD": s_price = amd_price;
                                break;
                            case "NVDA": s_price = nvda_price;
                                break;
                            default: break;
                        }
                        long l_num = (long) obj.get(comboBox.getValue());
                        s_price *= num;
                        if (l_num >= num)
                        {
                            root.getChildren().remove(msft);
                            root.getChildren().remove(aapl);
                            root.getChildren().remove(googl);
                            root.getChildren().remove(confirm);
                            root.getChildren().remove(comboBox);
                            root.getChildren().remove(number);
                            root.getChildren().remove(error);
                            root.getChildren().remove(intc);
                            root.getChildren().remove(amd);
                            root.getChildren().remove(nvda);
                            sub_sub_title.setText("SELL SHARES");
                            Text t_1 = new Text();
                            Text t_2 = new Text();
                            Text t_3 = new Text();
                            t_1.setFill(Color.rgb(82, 183, 136));
                            t_1.setFont(Font.font("Unispace", 25));
                            t_2.setFill(Color.rgb(82, 183, 136));
                            t_2.setFont(Font.font("Unispace", 25));
                            t_3.setFill(Color.rgb(82, 183, 136));
                            t_3.setFont(Font.font("Unispace", 25));
                            if (num == 1)
                                t_1.setText("Sold " + num + " share of " + comboBox.getValue() + " for \u20B9" + s_price/num + "\n");
                            else
                                t_1.setText("Sold " + num + " shares of " + comboBox.getValue() + " for \u20B9" + s_price/num + "\n");
                            t_2.setText("\u20B9" + s_price + " credited to your account" + "\n");
                            if (l_num - num == 1)
                                t_3.setText(l_num - num + " share of " + comboBox.getValue() + " is left in your account \n");
                            else
                                t_3.setText(l_num - num + " shares of " + comboBox.getValue() + " are left in your account \n");

                            String round = String.format("%.2f", (balance + s_price));
                            s_price = Double.parseDouble(round);

                            sh_ud.put("Balance", s_price);
                            sh_ud.put(comboBox.getValue(), l_num - num);
                            try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "\\resources\\json\\user_data.json")) {
                                file.write(updater.toJSONString());
                            } catch (IOException e_) {
                                e_.printStackTrace();
                            }
                            TextFlow textFlow = new TextFlow();
                            textFlow.getChildren().addAll(t_1, t_2, t_3);
                            textFlow.setTextAlignment(TextAlignment.CENTER);
                            textFlow.setLineSpacing(50);
                            textFlow.setLayoutX(450);
                            textFlow.setLayoutY(300);
                            root.getChildren().add(textFlow);
                        }
                        else
                        {
                            error.setText("Insufficient Shares");
                        }
                    }
                    catch (NumberFormatException q) {
                        error.setText("Please enter valid values");
                    }
                }
            });
            root.getChildren().add(comboBox);
            root.getChildren().add(confirm);
            root.getChildren().add(number);
            root.getChildren().add(error);
            scene.getStylesheets().add("/resources/com/apple163/banking_project_gui/dropdown.css");
        });
    }
    private double val(Text text, double max, double min, String name) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double tem_price = (Math.random() * (max-min)) + min;
        String formattedPrice = decimalFormat.format(tem_price);
        String head = name + "\u20B9";
        text.setText(head + formattedPrice);
        return Double.parseDouble(formattedPrice);
    }
}