package br.com.sis.rh.apiprogramaformacao.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.sis.rh.apiprogramaformacao.core.repository.UsuarioAcessoRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioAcessoRepository usuarioAcessoRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// Configurações de Autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Esse comando define o encriptador de Senhas
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// Método para liberar acesso para a URL /relatorios e /relatorios/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/relatorios").permitAll()
				.antMatchers("/relatorios/*").permitAll()
				.antMatchers("/conclusoes/*/*/*").permitAll()
				.antMatchers("/api/relatorio-alura/**").permitAll()
				.antMatchers("/api/relatorio-avaliacao/**").permitAll()
				.antMatchers("/investimentos/**").permitAll()
				.antMatchers("/investimentoInstrutores/**").permitAll()
				.antMatchers("/investimentoInstrutores/**").permitAll()
                .antMatchers("/auth/*").permitAll()
                .anyRequest().permitAll()
                .and().cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, usuarioAcessoRepository), UsernamePasswordAuthenticationFilter.class);
	}
}
