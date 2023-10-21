// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Rotor {
        private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        private char[] rotorWiring = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        private int alphabetLength = this.alphabet.length;
        private char initialPosition = 'a';
        private int position = 0;
        private char notch = 'c';

        /** Constructor builds instance given wiring, position and notch. default alphabet assumed.
        * @param rotorWiring wiring format of the desired rotor (ISO basic latin).
        * @param initialPosition starting letter of the rotor.
        * @param notch the letter/notch the rotor would rotate its neighboring rotor.
        * @throws NumberFormatException if giving Rotor alphabet is not the size of the ISO basic latin.
        */
        public Rotor(char[] rotorWiring, char initialPosition, char notch) {
                        if (rotorWiring.length != this.alphabetLength) {
                                throw new NumberFormatException("Rotor Wiring does not match default Alphabet's length.");
                        }
                        this.rotorWiring = rotorWiring;
                        this.notch = notch;
                        this.initialPosition = initialPosition;
                        this.position = (initialPosition - 'a') % this.alphabetLength;
        }

        /**Given a character (in numeric representation), returns its current substitution given the setting.
        * from rotor wiring to the alphabetic position.
        * @param  n the wire wished to be substituted.
        * @return The substituted character (in numeric representation).
        */
        public int plugIn(int n) {
                int index = (n + this.position) % this.alphabetLength;
                char cWire = this.rotorWiring[index];
                for (int i = 0; i < this.alphabetLength; i++) {
                        index = (i + this.position) % this.alphabetLength;
                        if (this.alphabet[index] == cWire) {
                                return i;
                        }
                }
                return 0;
        }

        /**Given a character (in numeric representation), returns its current substitution given the setting.
        * from alphabetic position to rotor wiring.
        * @param  n the wire wished to be substituted.
        * @return The substituted character (in numeric representation).
        */
        public int plugOut(int n) {
                int index = (n + this.position) % this.alphabetLength;
                char cAlpha = this.alphabet[index];
                for (int i = 0; i < this.alphabetLength; i++) {
                        index = (i + this.position) % this.alphabetLength;
                        if (this.rotorWiring[index] == cAlpha) {
                                return i;
                        }
                }
                return 0;
        }

        /**Performs a single rotation.
        */
        public void rotate() {
                this.position = (this.position + 1) % this.alphabetLength;
        }

        /**Checks if the rotation would result in meeting the notch.
        * @return true if rotation would result in meeting the notch, otherwise, false.
        */
        public boolean notchMatch () {
                return this.alphabet[(this.position + 1) % this.alphabetLength] == this.notch;
        }

        /**Debugging method, prints the current state of the rotor.
        */
        public void prettyPrint() {
                        System.out.println("Rotor Wiring: " + new String(rotorWiring));
                        System.out.println("Alphabet: " + new String(alphabet));
                        System.out.println("Initial Position: " + initialPosition);
                        System.out.println("Position: " + position);
                        System.out.println("Notch: " + notch);
                        int index = 0;
                        for (int i = 0; i < this.alphabetLength; i++) {
                                index = (i + this.position) % this.alphabetLength;
                                System.out.print(i + " ");
                                System.out.print(this.alphabet[index] + " ");
                                System.out.println(this.rotorWiring[index]);
                        }
        }
}
	