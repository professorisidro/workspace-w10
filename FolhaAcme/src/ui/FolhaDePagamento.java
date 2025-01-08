package ui;

import java.util.ArrayList;

import model.Chefe;
import model.Comissionado;
import model.Empreiteiro;
import model.Funcionario;
import model.Horista;

public class FolhaDePagamento {
	public static void main(String[] args) {
		
		ArrayList<Funcionario> lista;
		
		lista = new ArrayList<Funcionario>();
		lista.add(new Chefe(1234,"Isidro",5000.0,25.0,800.0));
		lista.add(new Comissionado(1235,"Jao",2500.0, 35.0));
		lista.add(new Horista(1236,"Maria",200, 85.0));
		lista.add(new Empreiteiro(1237,"Pedro",3750.0));
		
		for(Funcionario f: lista) {
			System.out.println(f.getNumRegistro()+" - "+f.getNome()+ " - R$ "+f.calcularSalario());;
		}		
		
	}
}
