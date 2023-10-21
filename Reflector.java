import java.util.HashMap;

public class Reflector {
	// reflector is a hash map from char to char
	char[] alphabet   = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	char[] reflectorA = "EJMZALYXVBWFCRQUONTSPIKHGD".toLowerCase().toCharArray();
	char[] reflectorB = "YRUHQSLDPXNGOKMIEBFZCWVJAT".toLowerCase().toCharArray();
	HashMap<Character, Character> reflector = new HashMap<>();

	/**Default constructor, will configure to B
	*/
	public Reflector () {
		this.configure(this.reflectorB);
	}

	/**Overloaded constructor, given a reflector type, it will configure to it
	* if and only if found.
	* @param  r The type of reflector's alphabet to configure.
	* @throws IllegalArgumentException If the given reflector type does not exist.
	*/
	public Reflector (String r) {
		switch (r) {
			case "reflectorA":
				this.configure(reflectorA);
				break;
			case "reflectorB":
				this.configure(reflectorB);
				break;
			default:	
				throw new IllegalArgumentException("Invalid Reflector type");

		}
	}

	/**Given a wire/letter substitute/reflect it to another letter based on the
	* pre-configured settings.
	* @param  letterWire the wire/letter that is to be reflected.
	* @return the corresponding subsituted wire/letter.
	*/
	public int plugIn (int letterWire) {
		char c = (char)(letterWire + 'a');
		char n = this.reflector.get(c);
		return n - 'a';
	}

	/**Given a reflector wire configuration creates a hashmap that will subsitute a letter for
	* another.
	* @param  reflectorWiring is the wiring configuration of the reflector as an array of characte.
	*/
	private void configure(char[] reflectorWiring) {
		reflector.clear();
		for (int i = 0; i < alphabet.length; i++) {
		this.reflector.put(this.alphabet[i], reflectorWiring[i]);
		}
	}
}
