package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;
import br.com.sis.rh.apiprogramaformacao.core.service.AutenticacaoADService;

// Essa classe é o controller que recebe requisições para o retorno do Token JWT
@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

	@Autowired
	private AutenticacaoADService autenticacaoADService;

	// Esse método recebe as requisições e autentica os dados presentes no Body
	// Caso os dados (Usuario e Senha) coincidem com os presentes no BD, o método
	// retorna
	// o Token para utilização da API.
	public ResponseEntity autenticar(UsuarioAD usuarioAD) {
		return autenticacaoADService.autenticacao(usuarioAD);
	}

	// Esse método recebe o token armazenado no FrontEnd e retorna uma String com o
	// resultado
	// da verificação do Token
	@GetMapping("/{token}")
	public String verificaToken(@PathVariable String token) {
		return autenticacaoADService.verificacao(token);
	}

}
