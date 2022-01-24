package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProcessoSeletivoForm;
@SpringBootTest
class ProcessoSeletivoServiceTest {
	
	@Autowired
	private ProcessoSeletivoService processoSeletivoService;

	@Test
	public void deveriaExibirListaDosProcessosSeletivo() {
		assertNotNull(processoSeletivoService.getExibeListaDeProcessos());
	}
	
	@Test
	public void deveriaListarProcesso() {
		assertNotNull(processoSeletivoService.listarProcesso());
	}
	
	@Test
	public void fazOGetDoProcessoSeletivo() {
		assertEquals(ProcessoSeletivoDto.class, processoSeletivoService.getProcessoSeletivo(Long.valueOf(44)).getClass());
	}

	@Test 
	public void deveriaRetornarNomeDoProcessoSeletivo() {
		assertEquals(ProcessoSeletivoNomeDto.class, processoSeletivoService.getNomeProcessoSeletivo(Long.valueOf(44)).getClass());
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void deveriaAtualizarProcessoSeletivoExistente() {
		AtualizaProcessoSeletivoForm atualizarForm = new AtualizaProcessoSeletivoForm();
		atualizarForm.setDataInicio(LocalDate.now());
		atualizarForm.setDataFim(LocalDate.now());
		atualizarForm.setNome("Teste JUnit");
		atualizarForm.setNomeInstrutor("Kaiqui Lopes");
		atualizarForm.setQtdAprendizes(12);
		atualizarForm.setQtdEstagiario(13);
		atualizarForm.setStatus("FINALIZADA");
		
		
		assertEquals(ProcessoSeletivo.class, processoSeletivoService.atualizaProcessoExistente(atualizarForm, Long.valueOf(44)).getClass());
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void deveriaCriarUmNovoProcessoSeleitivo() {
		ProcessoSeletivoForm form = new ProcessoSeletivoForm();
		form.setNome("Processo JUnit");
		form.setDataInicio(LocalDate.now());
		form.setDataFim(LocalDate.now());
		form.setNomeInstrutor("Kaiqui Lopes");
		form.setQtdAprendizes(12);
		form.setQtdTrainees(11);
		form.setQtdEstagiario(13);
		
		assertEquals(ProcessoSeletivo.class, processoSeletivoService.criaNovoProcessoSeletivo(form).getClass());
	}
	
	@Test
	public void deveriaBuscarProgramas() {
		assertNotNull(processoSeletivoService.buscaProgramas());
	}
}
