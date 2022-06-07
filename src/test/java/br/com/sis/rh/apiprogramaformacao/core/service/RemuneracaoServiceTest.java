package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaRemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.RemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.cargos.RemuneracaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.cargos.RemuneracaoService;

@SpringBootTest
class RemuneracaoServiceTest {

	@Autowired
	private RemuneracaoService remuneracaoService;

	@Autowired
	private RemuneracaoRepository repository;

	@Test
	public void retornaListaDeTodasAsRenuneracoes() {
		assertNotNull(remuneracaoService.listaTodasRemuneracoes());
	}

	@Test
	public void deveriaExibirARemuneracaoPeloID() {
		assertSame(RemuneracaoDto.class, remuneracaoService.exibeRemuneracao(65L).getClass());
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void deveriaCadastrarUmaNovaRemuneracao() {
		RemuneracaoForm form = new RemuneracaoForm();
		form.setCargo("Estagiario");
		form.setBolsa(new BigDecimal("1200"));
		form.setBeneficio(new BigDecimal("450.00"));
		form.setConvenio(new BigDecimal("150.00"));
		form.setHoraExtra(new BigDecimal("200.00"));
		form.setBeneficioLegislacao(new BigDecimal("450.00"));
		form.setRemunEsporadica(new BigDecimal("130.00"));
		form.setRemunExtra(new BigDecimal("450.00"));
		form.setAlura(new BigDecimal("200"));

		assertEquals(Remuneracao.class, remuneracaoService.cadastraRemuneracao(form).getClass());

	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void deveriaAtualizarARemuneracao() {
		AtualizaRemuneracaoForm form = new AtualizaRemuneracaoForm();
		form.setCargo("Estagiario");
		form.setBolsa(new BigDecimal("1200"));
		form.setBeneficio(new BigDecimal("450.00"));
		form.setConvenio(new BigDecimal("150.00"));
		form.setHoraExtra(new BigDecimal("200.00"));
		form.setBeneficioLegislacao(new BigDecimal("450.00"));
		form.setRemunEsporadica(new BigDecimal("130.00"));
		form.setRemunExtra(new BigDecimal("450.00"));
		form.setAlura(new BigDecimal("200"));
		
		assertEquals(Remuneracao.class, remuneracaoService.atualizaRemuneracao(65L, form).getClass());

	}
	
	@Test
	public void deveriaBuscarOsCargos() {
		assertNotNull(remuneracaoService.buscarCargos());;
	}
}