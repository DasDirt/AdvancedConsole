package de.dirty.controller;

import de.dirty.command.CommandManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ConsoleController implements Initializable {

  public static ConsoleController consoleController;
  private final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
  private List<String> lastInputs = new ArrayList<>();
  private boolean infoText = false;
  private int currentLast = 0;

  @FXML private TextArea textArea;

  @FXML private TextField textField;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    consoleController = this;
    textArea.setText("Advanced Console [Version 1.0]\n(c) 2020 DasDirt. All rights reserved.\n");
    textArea.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
    textArea.addEventFilter(
        MouseEvent.MOUSE_CLICKED,
        event -> {
          if (event.getButton().equals(MouseButton.PRIMARY)) {
            textField.requestFocus();
          } else if (event.getButton().equals(MouseButton.SECONDARY)) {
            setClipboardString(textArea.getSelectedText());
          }
        });
    textArea.setOnKeyPressed(
        keyEvent -> {
          textField.appendText(keyEvent.getText());
          textField.requestFocus();
        });

    textField.setOnMouseClicked(
        mouseEvent -> {
          if (infoText) {
            textField.setText("");
          }
        });
    textField.setOnKeyPressed(
        event -> {
          if (event.getCode().equals(KeyCode.ENTER)) {
            currentLast = 0;
            if (textField.getText().length() > 0) {
              if (!lastInputs.contains(textField.getText())) {
                Collections.reverse(lastInputs);
                lastInputs.add(textField.getText());
                Collections.reverse(lastInputs);
              }
              textArea.appendText("\nExecute command: " + textField.getText() + "\n");
              textArea.appendText(CommandManager.INSTANCE.handleInput(textField.getText()) + "\n");
              textField.setText("");
            }
          } else if (event.getCode().equals(KeyCode.UP)) {
            System.out.println(currentLast);
            if (currentLast < lastInputs.size()) {
              currentLast++;
            }
            textField.setText(lastInputs.get(currentLast - 1));
            if (currentLast == lastInputs.size()) {
              currentLast = lastInputs.size() - 1;
            }
          } else if (event.getCode().equals(KeyCode.DOWN)) {
            System.out.println(currentLast);
            if (currentLast > 0) {
              currentLast--;
              textField.setText(lastInputs.get(currentLast));
            } else {
              textField.setText("");
            }
          } else if (infoText) {
            infoText = false;
            textField.setText("");
          }
        });
  }

  /** This method sets a text in the clipboard */
  public void setClipboardString(String s) {
    StringSelection stringSelection = new StringSelection(s);
    clipboard.setContents(stringSelection, stringSelection);
    //    textArea.appendText("\nCopied text: '" + s + "' into your clipboard\n");
    setInfoText("Copied text: '" + s + "' into your clipboard");
  }

  public void setInfoText(String s) {
    infoText = true;
    textField.setText(s);
  }

  /** Returns the instance of the console controller. */
  public static ConsoleController getConsoleController() {
    return consoleController;
  }
}
