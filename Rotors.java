// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.ArrayList;
import java.util.List;

public class Rotors {
        private Rotor III = new Rotor(("BDFHJLCPRTXVZNYEIWGAKMUSQO".toLowerCase()).toCharArray(), 'g', 'v');
        private Rotor II =  new Rotor(("AJDKSIRUXBLHWTMCQGZNPYFVOE".toLowerCase()).toCharArray(), 'o', 'e');
        private Rotor I =   new Rotor(("EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase()).toCharArray(), 'd', 'q');

        private Reflector reflector = new Reflector();
        private EntryWheel entrywheel = new EntryWheel();
        List<Rotor> RotorConfiguration = new ArrayList<>();

        /**Default constructor
        */
        public Rotors() {
                this.RotorConfiguration.add(this.III); 
                this.RotorConfiguration.add(this.II);
                this.RotorConfiguration.add(this.I);
        }

        // TODO(Andrew) Implement a way to specify which rotors and which settings to implement. - Joan
        // as of now, they are hardcoded as Rotor III, II and I.

        /**Given a character, pass along the rotors (rotate next rotor due to notch match) and rotate
        * @param  letterWire is the specific wire/letter received from the PlugBoard.
        * @return the letterWire substituted 7 time (6 by rotors and 1 by reflector)
        */
        public char plugIn(char c) {
                Rotor currentRotor;
                int n = this.entrywheel.plugIn(c);
                this.modifySetOfRotors(0);
                for (int i = 0; i < this.RotorConfiguration.size(); i++) {
                        currentRotor = this.RotorConfiguration.get(i);
                        n = currentRotor.plugIn(n);
                }

                n = this.reflector.plugIn(n);
                
                for (int i = this.RotorConfiguration.size() - 1; i > -1; i--) {
                        currentRotor = this.RotorConfiguration.get(i);
                        n = currentRotor.plugOut(n);
                }
                return this.entrywheel.plugOut(n);
        }

        /**If possible, rotate the rotor at the given position, and all other rotor to its left.
        * @param positionCurrentRotor checks if nth-rotor (positionOfCurrentRotor) is possible.
        */
        private void modifySetOfRotors (int positionCurrentRotor) {
                // NOTE(Andrew) PLEASE DO NOT DELETE... functional programming is the way to go. - Joan
                if (positionCurrentRotor >= this.RotorConfiguration.size()) {
                        return;
                }
                Rotor currentRotor = this.RotorConfiguration.get(positionCurrentRotor);
                if (currentRotor.notchMatch()) {
                        modifySetOfRotors(positionCurrentRotor + 1);
                }
                currentRotor.rotate();
        }
}
