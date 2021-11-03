package br.com.sis.rh.apiprogramaformacao.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	// Método para liberar acesso para a URL /relatorios e /relatorios/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/relatorios").permitAll()
		.antMatchers(HttpMethod.GET, "/relatorios/*").permitAll()
		.antMatchers(HttpMethod.GET, "/conclusao").permitAll()
		.antMatchers(HttpMethod.GET, "/api/relatorio-alura/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/relatorio-avaliacao/**").permitAll()
		.antMatchers(HttpMethod.GET, "/investimentos/**").permitAll()
		.antMatchers(HttpMethod.GET, "/investimentoInstrutores/**" ).permitAll()
		.antMatchers(HttpMethod.POST, "/investimentoInstrutores/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable();;
	}	
}
