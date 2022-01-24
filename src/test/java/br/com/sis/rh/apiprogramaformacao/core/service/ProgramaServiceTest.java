package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
@SpringBootTest
class ProgramaServiceTest {
	
	@Autowired
	private ProgramaService programaService;
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
	
//	@Test
//	public void salvaONovoPrograma() {
//		Programa programa = new Programa();
//		
//		assertEquals(Programa.class, programaService.salva(programa));
//	}
	
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
	
	public void buscarATurmaPeloId() {
		assertSame(Programa.class, programaService.getTurmaPorId(id));
	}
	
	@Test
	public void atualizaOFormularioDoPrograma() {
		
	}

}
