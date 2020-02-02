package de.dirty.command;

import de.dirty.command.commands.Base64Command;
import de.dirty.command.commands.CopyCommand;
import de.dirty.command.commands.HelpCommand;
import de.dirty.command.commands.SuperscriptCommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {
  public static final CommandManager INSTANCE = new CommandManager();
  private List<Command> commands = new ArrayList<>();

  /** All commands should be registered here. */
  public CommandManager() {
    commands.add(new HelpCommand());
    commands.add(new SuperscriptCommand());
    commands.add(new CopyCommand());
    commands.add(new Base64Command());
  }

  /** This method returns a command by name or alias */
  public Command getCommand(String s) {
    for (Command command : commands) {
      if (command.getCommand().equalsIgnoreCase(s)
          || Arrays.asList(command.getAlias()).contains(s)) {
        return command;
      }
    }
    return null;
  }

  /**
   * This method handles the console input and returns the output.
   *
   * @param input The user input.
   * @return The console output.
   */
  public String handleInput(String input) {
    String[] tmpArgs = input.split(" ");
    if (tmpArgs.length > 0) {
      Command command = getCommand(tmpArgs[0]);
      if (command != null) {
        return command.onExecute(Arrays.copyOfRange(tmpArgs, 1, tmpArgs.length));
      } else {
        return "'" + tmpArgs[0] + "' is not recognized as a command\nType 'help' for help.";
      }
    }
    // This should never returned only if the input is empty.
    return null;
  }

  public List<Command> getCommands() {
    return commands;
  }
}
