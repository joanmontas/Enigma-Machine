// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Rotor {
  private char[] RotorWiring;
  private int Position = 0;
  private char Notch = 'a';

  public Rotor (char[] rotorWiring, int startPosition, char notch) {
    this.RotorWiring = rotorWiring;
    this.Position = startPosition;
    this.Notch = notch;
  }


  /**
  * Checks if the rotation would result in meeting the this.Notch; which would rotate its
  * neighbor too.
  *
  * @param
  * @return boolean
  */
  public boolean notchMatch () {
    return this.RotorWiring[(this.Position + 1) % this.RotorWiring.length] == this.Notch;
  }

  /**
  * Perform a single rotation of the wheel, updating its Position i.e the current offset
  * that allows a 1-to-1 correspondence from the wire to its rotated position
  *
  * @param
  * @return void
  */
  public void rotate () {
    // increment the position by 1 and avoids out of range via
    // modulus of the given alphabet
    this.Position = (this.Position + 1) % (this.RotorWiring.length);
  }

  /**
  * Given a wire/letter substitute is value with the current letter at that position
  *
  * @param letterWire is the wire/letter we want to substitute 
  * @return char the substituted value
  */
  public char plugIn(char letterWire) {
    // this.Position acts as the offset done by the rotation
    return this.RotorWiring[(letterWire - 'a' + this.Position) % this.RotorWiring.length ];
  }
}
