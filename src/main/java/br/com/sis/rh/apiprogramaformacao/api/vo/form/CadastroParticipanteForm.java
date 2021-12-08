package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.core.util.FormatterUtil;
import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import lombok.ToString;

public class CadastroParticipanteForm {
	private String cpf;
	private String instituicaoEnsino;
	private String curso;
	private String terminoGraduacao;
	private Long idRemuneracao;
	private Long idCandidato;
	private Long idPrograma;
	private String email;
	private MultipartFile tce;

	public CadastroParticipanteForm() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public CadastroParticipanteForm(String cpf, String instituicaoEnsino, String curso, String terminoGraduacao,
			Long idRemuneracao, Long idCandidato, Long idPrograma, String email, MultipartFile tce) {
		this.cpf = cpf;
		this.instituicaoEnsino = instituicaoEnsino;
		this.curso = curso;
		this.terminoGraduacao = terminoGraduacao;
		this.idRemuneracao = idRemuneracao;
		this.idCandidato = idCandidato;
		this.idPrograma = idPrograma;
		this.email = email;
		this.tce = tce;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getTerminoGraduacao() {
		return terminoGraduacao;
	}

	public void setTerminoGraduacao(String terminoGraduacao) {
		this.terminoGraduacao = terminoGraduacao;
	}

	public Long getIdRemuneracao() {
		return idRemuneracao;
	}

	public void setIdRemuneracao(Long idRemuneracao) {
		this.idRemuneracao = idRemuneracao;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getTce() {
		return tce;
	}

	public void setTce(MultipartFile tce) {
		this.tce = tce;
	}

	public static Participante converter(CadastroParticipanteForm cadastroParticipanteForm, Remuneracao remuneracao, Programa programa, Candidato candidato) throws IOException {
		Participante participante = new Participante();
		
		DateTimeFormatter  formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dataFormatada = LocalDate.parse(cadastroParticipanteForm.getTerminoGraduacao(), formatador);
		participante.setCpf(FormatterUtil.removerMascara(cadastroParticipanteForm.getCpf()));
		participante.setFaculdade(cadastroParticipanteForm.getInstituicaoEnsino());
		participante.setCurso(cadastroParticipanteForm.getCurso());
		participante.setDataFinal(dataFormatada);
		participante.setRemuneracao(remuneracao);
		participante.setPrograma(programa);
		participante.setCandidato(candidato);
		participante.getPrograma().setProcessoSeletivo(participante.getCandidato().getProcessoSeletivo());
		participante.setEmail(cadastroParticipanteForm.getEmail());
		participante.setStatus(StatusAtivo.ATIVO);
		participante.setTce(cadastroParticipanteForm.getTce().getBytes());
		return participante;
	}
}
