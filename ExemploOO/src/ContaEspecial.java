
public class ContaEspecial extends ContaBancaria {
	private double limite;

	
	public ContaEspecial(String titular, int numeroConta, double saldo, double limite) {
		super(titular, numeroConta, saldo);
		this.limite = limite;
	}
	
	public boolean debitar(double valor) {
		if (super.saldo + this.limite >= valor) {
			super.saldo -= valor;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ContaEspecial [titular=" + titular + ", numConta=" + numConta + ", saldo=" + saldo + ", limite="
				+ limite + "]";
	}
	
	
}
