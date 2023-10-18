// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

// for all purpose, letters will be lower case
// and no special symbol
public class EnigmaMain {
        public static void main (String[] args) {
                Enigma enigma = new Enigma();
                String plainText = "helloworld";
                System.out.println("The plaint text: " + plainText);
                String sec = enigma.EnigmaEncrypt(plainText);
                System.out.println("The secret: " + sec);
                String newPlainText = enigma.EnigmaEncrypt(sec);
                System.out.println("The new plain text: " + newPlainText);
        }
}
