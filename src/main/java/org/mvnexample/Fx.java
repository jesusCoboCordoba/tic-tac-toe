package org.mvnexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;


public class Fx extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //  Stage stage = new Stage()to create a new stage
        Group root = new Group(); // this is the root scene node
        Scene scene = new Scene(root,600,600,BLACK);
        Image image = new Image("img_1.png");


        primaryStage.getIcons().add(image);
        primaryStage.setTitle("TicTacToe");
        //primaryStage.setWidth(500);
        //primaryStage.setHeight(500);
        Text text = new Text();
        text.setText("Your turn:");
        text.setY(50);
        text.setX(50);
        text.setFill(WHITE);

        text.setFont(Font.font("Verdana",50));

        root.getChildren().add(text);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
