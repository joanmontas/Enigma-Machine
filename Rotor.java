// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Rotor {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] rotorWiring;
    private int alphabetLength = this.alphabet.length;
    private char initialPosition = 'a';
    private int position = 0;
    private char notch = 'c';
  
    public Rotor(char[] rotorWiring, char initialPosition, char notch) {
        this.rotorWiring = rotorWiring;
        this.notch = notch;
        this.initialPosition = initialPosition;
        this.position = (initialPosition - 'a') % this.alphabetLength;
    }
  
    public Rotor(char[] rotorWiring, char[] alphabet, char initialPosition, char notch) {
        this.rotorWiring = rotorWiring;
        this.initialPosition = initialPosition;
        this.notch = notch;
        this.alphabet = alphabet;
        this.alphabetLength = alphabet.length;
        this.position = (initialPosition - 'a') % this.alphabetLength;
    }
  
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
  
    public void rotate() {
      this.position = (this.position + 1) % this.alphabetLength;
    }
  
    /**
    * Checks if the rotation would result in meeting the this.Notch; which would rotate its
    * neighbor too.
    *
    * @param
    * @return boolean
    */
    public boolean notchMatch () {
      // return this.RotorWiring[(this.Position + 1) % this.RotorWiring.length] == this.RotorWiring[this.Notch - 'a'];
      return this.rotorWiring[(this.position + 1) % this.rotorWiring.length] == this.notch;
  
    }
  
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
  
  