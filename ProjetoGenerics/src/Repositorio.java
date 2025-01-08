import java.util.ArrayList;
import java.util.List;

public class Repositorio<E>{
	
	private List<E> elementos;
	
	public Repositorio() {
		elementos = new ArrayList<E>();		
	}
	
	
	
	public List<E> getElementos() {
		return elementos.subList(0, elementos.size());
	}
	
	public void adicionar(E o) {
		this.elementos.add(o);
	}
	public boolean estaCheio() {
		return elementos.size() == 10;
	}
	public boolean estaVazia() {
		return elementos.isEmpty();
	}
	
	public E retirar() {
		return elementos.remove(elementos.size()-1);
	}


}
