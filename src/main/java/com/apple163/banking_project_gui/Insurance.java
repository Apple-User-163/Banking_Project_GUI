package com.apple163.banking_project_gui;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;

public class Insurance
{
    Group root = new Group();
    TextField cost = new TextField();
    TextField time = new TextField();
    TextField age = new TextField();
    Button calculate = new Button("CALCULATE");
    Text error = new Text();
    public Insurance()
    {
        Stage primaryStage = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(root);
        Image logo = new Image("\\resources\\Logo.png");
        Image icon = new Image("\\resources\\Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("INSURANCE");
        ImageView imageView = new ImageView(logo);
        Button back_btn = new Button("BACK");
        Button motor_btn = new Button("MOTOR INSURANCE");
        Button health_btn = new Button("HEALTH INSURANCE");
        Button life_btn = new Button("LIFE INSURANCE");
        Button property_btn = new Button("PROPERTY INSURANCE");
        Button travel_btn = new Button("TRAVEL INSURANCE");
        Button marine_btn = new Button("MARINE INSURANCE");

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

        motor_btn.setLayoutX(87);
        motor_btn.setLayoutY(247);
        cal_btn(motor_btn);
        health_btn.setLayoutX(593);
        health_btn.setLayoutY(247);
        cal_btn(health_btn);
        life_btn.setLayoutX(1101);
        life_btn.setLayoutY(247);
        cal_btn(life_btn);
        travel_btn.setLayoutX(87);
        travel_btn.setLayoutY(545);
        cal_btn(travel_btn);
        property_btn.setLayoutX(593);
        property_btn.setLayoutY(545);
        cal_btn(property_btn);
        marine_btn.setLayoutX(1101);
        marine_btn.setLayoutY(545);
        cal_btn(marine_btn);

        cost.setLayoutX(500);
        cost.setLayoutY(400);
        cost.setPrefSize(500, 60);
        cost.setFont(Font.font("Unispace", 20));
        cost.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");
        time.setLayoutX(500);
        time.setLayoutY(500);
        time.setPrefSize(500, 60);
        time.setPromptText("Time Period");
        time.setFont(Font.font("Unispace", 20));
        time.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(82, 183, 136);");
        age.setLayoutX(500);
        age.setLayoutY(300);
        age.setPrefSize(500, 60);
        age.setPromptText("Age");
        age.setFont(Font.font("Unispace", 20));
        age.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-text-fill: rgb(178, 178, 178);");
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

        motor_btn.setOnAction((ActionEvent event) -> {
            cost.setLayoutY(300);
            time.setLayoutY(400);
            calculate.setLayoutY(550);
            error.setY(510);
            root.getChildren().remove(motor_btn);
            root.getChildren().remove(health_btn);
            root.getChildren().remove(life_btn);
            root.getChildren().remove(property_btn);
            root.getChildren().remove(travel_btn);
            root.getChildren().remove(marine_btn);
            sub_title.setText("MOTOR INSURANCE");
            MotorInsurance();
        });
        health_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(motor_btn);
            root.getChildren().remove(health_btn);
            root.getChildren().remove(life_btn);
            root.getChildren().remove(property_btn);
            root.getChildren().remove(travel_btn);
            root.getChildren().remove(marine_btn);
            sub_title.setText("HEALTH INSURANCE");
            HealthInsurance();
        });
        life_btn.setOnAction((ActionEvent event) -> {
            root.getChildren().remove(motor_btn);
            root.getChildren().remove(health_btn);
            root.getChildren().remove(life_btn);
            root.getChildren().remove(property_btn);
            root.getChildren().remove(travel_btn);
            root.getChildren().remove(marine_btn);
            sub_title.setText("LIFE INSURANCE");
            LifeInsurance();
        });
        property_btn.setOnAction((ActionEvent event) -> {
            cost.setLayoutY(300);
            time.setLayoutY(400);
            calculate.setLayoutY(550);
            error.setY(510);
            root.getChildren().remove(motor_btn);
            root.getChildren().remove(health_btn);
            root.getChildren().remove(life_btn);
            root.getChildren().remove(property_btn);
            root.getChildren().remove(travel_btn);
            root.getChildren().remove(marine_btn);
            sub_title.setText("PROPERTY INSURANCE");
            PropertyInsurance();
        });
        travel_btn.setOnAction((ActionEvent event) -> {
            cost.setLayoutY(300);
            time.setLayoutY(400);
            calculate.setLayoutY(550);
            error.setY(510);
            root.getChildren().remove(motor_btn);
            root.getChildren().remove(health_btn);
            root.getChildren().remove(life_btn);
            root.getChildren().remove(property_btn);
            root.getChildren().remove(travel_btn);
            root.getChildren().remove(marine_btn);
            sub_title.setText("TRAVEL INSURANCE");
            TravelInsurance();
        });
        marine_btn.setOnAction((ActionEvent event) -> {
            cost.setLayoutY(300);
            time.setLayoutY(400);
            calculate.setLayoutY(550);
            error.setY(510);
            root.getChildren().remove(motor_btn);
            root.getChildren().remove(health_btn);
            root.getChildren().remove(life_btn);
            root.getChildren().remove(property_btn);
            root.getChildren().remove(travel_btn);
            root.getChildren().remove(marine_btn);
            sub_title.setText("MARINE INSURANCE");
            MarineInsurance();
        });

