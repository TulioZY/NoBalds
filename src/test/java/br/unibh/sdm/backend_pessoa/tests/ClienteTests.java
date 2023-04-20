package br.unibh.sdm.backend_pessoa.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import br.unibh.sdm.backend_pessoas.entidades.Cliente;
import br.unibh.sdm.backend_pessoa.persistencia.ClienteRepository;

/**
 * Classe de testes para a entidade Cliente.
 *  <br>
 * Para rodar, antes sete a seguinte variável de ambiente: -Dspring.config.location=C:/Users/jhcru/sdm/
 *  <br>
 * Neste diretório, criar um arquivo application.properties contendo as seguitnes variáveis:
 * <br>
 * amazon.aws.accesskey=<br>
 * amazon.aws.secretkey=<br>
 * @author jhcru
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, ClienteTests.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTests {

    private static Logger LOGGER = LoggerFactory.getLogger(ClienteTests.class);
	    
    @Configuration
	@EnableDynamoDBRepositories(basePackageClasses = { ClienteRepository.class })
	public static class DynamoDBConfig {

		@Value("${amazon.aws.accesskey}")
		private String amazonAWSAccessKey;

		@Value("${amazon.aws.secretkey}")
		private String amazonAWSSecretKey;

		public AWSCredentialsProvider amazonAWSCredentialsProvider() {
			return new AWSStaticCredentialsProvider(amazonAWSCredentials());
		}

		@Bean
		public AWSCredentials amazonAWSCredentials() {
			return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
		}

		@Bean
		public AmazonDynamoDB amazonDynamoDB() {
			return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
					.withRegion(Regions.US_EAST_1).build();
		}
	}
    
	@Autowired
	private ClienteRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {
		LOGGER.info("Criando objetos...");
        int i= 100;
		int a = 101;
		int b = 102;
        Long l2=Long.valueOf(i);
		Long l3=Long.valueOf(a);
		Long l4=Long.valueOf(b);
		Cliente c1 = new Cliente(l2, "Tulipad", "joao@gmail.com", "3899998888", "675473248", "Thiago");
        Cliente c2 = new Cliente(l3, "Sir", "joao@gmail.com", "3899998888", "12443232", "Jorge");
		Cliente c3 = new Cliente(l4, "Braum", "joao@gmail.com", "3899998888", "98765432", "Jotaro");

		repository.save(c1);
		repository.save(c2);
		repository.save(c3);
		
		Iterable<Cliente> lista = repository.findAll();
		assertNotNull(lista.iterator());
		for (Cliente Cliente : lista) {
			LOGGER.info(Cliente.toString());
		}
		LOGGER.info("Pesquisado um objeto");
		List<Cliente> result = repository.findByCpf("CLIENTE_TESTE");
		assertEquals(result.size(), 3);
		LOGGER.info("Encontrado: {}", result.size());
	}
	
	@Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo objetos...");
		List<Cliente> result = repository.findByCpf("CLIENTE_TESTE");
		for (Cliente Cliente : result) {
			LOGGER.info("Excluindo Cliente id = "+Cliente.getId());
			repository.delete(Cliente);
		}
		result = repository.findByCpf("CLIENTE_TESTE");
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
	
	
}