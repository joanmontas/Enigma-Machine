// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

// for all purpose, letters will be lower case
// and no special symbol
public class EnigmaMain {
        public static void main (String[] args) {
                Enigma eng0 = new Enigma();
                String plainText = "Hello, World!";

                System.out.println("The plaintext: " + plainText);

                String cipherText = eng0.encrypt(plainText);
                System.out.println("The cipherText: " + cipherText);

                Enigma eng1 = new Enigma();
                String decryption = eng1.encrypt(cipherText);

                System.out.println("The decrypted: "  + decryption);
        }
}
  