package br.com.meli.morsedecoder.service;

import java.util.HashMap;

public class MorseDecoder {
	private static HashMap<String, Character> morseMap = new HashMap<String,Character>() {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');

        put("-----", '0');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
    }};

    
    public static String decodeWord(String morseWord) {
    	StringBuilder str = new StringBuilder();
    	for (String morseCode: morseWord.split(" ")) {
    		str.append(morseMap.get(morseCode));
    	}
    	return str.toString();
    }
    
    public static String decodePhrase(String morsePhrase) {
    	StringBuilder str = new StringBuilder();
    	for (String morseWord: morsePhrase.split("   ")) {
    		str.append(decodeWord(morseWord)+ " ");
    	}
    	return str.toString().trim();
    }
}
