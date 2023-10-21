// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class EntryWheel {
        /**
         * Given a character, convert it into its numerical equivalent.
         * @param letterWire input wire/letter.
         * @return numerical equivalent.
         */
        public int plugIn(char c) {
                return c - 'a';
        }

        /**
         * Given a number, convert it into its char.
         * @param letterWire input wire/letter.
         * @return char equivalent.
         */
        public char plugOut(int n) {
                return (char)(n + 'a');
        }

}
