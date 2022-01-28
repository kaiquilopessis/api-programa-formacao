package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeTurmaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.input.LoginInput;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.ad.ConnectAD;

@SpringBootTest
public class CandidatoServiceTest {

	@Autowired
	private CandidatoService candidatoService;

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaBuscarCandidatoPorId() {
		assertNotNull(candidatoService.buscaPorId(123L));
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaBuscarCandidatoAprovado() {
		assertNotNull(candidatoService.buscaCandidatoAprovado());
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void pegarTodosOsCandidatosDeUmaVaga() {
		List<ListaCandidatoDto> listaCandidato = candidatoService.listaTodosDeUmaVaga();
		assertNotNull(listaCandidato);
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	@Transactional
	public void deveriaAtualizarAsInformacoesDoCandidato() throws IOException {
		AtualizaCandidatoForm attCandidatoForm = new AtualizaCandidatoForm();

		attCandidatoForm.setNome("Slinky");
		attCandidatoForm.setTelefone("11998958081");
		attCandidatoForm.setFonteRecrutamento("Linkedin");
		attCandidatoForm.setDataAgendamento("2022-02-18");
		attCandidatoForm.setObservacao("Bom dia");
		attCandidatoForm.setStatus("APROVADO_2_FASE");
		attCandidatoForm.setTesteLogico(new BigDecimal(10));
		attCandidatoForm.setCurriculo(new MockMultipartFile("file", new ByteArrayInputStream("TesteCurriculo".getBytes())));
		attCandidatoForm.setDisc(new MockMultipartFile("file", new ByteArrayInputStream("TesteDisc".getBytes())));
		attCandidatoForm.setIdProcessoSeletivo((long) 44);
		attCandidatoForm.setEmail("emailSlinky@email.com");
		attCandidatoForm.setSemestreFaculdade("8");
		attCandidatoForm.setPeriodoCurso("noturno");
		attCandidatoForm.setDataConclusao("2023-12-20");
		attCandidatoForm.setDuracaoCurso("12");
		attCandidatoForm.setEndereco("minha casa 2");
		attCandidatoForm.setIndicacaoVaga("Dara");
		
		assertEquals(Candidato.class, candidatoService.atualizaCandidato( 123L, attCandidatoForm).getClass());
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveiraCriarUmCandidato() throws IOException  {
		CandidatoForm candidatoForm = new CandidatoForm();

		candidatoForm.setNome("Dara");
		candidatoForm.setTelefone("11998958180");
		candidatoForm.setFonteRecrutamento("Linkedin");
		candidatoForm.setDataAgendamento("2022-04-18");
		candidatoForm.setCurso("ADM");
		candidatoForm.setObservacao("ola");
		candidatoForm.setStatus("APROVADO_2_FASE");
		candidatoForm.setTesteLogico(new BigDecimal(10));
		candidatoForm.setCurriculo(new MockMultipartFile("file", new ByteArrayInputStream("TesteCurriculo".getBytes())));
		candidatoForm.setIdProcessoSeletivo((long) 44);
		candidatoForm.setEmail("emailDara@email.com");
		candidatoForm.setSemestreFaculdade("8");
		candidatoForm.setPeriodoCurso("noturno");
		candidatoForm.setDataConclusao("2023-12-20");
		candidatoForm.setDuracaoCurso("12");
		candidatoForm.setEndereco("minha casa");
		candidatoForm.setIndicacaoVaga("Slinky");

        assertEquals(Candidato.class, candidatoService.criaCandidato(candidatoForm).getClass());

	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void buscarOsCandidatosPelaFormacao() {
		List<ListaCandidatoDto> listaCandidatoPorFormacao = candidatoService.buscaCandidadoPorFormacao((long) 123);
		assertNotNull(listaCandidatoPorFormacao);
	}

	@Test
	@Transactional
	public void deveriaFazerDownloadCurriculo() {
	assertEquals(ResponseEntity.ok().build().getStatusCode(), candidatoService.downloadCurriculo(Long.valueOf("123")).getStatusCode());
	}

	@Test
	@Transactional
	public void deveriaFazerDownloadDisc() {
	assertEquals(ResponseEntity.ok().build().getStatusCode(), candidatoService.downloadDisc(Long.valueOf("123")).getStatusCode());
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaPegarOIdDoCandidato() {
		assertNotNull(candidatoService.buscaPorId(123L));
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaBuscarONomeDoPrograma() {
		assertNotNull(candidatoService.buscarNomePrograma(123L));
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaBuscarOProgramaPeloIdDoCandidato() {
		assertNotNull(candidatoService.buscarPrograma(123L));
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaBuscarAsTurmas() {
		List<NomeTurmaCandidatoDto> listaCandidatoPorTurma = candidatoService.buscarTurmas("Turma VI");
		assertNotNull(listaCandidatoPorTurma);
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaBuscarPorInstrutoresAtivos() {
		List<NomeInstrutorDto> listaInstrutoresAtivos = candidatoService.buscarInstrutoresAtivos();
		assertNotNull(listaInstrutoresAtivos);
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaMostrarOCargoNoModal() {
		assertNotNull(candidatoService.mostrarCargoModal(65L));
	}

	@Test
	@WithMockUser("testeUnitarioJUnit")
	public void deveriaMostrarATurmaNoModal() {
		assertNotNull(candidatoService.mostrarTurmaModal(58L));
	}

}
