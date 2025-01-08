
public class MySQLDB implements InterfaceBD{

	@Override
	public void conectar() {
		System.out.println("Conectando no MySQL Server...");		
	}

	@Override
	public void desconectar() {
		System.out.println("Desconectando do MySQL Server...");		
	}

	@Override
	public void executar(String comando) {
		System.out.println("mysql> "+comando);
		
	}

}
