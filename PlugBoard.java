// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.HashMap;

public class PlugBoard {
        private final HashMap<Character, Character> plugboardMap = new HashMap<>();
        private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        /**Default Constructor to initialize the plugboard without any substitution
        */
        public PlugBoard() {
                char originalChar;
                for (int i = 0; i < alphabet.length(); i++) {
                        originalChar = (char) ('a' + i);
                        plugboardMap.put(originalChar, originalChar);
                }
        }

        // TODO(JoanMontas) Andrew please make a constructor that would accept a specific
        // rotor configuration. - Joan

        /**Given a Char "input-wire", return the corresponding output-wire/letter.
        * @param letterWire input wire/letter.
        * @return output wire/letter.
        */
        public char plugIn(char letterWire) {
                return plugboardMap.get(letterWire);
        }
}
