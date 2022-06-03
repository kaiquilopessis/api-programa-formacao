package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.naming.NamingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.com.sis.rh.apiprogramaformacao.core.ad.ConnectAD;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.AutenticacaoADService;

/**
 * Classe responsável pelos testes do Service AutenticacaoADService.
 *
 * @author Felipe Salmazo
 */

@SpringBootTest
public class AutenticacaoADServiceTest {

	@Autowired
	private AutenticacaoADService adService;

	@Autowired
	private ConnectAD ad;

	@Test
	public void deveriaAutenticarDevolvendoToken() throws NamingException {
		UsuarioAD usuarioAD = new UsuarioAD();
		usuarioAD = ad.getUser("blisboa", "sis@123");
		assertEquals(ResponseEntity.ok().build().getStatusCode(), adService.autenticacao(usuarioAD).getStatusCode());
	}

	@Test
	public void verificaOTOkenERetornaMensagem() {
		assertEquals("ERRO", adService.verificacao("tokenAleatorio"));
	}
}
