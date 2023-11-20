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
import java.io.FileReader;
import java.math.BigDecimal;

public class Loan
{
    Group root = new Group();
    TextField loan_amount = new TextField();
    TextField loan_duration = new TextField();
    Text error = new Text("");
    public Loan()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(root);
        Image logo = new Image("/resources/Logo.png");
        Image icon = new Image(System.getProperty("user.dir") + "/resources/Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("LOANS");
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        Button personal_loan_btn = new Button("PERSONAL LOAN");
        Button home_loan_btn = new Button("HOME LOAN");
        Button vehicle_loan_btn = new Button("VEHICLE LOAN");
        Button education_loan_btn = new Button("EDUCATION LOAN");
        Button farm_loan_btn = new Button("FARM LOAN");
        Button business_loan_btn = new Button("BUSINESS LOAN");
        Button loan_btn = new Button("APPLY");

        personal_loan_btn.setLayoutX(87);
        personal_loan_btn.setLayoutY(247);
        bttn(personal_loan_btn);
        home_loan_btn.setLayoutX(593);
        home_loan_btn.setLayoutY(247);
        bttn(home_loan_btn);
        vehicle_loan_btn.setLayoutX(1101);
        vehicle_loan_btn.setLayoutY(247);
        bttn(vehicle_loan_btn);
        education_loan_btn.setLayoutX(87);
        education_loan_btn.setLayoutY(545);
        bttn(education_loan_btn);
        farm_loan_btn.setLayoutX(593);
        farm_loan_btn.setLayoutY(545);
        bttn(farm_loan_btn);
        business_loan_btn.setLayoutX(1101);
        business_loan_btn.setLayoutY(545);
        bttn(business_loan_btn);
        loan_btn.setLayoutX(500);
        loan_btn.setLayoutY(550);
        loan_btn.setPrefSize(500, 60);
        loan_btn.setFont(Font.font("Unispace", 20));
        loan_btn.setTextFill(Color.rgb(82, 183, 136));
        loan_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        loan_btn.setOnMouseEntered((MouseEvent event) -> {
            loan_btn.setTextFill(Color.rgb(1, 33, 24));
            loan_btn.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        loan_btn.setOnMouseExited((MouseEvent event) -> {
            loan_btn.setTextFill(Color.rgb(82, 183, 136));
            loan_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });

        loan_amount.setLayoutX(500);
        loan_amount.setLayoutY(300);
        loan_amount.setPrefSize(500, 60);
        loan_amount.setPromptText("Loan Amount");
        loan_amount.setFont(Font.font("Unispace", 20));
        loan_amount.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");
        loan_duration.setLayoutX(500);
        loan_duration.setLayoutY(400);
        loan_duration.setPrefSize(500, 60);
        loan_duration.setPromptText("Time Period");
        loan_duration.setFont(Font.font("Unispace", 20));
        loan_duration.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");

        personal_loan_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(personal_loan_btn);
            root.getChildren().remove(home_loan_btn);
            root.getChildren().remove(vehicle_loan_btn);
            root.getChildren().remove(education_loan_btn);
            root.getChildren().remove(farm_loan_btn);
            root.getChildren().remove(business_loan_btn);
            root.getChildren().add(loan_amount);
            root.getChildren().add(loan_duration);
            root.getChildren().add(loan_btn);
            sub_title.setText("PERSONAL LOAN");
            root.getChildren().add(error);
            loan_btn.setOnAction((ActionEvent event1) -> {
                try {
                    double sum = Double.parseDouble(loan_amount.getText());
                    int time = Integer.parseInt(loan_duration.getText());
                    if (sum < 10000)
                    {
                        error.setText("Please enter a loan amount greater than \u20B910,000");
                    } else if (time < 1 || time > 20)
                    {
                        error.setText("Please enter a time period between 1 and 20 years");
                    } else
                    {
                        root.getChildren().remove(loan_btn);
                        loan(sum, time, "PERSONAL LOAN");
                    }
                }
                catch (NumberFormatException e)
                {
                    if (loan_amount.getText().trim().isEmpty() || loan_duration.getText().trim().isEmpty())
                        error.setText("Please enter all the details");
                    else
                        error.setText("Please enter valid details");
                }
            });
        });
        home_loan_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(personal_loan_btn);
            root.getChildren().remove(home_loan_btn);
            root.getChildren().remove(vehicle_loan_btn);
            root.getChildren().remove(education_loan_btn);
            root.getChildren().remove(farm_loan_btn);
            root.getChildren().remove(business_loan_btn);
            root.getChildren().add(loan_amount);
            root.getChildren().add(loan_duration);
            root.getChildren().add(loan_btn);
            sub_title.setText("HOME LOAN");
            root.getChildren().add(error);
            loan_btn.setOnAction((ActionEvent event1) -> {
                try {
                    double sum = Double.parseDouble(loan_amount.getText());
                    int time = Integer.parseInt(loan_duration.getText());
                    if (sum < 200000)
                    {
                        error.setText("Please enter a loan amount greater than \u20B92,00,000");
                    } else if (time < 1 || time > 20)
                    {
                        error.setText("Please enter a time period between 1 and 20 years");
                    } else
                    {
                        root.getChildren().remove(loan_btn);
                        loan(sum, time, "HOME LOAN");
                    }
                }
                catch (NumberFormatException e)
                {
                    if (loan_amount.getText().trim().isEmpty() || loan_duration.getText().trim().isEmpty())
                        error.setText("Please enter all the details");
                    else
                        error.setText("Please enter valid details");
                }
            });
        });
        vehicle_loan_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(personal_loan_btn);
            root.getChildren().remove(home_loan_btn);
            root.getChildren().remove(vehicle_loan_btn);
            root.getChildren().remove(education_loan_btn);
            root.getChildren().remove(farm_loan_btn);
            root.getChildren().remove(business_loan_btn);
            root.getChildren().add(loan_amount);
            root.getChildren().add(loan_duration);
            root.getChildren().add(loan_btn);
            sub_title.setText("VEHICLE LOAN");
            root.getChildren().add(error);
            loan_btn.setOnAction((ActionEvent event1) -> {
                try {
                    double sum = Double.parseDouble(loan_amount.getText());
                    int time = Integer.parseInt(loan_duration.getText());
                    if (sum < 50000)
                    {
                        error.setText("Please enter a loan amount greater than \u20B950,000");
                    } else if (time < 1 || time > 20)
                    {
                        error.setText("Please enter a time period between 1 and 20 years");
                    } else
                    {
                        root.getChildren().remove(loan_btn);
                        loan(sum, time, "VEHICLE LOAN");
                    }
                }
                catch (NumberFormatException e)
                {
                    if (loan_amount.getText().trim().isEmpty() || loan_duration.getText().trim().isEmpty())
                        error.setText("Please enter all the details");
                    else
                        error.setText("Please enter valid details");
                }
            });
        });
        education_loan_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(personal_loan_btn);
            root.getChildren().remove(home_loan_btn);
            root.getChildren().remove(vehicle_loan_btn);
            root.getChildren().remove(education_loan_btn);
            root.getChildren().remove(farm_loan_btn);
            root.getChildren().remove(business_loan_btn);
            root.getChildren().add(loan_amount);
            root.getChildren().add(loan_duration);
            root.getChildren().add(loan_btn);
            sub_title.setText("EDUCATION LOAN");
            root.getChildren().add(error);
            loan_btn.setOnAction((ActionEvent event1) -> {
                try {
                    double sum = Double.parseDouble(loan_amount.getText());
                    int time = Integer.parseInt(loan_duration.getText());
                    if (sum < 100000)
                    {
                        error.setText("Please enter a loan amount greater than \u20B91,00,000");
                    } else if (time < 1 || time > 20)
                    {
                        error.setText("Please enter a time period between 1 and 20 years");
                    } else
                    {
                        root.getChildren().remove(loan_btn);
                        loan(sum, time, "EDUCATION LOAN");
                    }
                }
                catch (NumberFormatException e)
                {
                    if (loan_amount.getText().trim().isEmpty() || loan_duration.getText().trim().isEmpty())
                        error.setText("Please enter all the details");
                    else
                        error.setText("Please enter valid details");
                }
            });
        });
        farm_loan_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(personal_loan_btn);
            root.getChildren().remove(home_loan_btn);
            root.getChildren().remove(vehicle_loan_btn);
            root.getChildren().remove(education_loan_btn);
            root.getChildren().remove(farm_loan_btn);
            root.getChildren().remove(business_loan_btn);
            root.getChildren().add(loan_amount);
            root.getChildren().add(loan_duration);
            root.getChildren().add(loan_btn);
            sub_title.setText("FARM LOAN");
            root.getChildren().add(error);
            loan_btn.setOnAction((ActionEvent event1) -> {
                try {
                    double sum = Double.parseDouble(loan_amount.getText());
                    int time = Integer.parseInt(loan_duration.getText());
                    if (sum < 100000)
                    {
                        error.setText("Please enter a loan amount greater than \u20B91,00,000");
                    } else if (time < 1 || time > 20)
                    {
                        error.setText("Please enter a time period between 1 and 20 years");
                    } else
                    {
                        root.getChildren().remove(loan_btn);
                        loan(sum, time, "FARM LOAN");
                    }
                }
                catch (NumberFormatException e)
                {
                    if (loan_amount.getText().trim().isEmpty() || loan_duration.getText().trim().isEmpty())
                        error.setText("Please enter all the details");
                    else
                        error.setText("Please enter valid details");
                }
            });
        });
        business_loan_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(personal_loan_btn);
            root.getChildren().remove(home_loan_btn);
            root.getChildren().remove(vehicle_loan_btn);
            root.getChildren().remove(education_loan_btn);
            root.getChildren().remove(farm_loan_btn);
            root.getChildren().remove(business_loan_btn);
            root.getChildren().add(loan_amount);
            root.getChildren().add(loan_duration);
            root.getChildren().add(loan_btn);
            sub_title.setText("BUSINESS LOAN");
            root.getChildren().add(error);
            loan_btn.setOnAction((ActionEvent event1) -> {
                try {
                    double sum = Double.parseDouble(loan_amount.getText());
                    int time = Integer.parseInt(loan_duration.getText());
                    if (sum < 100000)
                    {
                        error.setText("Please enter a loan amount greater than \u20B91,00,000");
                    } else if (time < 1 || time > 20)
                    {
                        error.setText("Please enter a time period between 1 and 20 years");
                    } else
                    {
                        root.getChildren().remove(loan_btn);
                        loan(sum, time, "BUSINESS LOAN");
                    }
                }
                catch (NumberFormatException e)
                {
                    if (loan_amount.getText().trim().isEmpty() || loan_duration.getText().trim().isEmpty())
                        error.setText("Please enter all the details");
                    else
                        error.setText("Please enter valid details");
                }
            });
        });

        error.setFill(Color.rgb(255, 0, 0));
        error.setFont(Font.font("Unispace", 20));
        error.setX(500);
        error.setY(510);

        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);

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

        root.getChildren().add(personal_loan_btn);
        root.getChildren().add(home_loan_btn);
        root.getChildren().add(vehicle_loan_btn);
        root.getChildren().add(education_loan_btn);
        root.getChildren().add(farm_loan_btn);
        root.getChildren().add(business_loan_btn);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void bttn (Button button) {
        button.setFont(Font.font("Unispace", 22));
        button.setPrefSize(350, 150);
        button.setTextFill(Color.rgb(82, 183, 136));
        button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        button.setOnMouseEntered((MouseEvent event) -> {
            button.setTextFill(Color.rgb(1, 33, 24));
            button.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        button.setOnMouseExited((MouseEvent event) -> {
            button.setTextFill(Color.rgb(82, 183, 136));
            button.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
    }
    private void loan(double sum, int time, String sub_title)
    {
        root.getChildren().remove(loan_amount);
        root.getChildren().remove(loan_duration);
        root.getChildren().remove(error);
        TextFlow textFlow = new TextFlow();
        JSONParser jsonParser = new JSONParser();
        String occ = "";
        double rate = 0;
        try (FileReader reader = new FileReader("credentials.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray occList = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) occList.get(Login.user_id);
            occ = (String) jsonObject.get("occupation");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        rate = cal (rate, occ, sum, sub_title);
        //Interest, Total Amount, EMI
        BigDecimal Interest = new BigDecimal(sum);
        Interest = Interest.multiply(new BigDecimal(rate));
        Interest = Interest.multiply(new BigDecimal(time));
        Interest = Interest.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal total = new BigDecimal(sum);
        total = total.add(Interest);
        BigDecimal EMI = BigDecimal.valueOf(total.doubleValue());
        EMI = EMI.divide(new BigDecimal(time), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal Sum = new BigDecimal(sum);
        Sum = Sum.setScale(2, BigDecimal.ROUND_HALF_UP);
        Text text1 = new Text("Interest for a loan of \u20B9" + Sum + " at " + rate * 100 + "% for " + time + " years is \u20B9" + Interest + "\n");
        Text text2 = new Text("Total amount to be paid is \u20B9" + total + "\n");
        Text text3 = new Text("EMI for " + time + " years is \u20B9" + EMI + "\n");
        if (time == 1) {
            text1.setText("Interest for a loan of \u20B9" + Sum + " at " + rate * 100 + "% for " + time + " year is \u20B9" + Interest + "\n");
            text3.setText("EMI for " + time + " year is \u20B9" + EMI + "\n");
        }
        text1.setFont(Font.font("Unispace", 25));
        text1.setFill(Color.rgb(82, 183, 136));
        text2.setFont(Font.font("Unispace", 25));
        text2.setFill(Color.rgb(82, 183, 136));
        text3.setFont(Font.font("Unispace", 25));
        text3.setFill(Color.rgb(82, 183, 136));
        textFlow.getChildren().addAll(text1, text2, text3);
        textFlow.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLayoutX(300);
        textFlow.setLayoutY(350);
        textFlow.setLineSpacing(50);
        root.getChildren().add(textFlow);
    }
    double cal (double rate, String occupation, double sum, String sub_title)
    {
        if (sub_title.equals("PERSONAL LOAN"))
        {
            if (sum >= 10000 && sum <= 100000)
            {
                rate = 0.12;
            }
            else if (sum > 100000 && sum <= 500000)
            {
                rate = 0.11;
            } else if (sum > 500000 && sum <= 1000000)
            {
                rate = 0.10;
            }
            else
            {
                rate = 0.09;
            }
            if (occupation.equals("student"))
            {
                rate -= 0.01;
            }
            else if (occupation.equals("farmer"))
            {
                rate -= 0.02;
            }
        }
        else if (sub_title.equals("HOME LOAN"))
        {
            if (sum >= 200000 && sum <= 5000000)
            {
                rate = 0.10;
            }
            else if (sum > 5000000 && sum <= 15000000)
            {
                rate = 0.09;
            } else if (sum > 15000000 && sum <= 40000000)
            {
                rate = 0.08;
            }
            else
            {
                rate = 0.07;
            }
            if (occupation.equals("student"))
            {
                rate -= 0.01;
            }
            else if (occupation.equals("farmer"))
            {
                rate -= 0.02;
            }
        }
        else if (sub_title.equals("VEHICLE LOAN"))
        {
            if (sum >= 50000 && sum <= 1000000)
            {
                rate = 0.10;
            }
            else if (sum > 1000000 && sum <= 4000000)
            {
                rate = 0.09;
            } else if (sum > 4000000 && sum <= 10000000)
            {
                rate = 0.08;
            }
            else
            {
                rate = 0.07;
            }
            if (occupation.equals("student"))
            {
                rate -= 0.01;
            }
            else if (occupation.equals("farmer"))
            {
                rate -= 0.02;
            }
        }
        else if (sub_title.equals("EDUCATION LOAN"))
        {
            if (sum >= 100000 && sum <= 2000000)
            {
                rate = 0.10;
            }
            else if (sum > 2000000 && sum <= 5000000)
            {
                rate = 0.09;
            } else if (sum > 5000000 && sum <= 10000000)
            {
                rate = 0.08;
            }
            else
            {
                rate = 0.07;
            }
            if (occupation.equals("student"))
            {
                rate -= 0.04;
            }
            else if (occupation.equals("farmer"))
            {
                rate -= 0.02;
            }
        }
        else if (sub_title.equals("FARM LOAN"))
        {
            if (sum >= 100000 && sum <= 1000000)
            {
                rate = 0.10;
            }
            else if (sum > 1000000 && sum <= 5000000)
            {
                rate = 0.09;
            } else if (sum > 5000000 && sum <= 10000000)
            {
                rate = 0.08;
            }
            else
            {
                rate = 0.07;
            }
            if (occupation.equals("student"))
            {
                rate -= 0.01;
            }
            else if (occupation.equals("farmer"))
            {
                rate -= 0.04;
            }
        }
        else if (sub_title.equals("BUSINESS LOAN"))
        {
            if (sum >= 100000 && sum <= 1000000)
            {
                rate = 0.10;
            }
            else if (sum > 1000000 && sum <= 5000000)
            {
                rate = 0.09;
            } else if (sum > 5000000 && sum <= 10000000)
            {
                rate = 0.08;
            }
            else
            {
                rate = 0.07;
            }
            if (occupation.equals("student"))
            {
                rate -= 0.01;
            }
            else if (occupation.equals("farmer"))
            {
                rate -= 0.02;
            }
            else if (occupation.equals("working professional"))
            {
                rate -= 0.04;
            }
        }
        String str = String.format("%.2f", rate);
        rate = Double.parseDouble(str);
        return rate;
    }
}