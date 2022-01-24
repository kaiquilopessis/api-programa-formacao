package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeTurmaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaAtualizaForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
@SpringBootTest
class ProgramaServiceTest {
	
	@Autowired
	private ProgramaService programaService;
	@Autowired
	private ProcessoSeletivoRepository repository;
	private Long id = new Long(55);
	//private ProcessoSeletivoService processo = new ProcessoSeletivo();
	

	@Test
	public void retornaListaDeProgamas() {
		assertNotNull(programaService.getProgramaList());
	}
	
	@Test
	public void retornaProgramaPeloId() {
		assertSame(Programa.class, programaService.getProgramaPorId(id).getClass());
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void salvaONovoPrograma() {
		Programa programa = new Programa();
		ProcessoSeletivo processoSeletivo = repository.findByNome("Teste JUnit");
		
		programa.setProcessoSeletivo(processoSeletivo);
		programa.setDataFim(LocalDate.now());
		programa.setDataInicio(LocalDate.now());
		programa.setId(59);
		programa.setNomeTurma("JUnit");
		programa.setStatus("EM_ANDAMENTO");
		
		assertEquals(ResponseEntity.ok().build().getStatusCode(), programaService.salva(programa).getStatusCode());
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void atualizaOFormularioDoPrograma() {
		
		ProgramaAtualizaForm programaAtualizado = new ProgramaAtualizaForm();
		programaAtualizado.setDataFim(LocalDate.now());
		programaAtualizado.setDataInicio(LocalDate.now());
		programaAtualizado.setInstrutor("Kaiqui Lopes");
		programaAtualizado.setTurma("Formaçãoteste");
		programaAtualizado.setId(Long.valueOf(55));

		assertEquals(ResponseEntity.ok().build().getStatusCode(), programaService.atualizaPrograma(programaAtualizado).getStatusCode());
	}
	
	@Test
	public void buscarATurmaPeloNomeDoProcessoSeletivo() {
		List<TurmaDto> programa = programaService.buscarTurmasbyNomeProcesso("Teste F");
		assertNotNull(programa);
	}
	
	@Test
	public void buscarATurmaPeloIdDoProcessoSeletivo() {
		List<TurmaDto> turma = programaService.buscarTurmasbyProcesso(id);
		assertNotNull(turma);
	}
	
	@Test
	@Transactional
	public void buscarATurmaPeloId() {
		assertSame(NomeTurmaCandidatoDto.class, programaService.getTurmaPorId(id).getClass());
	}
	
}
