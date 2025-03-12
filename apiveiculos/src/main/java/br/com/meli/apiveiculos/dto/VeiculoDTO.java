package br.com.meli.apiveiculos.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record VeiculoDTO(@NotNull Integer id,
						 @NotNull String marca,
						 @NotNull String modelo,
						 @NotNull @Min(value = 1950) @Max(value=2025) Integer ano,
						 @NotNull String cor,
						 @NotNull @Positive Double preco) {

}
