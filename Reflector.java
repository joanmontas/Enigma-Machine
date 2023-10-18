// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.HashMap;

public class Reflector {
        // reflector is a hash map from char to char
        private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
        private final HashMap<Character, Character> reflector = new HashMap<>();
    
        public Reflector() {
                // Each character is reflected to the letter 13 places away (modulo the alphabet length)
                for (char letter : ALPHABET) {
                        char reflectedLetter = (char) ((letter - 'a' + 13) % 26 + 'a');
                        reflector.put(letter, reflectedLetter);
                }
        }

        /**
         * Given a wire/letter substitute/reflect it to another letter based on the
        * pre-configured settings.
        *
        * @param  letterWire the wire/letter that is to be reflected
        * @return char
        */
        public char reflect(char letterWire) {
                return this.reflector.get(letterWire);
        }
}
