package com.apple163.banking_project_gui;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.util.Duration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Login
{
    public String user_name;
    public String pass_word;
    public int user_id;
    String occupation;
    Boolean userFound = false;


    Group root = new Group();
    Scene scene = new Scene(root);
    static boolean signed_in;
    public Login() {
        StackPane stackPane = new StackPane();
        Stage stage = new Stage();
        Image logo = new Image("file:src/main/resources/Logo.png");
        Image icon = new Image("file:src/main/resources/Icon.png");
        Text title = new Text("THE BANKING PROJECT");
        Text sub_title = new Text("LOGIN");
        Text message = new Text();
        ImageView imageView = new ImageView(logo);
        Button sign_in_btn = new Button("SIGN IN");
        Button signup_btn = new Button("SIGN UP");
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        ComboBox<String> comboBox = new ComboBox<>();
        JSONParser parser = new JSONParser();
        Platform.runLater(Stage::new);
        JSONArray users;
        try {
            users = (JSONArray) parser.parse(new FileReader("credentials.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }


        title.setFill(Color.rgb(82, 183, 136));
        title.setFont(Font.font("Unispace", 25));
        title.setX(60);
        title.setY(36);
        sub_title.setFill(Color.rgb(82, 183, 136));
        sub_title.setFont(Font.font("Unispace", 40));
        sub_title.setX(60);
        sub_title.setY(120);
        message.setFont(Font.font("Unispace", 20));
        message.setY(610);
        message.setX(500);
        message.setFill(Color.RED);

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

        comboBox.setEditable(false);
        comboBox.setLayoutX(500);
        comboBox.setLayoutY(500);
        comboBox.setPrefSize(500, 60);
        comboBox.setPromptText("Occupation");
        comboBox.getItems().addAll("Farmer", "Student", "Working Professional");

        sign_in_btn.setLayoutX(500);
        sign_in_btn.setLayoutY(650);
        sign_in_btn.setPrefSize(240, 60);
        sign_in_btn.setFont(Font.font("Unispace", 20));
        sign_in_btn.setTextFill(Color.rgb(82, 183, 136));
        sign_in_btn.setStyle("-fx-background-color: transparent; -fx-border-color: rgb(82, 183, 136); -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        button(sign_in_btn);

        signup_btn.setLayoutX(760);
        signup_btn.setLayoutY(650);
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

        scene.setFill(new RadialGradient(
                1, 1, 1, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(4, 116, 114)),
                new Stop(1, Color.rgb(1, 33, 24)))
        );

        sign_in_btn.setOnAction((ActionEvent event) -> {
            user_name = username.getText();
            pass_word = password.getText();
            if (user_name.isEmpty() || pass_word.isEmpty()) {
                message.setFill(Color.RED);
                message.setText("Please enter your user credentials");
                return;
            }
            for (Object userObject : users) {
                JSONObject user = (JSONObject) userObject;
                String storedUsername = (String) user.get("username");
                String storedPassword = (String) user.get("password");

                if (storedUsername.equals(user_name) && storedPassword.equals(pass_word)) {
                    userFound = true;
                    user_id = users.indexOf(user);
                    System.out.println(user_id);
                    break;
                }
            }

            if (userFound) {
                signed_in = true;
                message.setFill(Color.LIMEGREEN);
                message.setText("Login successful");
                close(stage);
            }
            else
            {
                message.setFill(Color.RED);
                message.setText("Invalid username or password");
            }

        });

        signup_btn.setOnAction((ActionEvent event) -> {
            user_name = username.getText();
            pass_word = password.getText();
            occupation = comboBox.getValue();

            if (user_name.isEmpty() || pass_word.isEmpty()) {
                message.setText("Please enter your user credentials");
                return;
            }
            message.setText("");
            try {
                occupation = occupation.toLowerCase();
            } catch (NullPointerException e) {
                message.setText("Please select an occupation");
                return;
            }
            message.setText("");

            for (Object userObject : users) {
                JSONObject user = (JSONObject) userObject;
                String storedUsername = (String) user.get("username");

                if (storedUsername.equals(user_name)) {
                    userFound = true;
                    break;
                }
            }

            if (!userFound) {
                // Create a new user object and add it to the JSON data
                JSONObject newUser = new JSONObject();
                newUser.put("username", user_name);
                newUser.put("password", pass_word);
                newUser.put("occupation", occupation);
                users.add(newUser);
                // Update the JSON file with the new user data
                try (FileWriter fileWriter = new FileWriter("credentials.json")) {
                    fileWriter.write(users.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                signed_in = true;
                message.setFill(Color.LIMEGREEN);
                message.setText("Registration successful");
                user_id = users.indexOf(newUser);
                System.out.println(user_id);
            }   close(stage);
            if (userFound) {
                message.setFill(Color.RED);
                message.setText("Username already exists");
                userFound = false;
            }
        });
        stage.getIcons().add(icon);
        stage.setWidth(1533);
        stage.setHeight(800);
        stage.setTitle("The Banking Project");
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");

        root.getChildren().add(message);
        root.getChildren().add(comboBox);
        root.getChildren().add(sign_in_btn);
        root.getChildren().add(signup_btn);
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(sub_title);
        root.getChildren().add(stackPane);
        root.getChildren().add(title);
        root.getChildren().add(imageView);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("dropdown.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

        stage.setOnHidden(event -> {
            signed_in =  true;
            new Main().start(new Stage());
        });
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

    public void close(Stage stage)
    {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.setOnFinished(event -> stage.close());
        pause.play();
    }
}
