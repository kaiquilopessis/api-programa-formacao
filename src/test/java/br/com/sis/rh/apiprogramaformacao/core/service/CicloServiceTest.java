package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloProgressivoForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;

/**
 * Classe responsável pelos testes do Service CicloService.
 *
 * @author Felipe Salmazo
 */

@SpringBootTest
public class CicloServiceTest {

	@Autowired
	private CicloService cicloService;

	private String cpf = "74173683014";

	private static CicloFinalForm cicloFinalForm = new CicloFinalForm();

	private static CicloProgressivoForm cicloProgressivoForm = new CicloProgressivoForm();

	@BeforeAll
	public static void executarAntesDeTodos() throws IOException {
		cicloFinalForm.setResultado(ResultadoCiclo.EFETIVADO);
		cicloFinalForm.setDataAlteracao("2022-02-21");
		cicloFinalForm.setComprovante(new MockMultipartFile("file", new ByteArrayInputStream("Teste".getBytes())));
		cicloFinalForm.setCargoEfetivado("Analista de sistemas");
		cicloFinalForm.setCampoObservacao("nenhuma");

		cicloProgressivoForm.setCargo("Estagiario");
		cicloProgressivoForm.setComprovante(new MockMultipartFile("file", new ByteArrayInputStream("Teste".getBytes())));
		cicloProgressivoForm.setDataAlteracao("2022-07-25");
		cicloProgressivoForm.setResultado(ResultadoCiclo.REAJUSTE_SALARIO);
	}

	@Test
	public void deveriaRetornarOsCiclosEmFormaDeLista() {
		assertNotNull(cicloService.listarConclusoes(this.cpf));
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaCadastrarCicloFinal() {
		UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
		URI uriPath = uri.path("/conclusoes/registrocicloprogressivo").buildAndExpand().toUri();
		assertEquals(ResponseEntity.created(uriPath).build().getStatusCode(),cicloService.registrarCicloFinal(cpf, cicloFinalForm, uri).getStatusCode());
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaCadastrarCicloProgressivo() {
		UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
		URI uriPath = uri.path("/conclusoes/registrociclofinal").buildAndExpand().toUri();
		assertEquals(ResponseEntity.created(uriPath).build().getStatusCode(),cicloService.registrarCicloProgressivo(cpf, cicloProgressivoForm, uri).getStatusCode());
	}
	
	@Test
	public void deveriaRetornarListaRemuneracao() {
		assertNotNull(cicloService.listarRemuneracao());
	}
	
	@Test
	@Transactional
	public void deveriaFazerDownload() {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), cicloService.download(Long.valueOf("2")).getStatusCode());
	}

}
