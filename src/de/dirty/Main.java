package de.dirty;

import de.dirty.command.Command;
import de.dirty.command.CommandManager;
import de.dirty.command.commands.MoveCommand;
import de.dirty.controller.ConsoleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

  double x, y;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("fxml/Console.fxml"));

    root.setOnMousePressed(event -> {
      if (MoveCommand.isMove()) {
        x = event.getSceneX();
        y = event.getSceneY();
      }
    });

    root.setOnMouseDragged(event -> {
      if (MoveCommand.isMove()) {
        primaryStage.setX(event.getScreenX() - x);
        primaryStage.setY(event.getScreenY() - y);
      }
    });

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
