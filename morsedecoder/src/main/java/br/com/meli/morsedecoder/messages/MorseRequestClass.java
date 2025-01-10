package br.com.meli.morsedecoder.messages;

/* isso aqui seria o equivalente a um "Record"
  pois o record nada mais é do que uma classe que cria objetos imutáveis, 
  ou seja, criamos um objeto com valores para os atributos e só conseguimos
  consultar os atributos (não tem como alterar, para isso teríamos que criar
  novo objeto)
  porém do ponto de vista de tipos de dados, nada muda.
  */ 

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
