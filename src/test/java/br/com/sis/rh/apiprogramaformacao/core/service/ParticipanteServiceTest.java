package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaStatusParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CadastroParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.informacoesgerais.ParticipanteService;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import org.springframework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParticipanteServiceTest {
	
	@Autowired
	private ParticipanteService service;

	@Autowired
	private ParticipanteRepository participanteRepository;

	private static CadastroParticipanteForm cadastroParticipanteForm;
	private static AtualizaStatusParticipanteForm atualizaStatusParticipanteForm;
	private static AtualizaParticipanteForm atualizaParticipanteForm;

	@BeforeAll
	public static void deveriaRealizarAntesDeTodos () throws IOException {
		cadastroParticipanteForm = new CadastroParticipanteForm();
		cadastroParticipanteForm.setCpf("99892591003");
		cadastroParticipanteForm.setInstituicaoEnsino("Faculdade Teste");
		cadastroParticipanteForm.setCurso("Analise e desenvolvimento de sistemas");
		cadastroParticipanteForm.setIdRemuneracao(Long.parseLong("67"));
		cadastroParticipanteForm.setIdCandidato(Long.parseLong("133"));
		cadastroParticipanteForm.setIdPrograma(Long.parseLong("58"));
		cadastroParticipanteForm.setEmail("teste.teste@teste.com");
		cadastroParticipanteForm.setTce(new MockMultipartFile("file", new ByteArrayInputStream("Teste".getBytes())));
		cadastroParticipanteForm.setDataEntrega("2022-01-06");
		cadastroParticipanteForm.setDataInicio("2022-01-06");

		atualizaParticipanteForm = new AtualizaParticipanteForm();
		atualizaParticipanteForm.setNome("Testinho teste");
		atualizaParticipanteForm.setCpf("33092410840");
		atualizaParticipanteForm.setTelefone("(99) 9 9999-9999");
		atualizaParticipanteForm.setFonteRecrutamento("Testando");
		atualizaParticipanteForm.setNmFaculdade("Colégio teste");
		atualizaParticipanteForm.setCurso("Teste 123");
		atualizaParticipanteForm.setDataFimGraduacao("2022-01-07");
		atualizaParticipanteForm.setObservacao("Nenhuma teste 2");
		atualizaParticipanteForm.setEmail("email@teste.com.br");
		atualizaParticipanteForm.setTce(new MockMultipartFile("file", new ByteArrayInputStream("Teste".getBytes())));

		atualizaStatusParticipanteForm = new AtualizaStatusParticipanteForm(StatusAtivo.ATIVO, "33092410840");
	}

	@Order(1)
	@Test
	public void deveriaListarTodosOsParticipantes() {
		assertNotNull(service.todosParticipantes());
	}

	@Order(2)
	@Test
	public void deveriaBuscarParticipantePeloCpf() {
		assertNotNull(service.participanteCpf("74173683014").getClass());		
	}

	@Order(3)
	@Test
	public void deveriaFiltrarAListaDaFolha() {
		assertNotNull(service.listagemFiltroFolha("Formaçãoteste", "Java II"));;
	}

	@Order(4)
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

	@Order(4)
	@Test
	public void deveriaListarOsParticipantesPorCPF() {
		assertNotNull(service.listagemParticipantes("Formaçãoteste", "Java II"));
	}

	@Order(5)
	@Test
	@Transactional
	public void deveriaBuscarParticipantesPeloStatus() {
		assertNotNull(service.buscaPorStatus());
	}

	@Order(6)
	@Test
	public void deveriaBuscarParticipantePorId () {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), service.buscaPorId("33092410840").getStatusCode());
	}

	@Order(7)
	@Test
	@Transactional
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaCadastrarParticipante () throws IOException {
		int i = participanteRepository.findAll().size();
		service.cadastrarParticipante(cadastroParticipanteForm);
		if (i >= participanteRepository.findAll().size()) {
			Fail.fail("O teste falhou");
		}
	}

	@Order(8)
	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaAtualizarStatusDoParticipante () {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), service.atualizarStatus(atualizaStatusParticipanteForm).getStatusCode());
	}

	@Order(9)
	@Test
	@Transactional
	public void deveriaFiltrarParticipantes () {
		assertNotNull(service.filtrarParticipantes("Gustavo Juliano", "Formaçãoteste", "Java II"));
	}

	@Order(10)
	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaAtualizarParticipante () throws IOException {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), service.atualizarParticipante(atualizaParticipanteForm).getStatusCode());
	}

	@Order(11)
	@Test
	@Transactional
	public void deveriaBaixarTce () {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), service.downloadTce("33092410840").getStatusCode());
	}

	@Order(12)
	@Test
	@Transactional
	public void deveriaBaixarDisc () {
		assertEquals(ResponseEntity.ok().build().getStatusCode(), service.downloadDisc("33092410840").getStatusCode());
	}
}
