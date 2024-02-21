package edu.ntnu.signebek.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CardGameUI extends Application {
  @Override
  public void start(Stage stage) throws Exception{
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");
    Button button3 = new Button("Button 3");
    Button button4 = new Button("Button 4");


    FlowPane rootNode = new FlowPane();
    rootNode.getChildren().add(button1);
    rootNode.getChildren().addAll(button2, button3, button4);
    rootNode.setVgap(5);
    rootNode.setHgap(5);
    rootNode.setPadding(new Insets(10));


    Scene scene = new Scene(rootNode,300,200);
    stage.setScene(scene);
    stage.setTitle("HelloWorld");
    stage.show();
  }
  public static void appMain(String[] args){
    launch();
  }
}
