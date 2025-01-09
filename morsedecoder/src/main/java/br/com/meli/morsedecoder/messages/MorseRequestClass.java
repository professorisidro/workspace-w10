package br.com.meli.morsedecoder.messages;

public class MorseRequestClass {
	private String morseCode;

	public MorseRequestClass(String morseCode) {
		super();
		this.morseCode = morseCode;
	}

	public String getMorseCode() {
		return morseCode;
	}
	
	
}
