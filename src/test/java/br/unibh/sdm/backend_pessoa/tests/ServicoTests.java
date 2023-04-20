package br.unibh.sdm.backend_pessoa.tests;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.Optional;

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

import br.unibh.sdm.backend_pessoas.entidades.Servico;
import br.unibh.sdm.backend_pessoa.persistencia.ServicoRepository;

/**
 * Classe de testes para a entidade Servico.
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
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, ServicoTests.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicoTests {

    private static Logger LOGGER = LoggerFactory.getLogger(ServicoTests.class);
	    
    @Configuration
	@EnableDynamoDBRepositories(basePackageClasses = { ServicoRepository.class })
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
	private ServicoRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {
		LOGGER.info("Criando objetos...");

		Servico c1 = new Servico("1", "1", "Corte", 15.32);
		Servico c2 = new Servico("2", "2", "Barba", 10.32);
		Servico c3 = new Servico("3", "3", "Corte e Barba", 25.32);

		repository.save(c1);
		repository.save(c2);
		repository.save(c3);
		
		Iterable<Servico> lista = repository.findAll();
		assertNotNull(lista.iterator());
		for (Servico Servico : lista) {
			LOGGER.info(Servico.toString());
		}
		LOGGER.info("Pesquisado um objeto");
		Optional<Servico> result = repository.findById("1");

		if(result.isEmpty())
            LOGGER.info("Encontrado");
        else
		    LOGGER.info("Não encontrado");
	}
	
	@Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo objetos...");
		Optional<Servico> result = repository.findById("1");
        String x = "";
		if (!result.isEmpty()) {
			LOGGER.info("Excluindo Servico id = "+result.get().getId());
            x = result.get().getId();
            repository.delete(result.get());
		}
		result = repository.findById(x);
		if(result.isEmpty())
            LOGGER.info("Erro na exclusão");
        else
		    LOGGER.info("Excluido com sucesso");
	}
	
	
}