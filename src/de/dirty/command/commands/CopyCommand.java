package de.dirty.command.commands;

import de.dirty.command.Command;
import de.dirty.controller.ConsoleController;

public class CopyCommand extends Command {

  public CopyCommand() {
    super("copy", "copy", "Copies the last result in your keyboard", new String[] {"c"});
  }

  @Override
  public String onExecute(String[] args) {
    String result = ConsoleController.getConsoleController().getLastResult();
    ConsoleController.getConsoleController().setClipboardString(result);
    return "Copied text: '" + result + "' into your clipboard";
  }
}
