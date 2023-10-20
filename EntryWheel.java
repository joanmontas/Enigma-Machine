// Copyright Joan Montas & Andrew Bernal
// All rights reserved.
//
// License under GNU General Public License v3.0

public class EntryWheel {
    public EntryWheel() {
    }

    public int plugIn(char c) {
      return c - 'a';
    }

    public char plugOut(int n) {
      return (char)(n + 'a');
    }

}

