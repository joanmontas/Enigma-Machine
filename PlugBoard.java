// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.HashMap;

public class PlugBoard {
            private final HashMap<Character, Character> plugboardMap = new HashMap<>();
        private static final String SCRAMBLED_ALPHABET = "ybhwcqneljmktduzvfxaopgsri";

        /**
         * Constructor to initialize the plugboard with a fixed scrambled mapping.
         */
        public PlugBoard() {
                for (int i = 0; i < 26; i++) {
                char originalChar = (char) ('a' + i);
                char scrambledChar = SCRAMBLED_ALPHABET.charAt(i);
                plugboardMap.put(originalChar, scrambledChar);
                }
        }

        /**
         * Given a Char "input-wire", return the corresponding output-wire/letter.
         * @param letterWire input wire/letter.
         * @return output wire/letter.
         */
        public char plugIn(char letterWire) {
                return plugboardMap.get(letterWire);
        }
}

