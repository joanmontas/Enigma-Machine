// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.ArrayList;
import java.util.List;

 public class Rotors {
  // NOTE(JoanMontas) Using 1924's wiring configuration
  // TODO(Andrew) could you moduralize Rotors class?
  // overload the constructor in order to select which rotor
  // to use. Thanks - Joan
  private Rotor IC = new Rotor(("DMTWSILRUYQNKFEJCAZBPGXOHV".toLowerCase()).toCharArray(), 6, 'q');
  private Rotor IIC = new Rotor(("HQZGPJTMOBLNCIFDYAWVEUSRKX".toLowerCase()).toCharArray(), 23, 'e');
  private Rotor IIIC = new Rotor(("UQNTLSZFMREHDPXKIBVYGJCWOA".toLowerCase()).toCharArray(), 11, 'v');
  List<Rotor> RotorConfiguration = new ArrayList<>();
  private Reflector reflector;

  public Rotors () {
    // TODO(Andrew) Can you make this dynamic? Thanks - Joan
    this.RotorConfiguration.add(this.IC);
    this.RotorConfiguration.add(this.IIC);
    this.RotorConfiguration.add(this.IIIC);

    this.reflector = new Reflector();
  }

  /**
  * Given a character, pass along the rotors (rotate next rotor due to notch match) and rotate
  *
  * @param  letterWire is the specific wire/letter received from the PlugBoard.
  * @return the letterWire substituted 7 time (6 by rotors and 1 by reflector)
  */
  public char plugIn (char letterWire) {
    // TODO(Andrew) implemment rotors
    Rotor currentRotor;
    for (int i = 0; i < this.RotorConfiguration.size(); i++) {
      currentRotor = this.RotorConfiguration.get(i);
    }

    this.modifySetOfRotors(0);
    for (int i = 0; i < this.RotorConfiguration.size(); i++) {
      currentRotor = this.RotorConfiguration.get(i);
      letterWire = currentRotor.plugIn(letterWire);

    }
    letterWire = this.reflector.reflect(letterWire);
    for (int i = this.RotorConfiguration.size() - 1; i > -1; i--) {
      currentRotor = this.RotorConfiguration.get(i);
      letterWire = currentRotor.plugIn(letterWire);
    }
    return letterWire;
  }

  /**
  * A rotor could modify its neighbor to the right... so can the neighbor's neighbors...
  * we would have to recurse until we find a rotor that is not affect or reached the end.
  *
  * @param  currentRotor points to the current rotor and check if conditions are met
  * @return void
  */
  private void modifySetOfRotors (int positionCurrentRotor) {
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
