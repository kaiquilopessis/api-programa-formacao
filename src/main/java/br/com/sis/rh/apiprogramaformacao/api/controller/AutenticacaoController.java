package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.openApi.AutenticacaoControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.core.service.AutenticacaoADService;

// Essa classe é o controller que recebe requisições para o retorno do Token JWT
@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController implements AutenticacaoControllerOpenApi{

	@Autowired
	private AutenticacaoADService autenticacaoADService;

	// Esse método recebe o token armazenado no FrontEnd e retorna uma String com o
	// resultado
	// da verificação do Token
	@Override
	@GetMapping("/{token}")
	public String verificaToken(@PathVariable String token) {
		return autenticacaoADService.verificacao(token);
	}

}
