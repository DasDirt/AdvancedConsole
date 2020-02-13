package de.dirty.command.commands;

import de.dirty.command.Command;
import java.util.Base64;

public class Base64Command extends Command {

  public Base64Command() {
    super("base64", "base64 <encode/decode> <text>", "En/De-codes a string", new String[]{});
  }

  @Override
  public String onExecute(String[] args) {
    System.out.println(args.length);
    if (args.length == 2) {
      switch (args[0].toLowerCase()) {
        case "encode":
          String encoded = new String(Base64.getEncoder().encode(args[1].getBytes()));
          setResult(encoded);
          return "Sure the here's the encoded string: '" + encoded + "'";
        case "decode":
          String decoded = new String(Base64.getDecoder().decode(args[1].getBytes()));
          setResult(decoded);
          return "Sure the here's the decoded string: '" + decoded + "'";
        default:
          return "Wrong syntax pls use: " + getSyntax();
      }
    } else {
      return "dWrong syntax pls use: " + getSyntax();
    }
  }
}
