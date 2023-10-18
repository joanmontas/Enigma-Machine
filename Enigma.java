// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Enigma {
        // Enigma encrypt and decrypt message
        // coordinating the components abstracted
        // as class.
        // These classes are private, keepig
        // user's message safe; away from the
        // implementation detail
        private PlugBoard plugboard;
        private Rotors rotors;

        // TODO(Andrew) Overload constructor to accept key:
        // public Enigma ([wheel1, wheel5, wheel3], [startat a, start at u, start p], [[plug t to x], [plug o to y]]) {
        // sanitize make sure that above is right
        //    throw new RuntimeException("Invalid key"); Thanks - Joan
        // NOTE(Joan) Perhaps make a class for the key itself in order to package it neartly


        public Enigma() {
                // TODO() generate a random key when the user does not specify a key
                this.plugboard = new PlugBoard();
                this.rotors = new Rotors();
        }

        /**
         * Orchestrate the encryption using Enigma's components.
         *
         * @param plainText plain text that is to be encrypted.
         * @return String sec the cipher text, the culmination of substituting and reflecting via the components.
         */
        public String EnigmaEncrypt(String plainText) {
                // NOTE(JoanMontas) orchestrate enigma's components to achieve encryption
                plainText = plainText.toLowerCase();
                StringBuilder sec = new StringBuilder();
                for (char c : plainText.toCharArray()) {
                        if (c >= 'a' && c <= 'z') {
                                char c0 = plugboard.plugIn(c);
                                c0 = rotors.plugIn(c0);
                                c0 = plugboard.plugIn(c0);
                                sec.append(c0);
                        } else {
                                sec.append(c);
                        }
                }
                return sec.toString();
        }
}
