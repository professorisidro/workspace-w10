
public class GerenciadorDeGaragem {

	private Repositorio<Carro> g;

	public GerenciadorDeGaragem(Repositorio<Carro> g) {
		super();
		this.g = g;
	}
	
	public void update() {
		for (Carro c: g.getElementos()) {
			System.out.println(c.getMarca());
		}		
	}
	
	
}
