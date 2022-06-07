package br.com.sis.rh.apiprogramaformacao.api.config.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer{
	
	
	@Value("${url.base.auth.token}")
	private String baseUrlToken;
	
	@Value("${url.base.auth.client-id}")
	private String clientId;
	
	@Value("${url.base.auth.client-secret}")
	private String clientSecret;

	@Bean
	public Docket api() {
		ApiInfo info = new ApiInfoBuilder().title("api-programa-formacao").
				description("API para controle dos programas de formação da SIS").build();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(info).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.sis.rh.apiprogramaformacao"))
				.paths(PathSelectors.ant("/**")).build()
				.securitySchemes(Collections.singletonList(securityScheme()))
				.securityContexts(Collections.singletonList(securityContext()))
				.ignoredParameterTypes(ServletWebRequest.class)
				.globalOperationParameters(Arrays.asList(
							new ParameterBuilder().name("Authorization").description("Header para Token JWT")
							.modelRef(new ModelRef("string")).parameterType("header").required(false).build()));
	}
	
	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
				.clientId(clientId)
				.clientSecret(clientSecret)
				.scopeSeparator(" ")
				.useBasicAuthenticationWithAccessCodeGrant(true).build();
	}

	private SecurityScheme securityScheme() {
		return new OAuthBuilder()
				.name(clientId)
				.grantTypes(Arrays.asList(new ResourceOwnerPasswordCredentialsGrant(baseUrlToken)))
				.scopes(getScopes()).build();
	}
	
	private SecurityContext securityContext() {
		SecurityReference securityReference = SecurityReference.builder()
				.reference(clientId)
				.scopes(getScopes().toArray(new AuthorizationScope[0])).build();
		
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(securityReference))
				.forPaths(PathSelectors.any()).build();
	}
	
	private List<AuthorizationScope> getScopes() {
		return Arrays.asList(new AuthorizationScope("read", "Acesso de leitura"),
				new AuthorizationScope("write", "Acesso de escrita"));
	}
}
