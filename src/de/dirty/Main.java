package de.dirty;

import de.dirty.controller.ConsoleController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("fxml/Console.fxml"));
    primaryStage.addEventFilter(
        KeyEvent.KEY_PRESSED,
        keyEvent -> ConsoleController.getConsoleController().focusTextField(keyEvent.getText()));
    primaryStage.addEventFilter(
        MouseEvent.MOUSE_CLICKED,
        event -> ConsoleController.getConsoleController().focusTextField(null));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 576, 367));
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
