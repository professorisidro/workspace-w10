
public class MainClass {
	public static void main(String[] args) {
		
		InterfaceTeste it = new InterfaceTeste() {
			public void metodo(String parametro) {
				System.out.println("Criando uma implementação em Tempo real..."+parametro);
			}
		
		};
		
		InterfaceTeste it2 = (String parametro) -> {
		};
		
		it.metodo("teste");
		it2.metodo("teste");
	}
}
