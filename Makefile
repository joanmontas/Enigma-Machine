MAIN = EnigmaMain
SOURCES = Enigma.java PlugBoard.java Rotors.java Reflector.java EnigmaMain.java

compileandrun:
	javac $(SOURCES)
	java $(MAIN)

clean:
	rm -f *.class