        root.getChildren().add(error);
        root.getChildren().add(motor_btn);
        root.getChildren().add(health_btn);
        root.getChildren().add(life_btn);
        root.getChildren().add(property_btn);
        root.getChildren().add(travel_btn);
        root.getChildren().add(marine_btn);
        root.getChildren().add(sub_title);
        root.getChildren().add(back_btn);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cal_btn(Button bttn)
    {
        bttn.setFont(Font.font("Unispace", 22));
        bttn.setPrefSize(350, 150);
        bttn.setTextFill(Color.rgb(82, 183, 136));
        bttn.setAlignment(Pos.CENTER);
        bttn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        bttn.setOnMouseEntered((MouseEvent event) -> {
            bttn.setTextFill(Color.rgb(1, 33, 24));
            bttn.setStyle("-fx-background-color: rgb(45, 106, 79); -fx-border-color: rgb(45, 106, 79); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
        bttn.setOnMouseExited((MouseEvent event) -> {
            bttn.setTextFill(Color.rgb(82, 183, 136));
            bttn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        });
    }
    private void MotorInsurance()
    {
        cost.setPromptText("Cost of Vehicle");
        root.getChildren().add(cost);
        root.getChildren().add(time);
        root.getChildren().add(calculate);
        calculate.setOnAction((ActionEvent event) -> {
            try {
                double cost = Double.parseDouble(this.cost.getText());
                int time = Integer.parseInt(this.time.getText());
                if (this.cost.getText() == null || this.cost.getText().trim().isEmpty() || this.time.getText() == null || this.time.getText().trim().isEmpty() || cost <= 0 || time <= 0)
                    error.setText("Please enter all the details");
                else
                {
                    error.setText("");
                    calculate(cost, time);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter valid details");
            }
        });
    }
    private void HealthInsurance()
    {
        cost.setPromptText("Policy Amount");
        root.getChildren().add(age);
        root.getChildren().add(cost);
        root.getChildren().add(time);
        root.getChildren().add(calculate);
        calculate.setOnAction((ActionEvent event) -> {
            try {
                double cst = Double.parseDouble(cost.getText());
                int time = Integer.parseInt(this.time.getText());
                int ag = Integer.parseInt(age.getText());
                if (cost.getText() == null || cost.getText().trim().isEmpty() || this.time.getText() == null || this.time.getText().trim().isEmpty() || this.age.getText() == null || this.age.getText().trim().isEmpty() || cst <= 0 || time <= 0 || ag <= 0)
                    error.setText("Please enter all the details");
                else
                {
                    error.setText("");
                    calculate(time, cst, ag);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter valid details");
            }
        });
    }
    private void LifeInsurance()
    {
        cost.setPromptText("Policy Amount");
        root.getChildren().add(cost);
        root.getChildren().add(time);
        root.getChildren().add(age);
        root.getChildren().add(calculate);
        calculate.setOnAction((ActionEvent event) -> {
            try {
                double cst = Double.parseDouble(cost.getText());
                int time = Integer.parseInt(this.time.getText());
                int ag = Integer.parseInt(age.getText());
                if (cost.getText() == null || cost.getText().trim().isEmpty() || this.time.getText() == null || this.time.getText().trim().isEmpty() || this.age.getText() == null || this.age.getText().trim().isEmpty())
                    error.setText("Please enter all the details");
                else
                {
                    error.setText("");
                    calculate(time, cst, ag);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter valid details");
            }
        });
    }
    private void PropertyInsurance()
    {
        cost.setPromptText("Cost of Property");
        root.getChildren().add(cost);
        root.getChildren().add(time);
        root.getChildren().add(calculate);
        calculate.setOnAction((ActionEvent event) -> {
            try {
                double cost = Double.parseDouble(this.cost.getText());
                int time = Integer.parseInt(this.time.getText());
                if (this.cost.getText() == null || this.cost.getText().trim().isEmpty() || this.time.getText() == null || this.time.getText().trim().isEmpty())
                    error.setText("Please enter all the details");
                else
                {
                    error.setText("");
                    calculate(cost, time);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter valid details");
            }
        });
    }
    private void TravelInsurance()
    {
        cost.setPromptText("Cost of Travel");
        root.getChildren().add(cost);
        root.getChildren().add(time);
        root.getChildren().add(calculate);
        calculate.setOnAction((ActionEvent event) -> {
            try {
                double cost = Double.parseDouble(this.cost.getText());
                int time = Integer.parseInt(this.time.getText());
                if (this.cost.getText() == null || this.cost.getText().trim().isEmpty() || this.time.getText() == null || this.time.getText().trim().isEmpty())
                    error.setText("Please enter all the details");
                else
                {
                    error.setText("");
                    calculate(cost, time);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter valid details");
            }
        });
    }
    private void MarineInsurance()
    {
        cost.setPromptText("Cost of Goods");
        root.getChildren().add(cost);
        root.getChildren().add(time);
        root.getChildren().add(calculate);
        calculate.setOnAction((ActionEvent event) -> {
            try {
                double cost = Double.parseDouble(this.cost.getText());
                int time = Integer.parseInt(this.time.getText());
                if (this.cost.getText() == null || this.cost.getText().trim().isEmpty() || this.time.getText() == null || this.time.getText().trim().isEmpty())
                    error.setText("Please enter all the details");
                else
                {
                    error.setText("");
                    calculate(cost, time);
                }
            }
            catch (NumberFormatException e)
            {
                error.setText("Please enter valid details");
            }
        });
    }
    private void calculate(double cost, int tme)
    {
        root.getChildren().remove(this.cost);
        root.getChildren().remove(time);
        root.getChildren().remove(calculate);
        double premium = getPremium(cost);
        double assurance = cost * 0.9;

        Text premium_txt = new Text("Insurance Premium: \u20B9" + premium);
        Text assurance_txt = new Text("Sum Assured: \u20B9" + assurance);
        premium_txt.setFont(Font.font("Unispace", 30));
        premium_txt.setFill(Color.rgb(82, 183, 136));
        premium_txt.setX(500);
        premium_txt.setY(500);
        assurance_txt.setFont(Font.font("Unispace", 30));
        assurance_txt.setFill(Color.rgb(82, 183, 136));
        assurance_txt.setX(500);
        assurance_txt.setY(600);
        error.setY(400);
        error.setX(500);
        error.setFill(Color.rgb(82, 183, 136));
        if (tme == 1)
            error.setText("The Insurance Premium must be paid annually for the duration of " + tme + " year");
        else
            error.setText("The Insurance Premium must be paid annually for the duration of " + tme + " years");
        root.getChildren().add(premium_txt);
        root.getChildren().add(assurance_txt);
    }

    private double getPremium(double cost) {
        double rate = 0;
        if (cost > 12 && cost < 50000)
        {
            rate = 0.05;
        }
        else if (cost > 50000 && cost < 100000)
        {
            rate = 0.06;
        }
        else if (cost > 100000 && cost < 500000)
        {
            rate = 0.07;
        }
        else if (cost > 500000 && cost < 1000000)
        {
            rate = 0.08;
        }
        else if (cost > 1000000 && cost < 5000000)
        {
            rate = 0.09;
        }
        else if (cost > 5000000)
        {
            rate = 0.1;
        }
        String round = String.format("%.2f", cost * rate);
        return Double.parseDouble(round);
    }
    private void calculate (int tme, double cst, int ag)
    {
        root.getChildren().remove(cost);
        root.getChildren().remove(age);
        root.getChildren().remove(time);
        root.getChildren().remove(calculate);
        double premium = getPremium(tme, cst, ag);
        Text premium_txt = new Text("Insurance Premium: \u20B9" + premium);
        Text assurance_txt = new Text("Sum Assured: \u20B9" + cst + " + \u20B9" + premium * tme);
        premium_txt.setFont(Font.font("Unispace", 30));
        premium_txt.setFill(Color.rgb(82, 183, 136));
        premium_txt.setX(500);
        premium_txt.setY(500);
        assurance_txt.setFont(Font.font("Unispace", 30));
        assurance_txt.setFill(Color.rgb(82, 183, 136));
        assurance_txt.setX(500);
        assurance_txt.setY(600);
        error.setY(400);
        error.setX(500);
        error.setFont(Font.font("Unispace", 30));
        error.setFill(Color.rgb(82, 183, 136));
        if (tme == 1)
            error.setText("The Insurance Premium must be paid annually for the duration of " + tme + " year");
        else
            error.setText("The Insurance Premium must be paid annually for the duration of " + tme + " years");
        root.getChildren().add(premium_txt);
        root.getChildren().add(assurance_txt);
    }
    private double getPremium(int tme, double cst, int ag)
    {
        double rate = 0;
        if (ag > 0 && ag < 18)
        {
            if (tme > 5 && tme < 10)
                rate = 0.05;
            else if (tme > 10 && tme < 15)
                rate = 0.06;
            else if (tme > 15 && tme < 20)
                rate = 0.07;
            else if (tme > 20 && tme < 25)
                rate = 0.08;
            else if (tme > 25 && tme < 30)
                rate = 0.09;
            else if (tme > 30)
                rate = 0.1;
        }
        else if (ag > 18 && ag < 25)
        {
            if (tme > 5 && tme < 10)
                rate = 0.06;
            else if (tme > 10 && tme < 15)
                rate = 0.07;
            else if (tme > 15 && tme < 20)
                rate = 0.08;
            else if (tme > 20 && tme < 25)
                rate = 0.09;
            else if (tme > 25 && tme < 30)
                rate = 0.1;
            else if (tme > 30)
                rate = 0.11;
        }
        else if (ag > 25 && ag < 35)
        {
            if (tme > 5 && tme < 10)
                rate = 0.07;
            else if (tme > 10 && tme < 15)
                rate = 0.08;
            else if (tme > 15 && tme < 20)
                rate = 0.09;
            else if (tme > 20 && tme < 25)
                rate = 0.1;
            else if (tme > 25 && tme < 30)
                rate = 0.11;
            else if (tme > 30)
                rate = 0.12;
        }
        else if (ag > 35 && ag < 45)
        {
            if (tme > 5 && tme < 10)
                rate = 0.08;
            else if (tme > 10 && tme < 15)
                rate = 0.09;
            else if (tme > 15 && tme < 20)
                rate = 0.1;
            else if (tme > 20 && tme < 25)
                rate = 0.11;
            else if (tme > 25 && tme < 30)
                rate = 0.12;
            else if (tme > 30)
                rate = 0.13;
        }
        else if (ag > 45 && ag < 60)
        {
            if (tme > 5 && tme < 10)
                rate = 0.09;
            else if (tme > 10 && tme < 15)
                rate = 0.1;
            else if (tme > 15 && tme < 20)
                rate = 0.11;
            else if (tme > 20 && tme < 25)
                rate = 0.12;
            else if (tme > 25 && tme < 30)
                rate = 0.13;
            else if (tme > 30)
                rate = 0.14;
        }
        else if (ag > 60)
        {
            if (tme > 5 && tme < 10)
                rate = 0.1;
            else if (tme > 10 && tme < 15)
                rate = 0.12;
            else if (tme > 15 && tme < 20)
                rate = 0.14;
            else if (tme > 20 && tme < 25)
                rate = 0.16;
            else if (tme > 25 && tme < 30)
                rate = 0.18;
            else if (tme > 30)
                rate = 0.2;
        }
        String round = String.format("%.2f", cst * rate);
        return Double.parseDouble(round);
    }
}