// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

import java.util.ArrayList;
import java.util.List;

public class Rotors {
    private Rotor III = new Rotor(("BDFHJLCPRTXVZNYEIWGAKMUSQO".toLowerCase()).toCharArray(), 'g', 'v');
    private Rotor II =  new Rotor(("AJDKSIRUXBLHWTMCQGZNPYFVOE".toLowerCase()).toCharArray(), 'o', 'v');
    private Rotor I =   new Rotor(("EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase()).toCharArray(), 'd', 'v');

    private Reflector reflector = new Reflector();

    List<Rotor> RotorConfiguration = new ArrayList<>();
    public Rotors() {
      this.RotorConfiguration.add(this.III); 
      this.RotorConfiguration.add(this.II);
      this.RotorConfiguration.add(this.I);
    }

    public int plugIn(int n) {
      Rotor currentRotor;
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
      return n;
    }

    private void modifySetOfRotors (int positionCurrentRotor) {
      // NOTE(Andrew) DO NOT DELETE... functional programming is the way to go
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
