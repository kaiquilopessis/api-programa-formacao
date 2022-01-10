package br.com.sis.rh.apiprogramaformacao.api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.sis.rh.apiprogramaformacao")).paths(PathSelectors.ant("/**")).build()
				.ignoredParameterTypes(LoginAD.class, UsuarioAD.class).globalOperationParameters(
						Arrays.asList(new ParameterBuilder().name("Authorization").description("Header para Token JWT")
								.modelRef(new ModelRef("string")).parameterType("header").required(false).build()));
	}

}
