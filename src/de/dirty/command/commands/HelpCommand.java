package de.dirty.command.commands;

import de.dirty.command.Command;
import de.dirty.command.CommandManager;

public class HelpCommand extends Command {

  public HelpCommand() {
    super("help", "help", "Prints the help", new String[] {"?"});
  }

  @Override
  public String onExecute(String[] args) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Command command : CommandManager.INSTANCE.getCommands()) {
      StringBuilder alias = new StringBuilder(", ");
      if (command.getAlias() != null) {
        for (String commandAlias : command.getAlias()) {
          alias.append(commandAlias).append(", ");
        }
      }

      stringBuilder
          .append(command.getCommand())
          .append(
              alias.toString().equals(",")
                  ? ""
                  : alias.toString().substring(0, alias.toString().length() - 2))
          .append(" | ")
          .append(command.getDescription())
          .append("\n");
    }
    return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
  }
}
