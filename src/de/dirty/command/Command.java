package de.dirty.command;

import de.dirty.controller.ConsoleController;
import java.util.Arrays;

public abstract class Command {
  private final String command;
  private final String syntax;
  private final String description;
  private final String[] alias;

  /**
   * This ist the default constructor for any command.
   *
   * @param command The command
   * @param description A short description of the command
   * @param alias Some alias can be an empty string array
   */
  public Command(String command, String syntax, String description, String[] alias) {
    this.command = command;
    this.syntax = syntax;
    this.description = description;
    this.alias = alias;
  }

  /**
   * This method will be called when the command should be executed.
   *
   * @return The output for the console.
   */
  public abstract String onExecute(String[] args);

  public void setResult(String result){
    ConsoleController.getConsoleController().setLastResult(result);
  }

  public String getCommand() {
    return command;
  }

  public String getSyntax() {
    return syntax;
  }

  public String getDescription() {
    return description;
  }

  public String[] getAlias() {
    return alias;
  }

  @Override
  public String toString() {
    return "Command{"
        + "command='"
        + command
        + '\''
        + ", syntax='"
        + syntax
        + '\''
        + ", description='"
        + description
        + '\''
        + ", alias="
        + Arrays.toString(alias)
        + '}';
  }
}
