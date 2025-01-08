
public class OracleDB implements InterfaceBD{

	@Override
	public void conectar() {
		System.out.println("Connecting on ORADB Server...");
	}

	@Override
	public void desconectar() {
		System.out.println("ORADB Server Logoff...");
	}

	@Override
	public void executar(String comando) {
		System.out.println("oradb> "+comando);
	}

}
