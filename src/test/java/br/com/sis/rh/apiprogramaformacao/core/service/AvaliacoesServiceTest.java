package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.net.URI;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.form.AvaliacaoDesempenhoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AvaliacoesForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.Avaliacao;
import br.com.sis.rh.apiprogramaformacao.core.enums.Parecer;

/**
 * Classe responsável pelos testes do Service AvaliacoesService.
 *
 * @author Felipe Salmazo
 */

@SpringBootTest
public class AvaliacoesServiceTest {

	@Autowired
	private AvaliacoesService avaliacoesService;
	
	private static AvaliacoesForm form = new AvaliacoesForm();
	
	private static AvaliacaoDesempenhoForm avaliacaoDesempenhoForm = new AvaliacaoDesempenhoForm();

	@BeforeAll
	public static void executaAntesDeTodos() {
		form.setNotaLideranca(new BigDecimal(10));
		form.setNotaNegocios(new BigDecimal(10));
		form.setNotaPraticasAgeis(new BigDecimal(10));
		form.setNotaTecnica(new BigDecimal(10));
		
		avaliacaoDesempenhoForm.setAdaptacao(new BigDecimal(4));
		avaliacaoDesempenhoForm.setApPratica(new BigDecimal(4));
		avaliacaoDesempenhoForm.setAvaliacao(Avaliacao.FORAM_SUPERADAS);
		avaliacaoDesempenhoForm.setCapTecnica(new BigDecimal(4));
		avaliacaoDesempenhoForm.setComunicabilidade(new BigDecimal(4));
		avaliacaoDesempenhoForm.setCooperacao(new BigDecimal(4));
		avaliacaoDesempenhoForm.setDedicacao(new BigDecimal(4));
		avaliacaoDesempenhoForm.setDisciplina(new BigDecimal(4));
		avaliacaoDesempenhoForm.setIniciativa(new BigDecimal(4));
		avaliacaoDesempenhoForm.setOrganizacao(new BigDecimal(4));
		avaliacaoDesempenhoForm.setParecer(Parecer.APROVADO);
		avaliacaoDesempenhoForm.setQualidade(new BigDecimal(4));
		avaliacaoDesempenhoForm.setResponsabilidade(new BigDecimal(4));
		avaliacaoDesempenhoForm.setSociabilidade(new BigDecimal(4));
		
		form.setAvaliacaoDesempenhoForm(avaliacaoDesempenhoForm);
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaSalvarAvaliacao() {
		UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
		URI uriPath = uri.path("/avaliacoes/novo").buildAndExpand().toUri();
		assertEquals(ResponseEntity.created(uriPath).build().getStatusCode(), avaliacoesService.cadastrar("33092410840", form, uri).getStatusCode());
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaExcluirUmaAvaliacao() {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), avaliacoesService.deletar(9L).getStatusCode());
	}
	
	@Test
	@Transactional
	public void deveriaListarAsNotas() {
		assertNotNull(avaliacoesService.listarNotas("33092410840"));
	}
	
	@Test
	@Transactional
	public void deveriaListarAsNotasDeDesempenho() {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), avaliacoesService.listarAvaliacaoDesempenho(115L).getStatusCode());
	}
}
