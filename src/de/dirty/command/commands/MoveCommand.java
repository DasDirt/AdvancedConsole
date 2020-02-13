package de.dirty.command.commands;

import de.dirty.command.Command;

public class MoveCommand extends Command {

  private static boolean move = false;

  public MoveCommand() {
    super("move", "move", "Enable the Window move", new String[]{});
  }

  @Override
  public String onExecute(String[] args) {

    if (move) {
      move = false;
    } else {
      move = true;
    }
    return "Window move " + move;
  }

  public static boolean isMove() {
    return move;
  }
}
