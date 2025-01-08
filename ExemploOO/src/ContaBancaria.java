
public class ContaBancaria {
	protected String titular;
	protected int    numConta;
	protected double saldo;
	
	public ContaBancaria(String titular, int numConta, double saldo) {
		super();
		this.titular = titular;
		this.numConta = numConta;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	public boolean debitar(double valor) {
		if (valor <= saldo) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ContaBancaria [titular=" + titular + ", numConta=" + numConta + ", saldo=" + saldo + "]";
	}
	
	
	
}
