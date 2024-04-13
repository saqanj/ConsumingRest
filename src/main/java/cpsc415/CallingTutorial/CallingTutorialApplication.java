package cpsc415.CallingTutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class CallingTutorialApplication {

	private static final Logger log = LoggerFactory.getLogger(CallingTutorialApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CallingTutorialApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Value("${quoters_base_url}")
	private String quotersBaseUrl;

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					quotersBaseUrl + "/api/random", Quote.class);
			log.info(quote.toString());
		};
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run2(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					quotersBaseUrl + "/api/1", Quote.class);
			log.info(quote.toString());
		};
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run3(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					quotersBaseUrl + "/api/2", Quote.class);
			log.info(quote.toString());
		};
	}


	@Bean
	@Profile("!test")
	public CommandLineRunner run4(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					quotersBaseUrl + "/api/3", Quote.class);
			log.info(quote.toString());
		};
	}

}
