package br.com.sis.rh.apiprogramaformacao.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurantions extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/relatorio-alura/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/relatorio-avaliacao/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable();
	}
	
}
