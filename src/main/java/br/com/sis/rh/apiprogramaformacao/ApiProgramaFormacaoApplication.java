package br.com.sis.rh.apiprogramaformacao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiProgramaFormacaoApplication {

	private static final Logger LOGGER = LogManager.getLogger(ApiProgramaFormacaoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiProgramaFormacaoApplication.class, args);

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
	}

}
