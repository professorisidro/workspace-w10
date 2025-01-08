import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {

		try (Scanner teclado = new Scanner(System.in)){
		
			int a, b, r;
			System.out.println("digite o valor de a:");
			a = teclado.nextInt();
			System.out.println("digite o valor de b:");			
			b = teclado.nextInt();
			r = a / b;
			System.out.println("Resultado = " + r);			
			
			Produto p = new Produto();
			p.setId(-12345);
			p.setDescricao("computador");
			p.setPreco(2000.0);
			System.out.println(p);
			
		} 
		catch (IsiException ex) {
			System.out.println("Erro na regra de negocio - violacao na validacao dos dados "+ex.getMessage());
		}
		catch (ArithmeticException ex) {
			System.err.println("Ixe, seu valor B nao pode ser zero!");
			System.out.println(ex.getLocalizedMessage());
		}
		catch (InputMismatchException | NumberFormatException ex) {
			System.err.println("Ei, voce precisa digitar um valor inteiro");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}	
		catch (Exception ex) {
			System.err.println("Ixe deu ruim!");
			System.out.println(ex.getClass().getName());
			System.out.println(ex.getMessage());
		}
	}
}
