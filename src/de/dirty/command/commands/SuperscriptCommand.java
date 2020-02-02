package de.dirty.command.commands;

import de.dirty.command.Command;
import java.util.HashMap;

public class SuperscriptCommand extends Command {

  private HashMap<Character, Character> superscriptHashMap =
      new HashMap<>() {
        {
          put('0', '⁰');
          put('1', '¹');
          put('2', '²');
          put('3', '³');
          put('4', '⁴');
          put('5', '⁵');
          put('6', '⁶');
          put('7', '⁷');
          put('8', '⁸');
          put('9', '⁹');
          put('a', 'ᵃ');
          put('b', 'ᵇ');
          put('c', 'ᶜ');
          put('d', 'ᵈ');
          put('e', 'ᵉ');
          put('f', 'ᶠ');
          put('g', 'ᵍ');
          put('h', 'ʰ');
          put('i', 'ⁱ');
          put('j', 'ʲ');
          put('k', 'ᵏ');
          put('l', 'ˡ');
          put('m', 'ᵐ');
          put('n', 'ⁿ');
          put('o', 'ᵒ');
          put('p', 'ᵖ');
          put('q', 'q');
          put('r', 'ʳ');
          put('s', 'ˢ');
          put('t', 'ᵗ');
          put('u', 'ᵘ');
          put('v', 'ᵛ');
          put('w', 'ʷ');
          put('x', 'ˣ');
          put('y', 'ʸ');
          put('z', 'ᶻ');
          put('A', 'ᴬ');
          put('B', 'ᴮ');
          put('C', 'ᶜ');
          put('D', 'ᴰ');
          put('E', 'ᴱ');
          put('F', 'ᶠ');
          put('G', 'ᴳ');
          put('H', 'ᴴ');
          put('I', 'ᴵ');
          put('J', 'ᴶ');
          put('K', 'ᴷ');
          put('L', 'ᴸ');
          put('M', 'ᴹ');
          put('N', 'ᴺ');
          put('O', 'ᴼ');
          put('P', 'ᴾ');
          put('Q', 'Q');
          put('R', 'ᴿ');
          put('S', 'ˢ');
          put('T', 'ᵀ');
          put('U', 'ᵁ');
          put('V', 'ⱽ');
          put('W', 'ᵂ');
          put('X', 'ˣ');
          put('Y', 'ʸ');
          put('Z', 'ᶻ');
          put('+', '⁺');
          put('-', '⁻');
          put('=', '⁼');
          put('(', '⁽');
          put(')', '⁾');
        }
      };

  public SuperscriptCommand() {
    super(
        "superscript",
        "superscript <text>",
        "Returns the given text in superscript",
        new String[] {"sc"});
  }

  @Override
  public String onExecute(String[] args) {
    StringBuilder stringBuilder = new StringBuilder("Sure '" + args[0] + "' in superscript is: '");
    char[] chars = args[0].toCharArray();
    for (char aChar : chars) {
      if (superscriptHashMap.containsKey(aChar)) {
        stringBuilder.append(superscriptHashMap.get(aChar));
      } else {
        stringBuilder.append(aChar);
      }
    }
    return stringBuilder.toString() + "'";
  }
}
