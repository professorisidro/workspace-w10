package br.com.meli.testes.unity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.testes.handler.ConflictException;
import br.com.meli.testes.handler.MalformedProductException;
import br.com.meli.testes.model.Produto;
import br.com.meli.testes.repo.IProdutoRepo;
import br.com.meli.testes.services.ProdutoServiceImpl;

@SpringBootTest
public class ProdutoServiceTests {

	@InjectMocks
	private ProdutoServiceImpl service;
	
	
	@Mock
	private IProdutoRepo repo;
	
	private  Produto p;

	
	/*@BeforeEach
	public void setup() {
		p = new Produto(999,"Produto teste",1000.0);
		Mockito.when(repo.saveProduct(p)).thenReturn(p);
		Mockito.when(repo.findProductById(1)).thenReturn(null);
		Mockito.when(repo.findProductById(999)).thenReturn(p);
	}*/

	
	
	@Test
	@DisplayName("Adicionando produto corretamente")
	public void shouldAddNewProduct() {
		p = new Produto(1,"Computador",1500.0);
		Mockito.when(repo.saveProduct(p)).thenReturn(p);
		assertNotNull(service.save(p));
	}
	
	
	@Test
	@DisplayName("Nao pode adicionar produto faltando dados")
	public void shouldNotAddProductMissingInformations() {
		p = new Produto(1, null, 1000.0);
		assertThrows(MalformedProductException.class, () -> {
			service.save(p);
		});
	}
	
	@Test
	@DisplayName("Nao pode adicionar produto ja existente")
	public void shouldNotAddExistingProduct() {
		Produto tmp = new Produto(999,"Teste",100.0);
		service.save(tmp);
		p = new Produto(999, "Teste", 100.0);
		Mockito.when(repo.findProductById(999)).thenReturn(tmp);
		
		assertThrows(ConflictException.class, () ->{
			service.save(p);
		});
	}
	
	@Test
	@DisplayName("Nao pode permitir produto com preco negativo")
	public void shouldNotAllowNegativePrice() {
		p = new Produto(100,"Computador",-100.0);
		assertThrows(MalformedProductException.class, () -> {
			service.save(p);
		});
	}
}
