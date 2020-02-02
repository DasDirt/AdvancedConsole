package de.dirty.controller;

import de.dirty.commands.CommandManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class ConsoleController implements Initializable {

  public static ConsoleController consoleController;

  @FXML private TextArea textArea;

  @FXML private TextField textField;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    consoleController = this;
    textArea.setText("Advanced Console [Version 1.0]\n(c) 2020 DasDirt. All rights reserved.\n");
    textArea.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> textField.requestFocus());

    textField.setOnKeyPressed(
        event -> {
          if (event.getCode().equals(KeyCode.ENTER)) {
            if (textField.getText().length() > 0) {
              textArea.appendText(
                  "\n" + CommandManager.INSTANCE.handleInput(textField.getText()) + "\n");
              textField.setText("");
            }
          }
        });
  }

  /** Returns the instance of the console controller. */
  public static ConsoleController getConsoleController() {
    return consoleController;
  }
}
