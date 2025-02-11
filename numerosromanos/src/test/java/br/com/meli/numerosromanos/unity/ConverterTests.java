
package br.com.meli.numerosromanos.unity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.numerosromanos.exception.OutOfRangeException;
import br.com.meli.numerosromanos.service.Conversor;

@SpringBootTest
public class ConverterTests {

	@Autowired
	private Conversor conversor;
	
	public static Stream<Arguments> values(){
		return Stream.of(Arguments.of(1, "I"), 
				         Arguments.of(2, "II"),
				         Arguments.of(3, "III"), 
				         Arguments.of(4, "IV"),
				         Arguments.of(5, "V"), 
				         Arguments.of(6, "VI"),
				         Arguments.of(7, "VII"), 
				         Arguments.of(8, "VIII"),
				         Arguments.of(9, "IX"));
	}
	
	
	@ParameterizedTest
	@MethodSource("values")
	public void shoulConvertUnityNumber(Integer number, String output) {
		assertEquals(conversor.convertToRoman(number), output);	
	}
	
	@ParameterizedTest
	@CsvSource({"10, X",
			    "15,XV",
			    "22, XXII",
			    "37, XXXVII",
			    "45, XLV",
			    "50, L"})
	public void shouldConvertDecimalNumber(String strNumber, String output) {
		assertEquals(conversor.convertToRoman(Integer.parseInt(strNumber)),output);
	}
	
	@ParameterizedTest
	@CsvSource({"0, null",
		        "-1, null",
		        "80, null"})
	public void shouldNotAcceptOutOfRangeNumbers(String strNumber, String output) {
		assertThrows(OutOfRangeException.class, () -> {
			conversor.convertToRoman(Integer.parseInt(strNumber));
		});
	}
	
}
