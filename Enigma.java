// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Enigma {
        private Rotors rotors = new Rotors();
        private PlugBoard plugboard = new PlugBoard();

        /**Orchestrate the encryption using Enigma's components.
        * @param plainText plain text that is to be encrypted.
        * @return The cipherText
        */
        public String encrypt(String plainText) {
                plainText = plainText.toLowerCase();
                String cipherText = "";
                char c;
                for (int i = 0; i < plainText.length(); i++) {
                        c = plainText.charAt(i);
                        // NOTE(Andrew) this is debatable, including non alphabetical character
                        // will expose our secret message. - Joan
                        if (Character.isAlphabetic(c)) {
                                c = this.plugboard.plugIn(c);
                                c = this.rotors.plugIn(c);
                                c = this.plugboard.plugIn(c);
                                cipherText = cipherText + c;
                        }
                        
                }
                return cipherText;
        }
}
