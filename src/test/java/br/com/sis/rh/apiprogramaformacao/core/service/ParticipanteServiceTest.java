package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
@SpringBootTest
class ParticipanteServiceTest {
	
	@Autowired
	private ParticipanteService service;

	@Test
	public void deveriaListarTodosOsParticipantes() {
		assertNotNull(service.todosParticipantes());
	}
	
	@Test
	public void deveriaBuscarParticipantePeloCpf() {
		assertNotNull(service.participanteCpf("74173683014").getClass());		
	}
	
	@Test
	public void deveriaFiltrarAListaDaFolha() {
		assertNotNull(service.listagemFiltroFolha("Formaçãoteste", "Java II"));;
	}
	
	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void deveriaCadastrarUmNovoFormularioDeFolhaDeParticipante() {
		FolhaForm form = new FolhaForm();
		form.setBeneficios("450");
		form.setCpf("74173683014");
		form.setDescricao("Testando folha");
		form.setEncargos("2000");
		form.setMesAno("2022-04-31");
		form.setRemuneracao("1200");
		
		assertEquals(ResponseEntity.ok().build().getStatusCode(), 
				service.cadastrar(form).getStatusCode());
		
	}
	
	@Test
	public void deveriaListarOsParticipantesPorCPF() {
		assertNotNull(service.listagemParticipantes("Formaçãoteste", "Java II"));
	}
	
	@Test
	@Transactional
	public void deveriaBuscarParticipantesPeloStatus() {
		assertNotNull(service.buscaPorStatus());
	}
	
}
