
public class MainClass {
	public static void main(String[] args) {
		Produto p = new Produto(1,"Mouse", 50.0);
		
//		p.setCodigo(2);
//		p.setDescricao("Computador");
//		p.setPreco(1000.0);
		
		System.out.println(p.getCodigo()+ " - "+p.getDescricao() + " - " + p.getPreco());
		
		Produto p2 = p;
		
		p2.setPreco(100);
		
		System.out.println(p.getCodigo()+ " - "+p.getDescricao() + " - " + p.getPreco());
		
		String s1, s2;
		String i1, i2;
		i1 = "oi";
		i2 = "oi";
		
		s1 = new String("Oi, quer tc?");
		s2 = new String("Oi, quer tc?");
		
		if (s1.equals(s2)) {
			System.out.println("Strings iguais");
		}
		else {
			System.out.println("Strings diferentes");
		}
		
		
		/*--------------------------------------*/
		ContaEspecial c1 = new ContaEspecial("isidro",1234,1000.0, 800.0);
		
		System.out.println(c1);
		if (c1.debitar(1500)) {
			System.out.println("Debito efetuado");
		}
		else {
			System.out.println("Saldo insuficiente");
		}
		
		System.out.println(c1);
		
		
		ContaBancaria c = new ContaEspecial("Jose",9876,5000,1000);
		System.out.println(c);
		
		
	}
}
