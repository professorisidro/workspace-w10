package br.com.meli.apiveiculos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.meli.apiveiculos.model.Endereco;
import reactor.core.publisher.Mono;

@Service
public class CEPService {
	
	public Endereco consultarCEP(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://viacep.com.br/ws/"+cep+"/json/";
		System.out.println(url);
		Endereco end = restTemplate.getForObject(url, Endereco.class);
		 

		return end;
		
	}
	
	public Mono<Endereco> consultarCepAssinc(String cep) {
		WebClient webClient = WebClient.builder()
				                       .baseUrl("https://viacep.com.br")
				                       .build();
		
		Mono<Endereco> res = webClient.get().uri("/ws/"+cep+"/json/").retrieve().bodyToMono(Endereco.class);
		return res;
		
	}

}
