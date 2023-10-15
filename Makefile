MAIN = MainEnigma
SOURCES = Enigma.java PlugBoard.java Rotors.java Reflector.java MainEnigma.java

compileandrun:
	javac $(SOURCES)
	java $(MAIN)

clean:
	rm -f *.class

