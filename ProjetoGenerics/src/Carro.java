
public class Carro {
	private String marca;
	private int ano;
	private double preco;
	public Carro(String marca, int ano, double preco) {
		super();
		this.marca = marca;
		this.ano = ano;
		this.preco = preco;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Carro [marca=" + marca + ", ano=" + ano + ", preco=" + preco + "]";
	}
}
