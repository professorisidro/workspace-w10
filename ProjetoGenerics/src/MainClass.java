import java.util.Comparator;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		Repositorio<Carro> g = new Repositorio<Carro>();
		
		g.adicionar(new Carro("Xevrole", 1996, 5000.0));
		g.adicionar(new Carro("Peguete", 2000, 7500.0));
		g.adicionar(new Carro("Ronda  ", 1998, 6950.0));
				
		
		g.getElementos().stream()
			.sorted(Comparator.comparing((Carro c)-> c.getPreco()).reversed())
			.forEach(System.out::println);
		
		
		double somaDosPrecos = g.getElementos().stream().mapToDouble(Carro::getPreco).sum();
		System.out.println(somaDosPrecos);
		
		double mediaPrecos = g.getElementos().stream().mapToDouble(Carro::getPreco).average().getAsDouble();
		
		System.out.println(mediaPrecos);
		
		double maxPreco = g.getElementos().stream().mapToDouble(Carro::getPreco).max().getAsDouble();
		System.out.println(maxPreco);

		double minPreco = g.getElementos().stream().mapToDouble(Carro::getPreco).min().getAsDouble();
		System.out.println(minPreco);
		
		
	}
}
