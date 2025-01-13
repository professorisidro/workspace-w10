package br.com.meli.multilayer.validator;

import br.com.meli.multilayer.model.Veiculo;

public class VeiculoValidator {

	public static boolean isValid(Veiculo v) {
		return v.getMarca() != null && v.getModelo()!=null
				&& v.getCor() != null && v.getAno() != null
				&& v.getPreco() != null;
	}
}
