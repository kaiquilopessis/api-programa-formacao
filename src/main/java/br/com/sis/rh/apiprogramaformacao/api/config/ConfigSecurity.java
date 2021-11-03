//package br.com.sis.rh.apiprogramaformacao.api.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class ConfigSecurity  extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	 http.authorizeRequests()
//	 .antMatchers(HttpMethod.GET, "/investimentoInstrutores/**" ).permitAll()
//	 .antMatchers(HttpMethod.POST, "/investimentoInstrutores/**").permitAll();
//	 
//		
//	}
//}