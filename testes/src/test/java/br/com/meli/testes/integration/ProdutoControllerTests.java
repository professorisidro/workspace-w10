package br.com.meli.testes.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.testes.model.Produto;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTests {

	
	@Autowired
	private MockMvc mockMvc;
	
	@DisplayName("Testando incluir novo produto e esperando resultado de status 201")
	@Test
	public void shouldAddNewProductAndReturnStatusCreated() throws Exception {
		Produto p = new Produto(1,"Computador", 1000.0);
		ObjectMapper mapper = new ObjectMapper();
		String pJson = mapper.writeValueAsString(p);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
				                              .contentType(MediaType.APPLICATION_JSON)
				                              .content(pJson))
			   .andDo(MockMvcResultHandlers.print())
		       .andExpect(MockMvcResultMatchers.status().is(201));
				
	}
	

	@Test
	@DisplayName("Retorna Bad Request para produto com dados faltando")
	public void shouldNotAllowAddNewProductAndReturnStatusBadRequest() throws Exception {
		Produto i = new Produto(1,null,1000.0);
		ObjectMapper mapper = new ObjectMapper();
		String iJson = mapper.writeValueAsString(i);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
				                              .contentType(MediaType.APPLICATION_JSON)
				                              .content(iJson))
		       .andDo(MockMvcResultHandlers.print())
			   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	@DisplayName("Nao pode adicionar produto repetido")
	public void shouldNotAllowAddDuplicateProduct() throws Exception{
		Produto tmp = new Produto(999,"Teste",1000.0);
		Produto original = new Produto(999,"Teste",1000.0);
		ObjectMapper mapper = new ObjectMapper();
		
		String tmpJson = mapper.writeValueAsString(tmp);
		String origJson = mapper.writeValueAsString(original);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
				                              .contentType(MediaType.APPLICATION_JSON)
				                              .content(tmpJson))
			   .andDo(MockMvcResultHandlers.print());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
										      .contentType(MediaType.APPLICATION_JSON)
										      .content(origJson))
				.andExpect(MockMvcResultMatchers.status().is(409));		                              		                             
	}

	
	@Test
	@DisplayName("Nao pode aceitar produto com preco negativo")
	public void shouldNotAllowProductWithNegativePrice() throws Exception{
		Produto i = new Produto(1,"Computador",-1000.0);
		ObjectMapper mapper = new ObjectMapper();
		String iJson = mapper.writeValueAsString(i);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
				                              .contentType(MediaType.APPLICATION_JSON)
				                              .content(iJson))
		       .andDo(MockMvcResultHandlers.print())
			   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
		
}
