package br.com.meli.esportistas.model;

public class Esporte {
	private String nome;
	private String nivel;
	public Esporte(String nome, String nivel) {
		super();
		this.nome = nome;
		this.nivel = nivel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	

}
