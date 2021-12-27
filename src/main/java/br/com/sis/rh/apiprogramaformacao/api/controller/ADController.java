package br.com.sis.rh.apiprogramaformacao.api.controller;

import javax.naming.NamingException;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.input.LoginInput;
import br.com.sis.rh.apiprogramaformacao.core.ad.ConnectAD;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;

@RestController
@RequestMapping(value = "/api/ad", produces = MediaType.APPLICATION_JSON_VALUE)
public class ADController {
	
	private final ConnectAD ad;
	
	public ADController(ConnectAD ad) {
		this.ad = ad;
	}
	
	@PostMapping
	public UsuarioAD buscar(@Valid LoginInput login) throws NamingException {
		return ad.getUser(login.getMatricula(), login.getSenha());
	}
	
}
