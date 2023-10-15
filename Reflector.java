// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.HashMap;

public class Reflector {
  // reflector is a hash map from char to char
  char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  char[] ReflectorA = "EJMZALYXVBWFCRQUONTSPIKHGD".toLowerCase().toCharArray();
  HashMap<Character, Character> reflector = new HashMap<>();

  public Reflector () {
    // constructor willl create the reflector
    // in the machine this is hardcoded too

    // TODO(Andrew) For now we use a stock reflector configuration
    // but could you finish implementing it dynamically like how I have
    // started? Thanks - Joan 
    configurate(ReflectorA);
  }

  /**
  * Given a wire/letter substitute/reflect it to another letter based on the
  * pre-configured settings.
  *
  * @param  letterWire the wire/letter that is to be reflected
  * @return char
  */
  public char reflect (char letterWire) {
    return this.reflector.get(letterWire);
  }

  /**
  * Given a reflector wire configuration creates a hashmap that will subsitute a letter for
  * another.
  *
  * @param  reflectorWiring is the wiring configuration of the reflector as an array of character
  * @return void
  */
  private void configurate(char[] reflectorWiring) {
    reflector.clear();
    for (int i = 0; i < alphabet.length; i++) {
      this.reflector.put(this.alphabet[i], reflectorWiring[i]);
    }
  }
}
