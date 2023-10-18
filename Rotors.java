// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.ArrayList;
import java.util.List;

 public class Rotors {
        // NOTE(JoanMontas) Using 1924's wiring configuration
        private List<Rotor> rotors = new ArrayList<>();
        private Reflector reflector;
    
        public Rotors() {        
                rotors.add(new Rotor("IIIC", null));
                rotors.add(new Rotor("IIC", rotors.get(rotors.size() - 1)));
                rotors.add(new Rotor("IC", rotors.get(rotors.size() - 1)));

                reflector = new Reflector();
            }

        // Overloaded constructor for dynamic rotor configurations
        public Rotors(Rotor... rotors) {
                for (int i = 0; i < rotors.length; i++) {
                    // If it's not the first rotor, set its left rotor.
                    if (i > 0) {
                        rotors[i].setLeftRotor(rotors[i - 1]);
                    }
                    this.rotors.add(rotors[i]);
                }
                reflector = new Reflector();
        }

        /**
         * Given a character, pass along the rotors (rotate next rotor due to notch match) and rotate
         *
         * @param  letterWire is the specific wire/letter received from the PlugBoard.
         * @return the letterWire substituted 7 time (6 by rotors and 1 by reflector)
         */
        public char plugIn(char letterWire) {
                // forward substitutions
                for (Rotor rotor : rotors) {
                        letterWire = rotor.plugIn(letterWire);
                }
                // reflector
                letterWire = reflector.reflect(letterWire);
                // backward substiutions
                for (int i = rotors.size() - 1; i >= 0; i--) {
                        letterWire = rotors.get(i).plugOut(letterWire);
                }
                return letterWire;
        }
}
