package br.com.meli.hospital.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticConfiguration extends ElasticsearchConfiguration{

	@Value("${elastic.username}")
	private String username;
	
	@Value("${elastic.password}")
	private String password;
	
	@Value("${elastic.host}")
	private String host;
	
	@Value("${elastic.ssl_certificate}")
	private String certificate;

	@Override
	public ClientConfiguration clientConfiguration() {
		// TODO Auto-generated method stub
		return ClientConfiguration.builder()
					.connectedTo(host)
					.usingSsl(certificate)
					.withBasicAuth(username, password)
					.build();
	}
}
