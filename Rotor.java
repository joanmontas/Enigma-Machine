// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Rotor {
        private int position;
        private boolean shouldDoubleStep = false;
        private Rotor leftRotor;
        private final char[] rotorWiring;
        private final char notch;

    
        // Constructor for middle and leftmost rotors
        public Rotor(char[] rotorWiring, int startPosition, char notch, Rotor leftRotor) {
            this.rotorWiring = rotorWiring;
            this.position = startPosition;
            this.notch = notch;
            this.leftRotor = leftRotor;
        }

        // Accepts rotor like IC, IIC, IIIC
        public Rotor(String rotorType, Rotor leftRotor) {
                switch(rotorType) {
                        case "IC":
                        this.rotorWiring = "DMTWSILRUYQNKFEJCAZBPGXOHV".toLowerCase().toCharArray();
                        this.position = 6;
                        this.notch = 'q';
                        this.leftRotor = leftRotor;
                        break;
                        case "IIC":
                        this.rotorWiring = "HQZGPJTMOBLNCIFDYAWVEUSRKX".toLowerCase().toCharArray();
                        this.position = 23;
                        this.notch = 'e';
                        this.leftRotor = leftRotor;
                        break;
                        case "IIIC":
                        this.rotorWiring = "UQNTLSZFMREHDPXKIBVYGJCWOA".toLowerCase().toCharArray();
                        this.position = 11;
                        this.notch = 'v';
                        this.leftRotor = leftRotor;
                        break;
                        default:
                        throw new IllegalArgumentException("Unknown rotor type: " + rotorType);
                }
        }

        public void setLeftRotor(Rotor leftRotor) {
                this.leftRotor = leftRotor;
        }           
    
        // Constructor for the rightmost rotor (always steps)
        public Rotor(char[] rotorWiring, int startPosition, char notch) {
            this(rotorWiring, startPosition, notch, null);
        }

        public char plugIn(char letterWire) {
                char substitutedChar = rotorWiring[(letterWire - 'a' + position) % rotorWiring.length];
                rotate();
                return substitutedChar;
        }

        public char plugOut(char letterWire) {
                for (int i = 0; i < rotorWiring.length; i++) {
                    // Match the character with consideration of the rotor's current position
                    if (rotorWiring[(i + position) % rotorWiring.length] == letterWire) {
                        return (char) ('a' + i);
                    }
                }
                return letterWire; 
        }

        private void rotate() {
                if (leftRotor != null && shouldDoubleStep) {
                    leftRotor.rotate();
                    shouldDoubleStep = false;
                }
            
                position = (position + 1) % rotorWiring.length;
                
                // If the rotor hits the notch and there's a left rotor, set the flag for double-stepping.
                if (rotorWiring[position] == notch && leftRotor != null) {
                    leftRotor.rotate();
                    shouldDoubleStep = true;
                }
            }
}
