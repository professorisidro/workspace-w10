
public class SistemaDeCadastros {
	public static void main(String[] args) {
		
		InterfaceBD ibd = new OracleDB();
//		InterfaceBD ibd = new MySQLDB();
		
		ibd.conectar();
		ibd.executar("Select * from TABELA");
		ibd.desconectar();
	}

}
