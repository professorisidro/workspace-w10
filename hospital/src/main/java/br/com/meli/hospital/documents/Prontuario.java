package br.com.meli.hospital.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@Document(indexName = "prontuarios_idx")
public class Prontuario {

	@Id
	private Integer numeroPaciente;
	private String  historico;
	
	
	public Integer getNumeroPaciente() {
		return numeroPaciente;
	}
	public void setNumeroPaciente(Integer numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	
	
}
