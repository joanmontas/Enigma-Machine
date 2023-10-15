// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Enigma {
  // Enigma encrypt and decrypt message
  // coordinating the components abstracted
  // as class.
  // These classes are private, keepig
  // user's message safe; away from the
  // implementation detail
  private PlugBoard plugboard;
  private Rotors rotors;

  // TODO(Andrew) Overload constructor to accept key:
  // public Enigma ([wheel1, wheel5, wheel3], [startat a, start at u, start p], [[plug t to x], [plug o to y]]) {
  // sanitize make sure that above is right
  //    throw new RuntimeException("Invalid key"); Thanks - Joan
  // NOTE(Joan) Perhaps make a class for the key itself in order to package it neartly


  public Enigma () {
    // TODO() generate a random key when use 
    // do not specify key
    this.plugboard = new PlugBoard();
    this.rotors = new Rotors();
  }

  /**
  * Orchestrate the 
  *
  * @param  plaintText plain text that is to be encrypted
  * @return String sec the cipherte culmination of substituting and reflecting via the
  *         t
  */
  public String EnigmaEncrypt (String plainText) {
    // NOTE(JoanMontas) orchestrate enigma's components
    // in order to achieve encryption
    plainText = plainText.toLowerCase();
    String sec = "";
    char c0;
    for (char c : plainText.toCharArray()) {
      c0 = plugboard.plugIn(c);
      c0 = rotors.plugIn(c0);
      c0 = plugboard.plugIn(c0);
      sec = sec + c0;
    }
    return sec;
  }
}
