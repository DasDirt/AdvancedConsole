package de.dirty.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {
  public static final CommandManager INSTANCE = new CommandManager();
  private List<Command> commands = new ArrayList<>();

  /** All commands should be registered here. */
  public CommandManager() {}

  /**
   * This method handles the console input and returns the output.
   *
   * @param input The user input.
   * @return The console output.
   */
  public String handleInput(String input) {
    String[] tmpArgs = input.split(" ");
    if (tmpArgs.length > 0) {
      for (Command command : commands) {
        if (command.getCommand().equalsIgnoreCase(tmpArgs[0])
            || Arrays.asList(command.getAlias()).contains(tmpArgs[0])) {
          return command.onExecute(Arrays.copyOfRange(tmpArgs, 1, tmpArgs.length));
        }
      }
      return "'" + tmpArgs[0] + "' is not recognized as a command\nType 'help' for help.";
    }
    // This should never returned only if the input is empty.
    return null;
  }
}
