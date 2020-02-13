package de.dirty.command.commands;

import de.dirty.command.Command;
import de.dirty.controller.ConsoleController;

public class ExitCommand extends Command {

  public ExitCommand() {
    super("exit", "exit or exit <Seconds>", "exit the Programm", new String[]{"e"});
  }

  @Override
  public String onExecute(String[] args) {
    if (args.length == 1) {
      long l = Long.parseLong(args[0]) * 1000;
      ConsoleController.getConsoleController().setInfoText("Exit in " + l / 1000 + " Seconds");
      new Thread(() -> {
        try {
          Thread.sleep(l);
          System.exit(0);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    } else {
      System.exit(0);
    }
    return "Exit";
  }
}
