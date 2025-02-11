package br.com.meli.numerosromanos.service;

import org.springframework.stereotype.Service;

import br.com.meli.numerosromanos.exception.OutOfRangeException;

@Service
public class Conversor {

	private String unityRoman[] = {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	private String dezenRoman[] = {"","X","XX","XXX","XL","L"};
	
	public String convertToRoman(Integer number) {
		if (number <=0 || number > 50) {
			throw new OutOfRangeException("Invalid value");
		}
		return dezenRoman[number/10] + unityRoman[number % 10];
	}
}
