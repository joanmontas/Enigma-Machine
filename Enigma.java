// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class Enigma {
    Rotors rt = new Rotors();
    EntryWheel ew = new EntryWheel();
    public Enigma() {
    }

    public String encrypt(String plainText) {
        String sec = "";
        char c;
        int n;
        for (int i = 0; i < plainText.length(); i++) {
            c = plainText.charAt(i);
            n = this.ew.plugIn(c);
            n = this.rt.plugIn(n);
            c = this.ew.plugOut(n);
            sec = sec + c;
        }
        return sec;
    }
}
