package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;

public class CadastroParticipanteForm {
	private String cpf;
	private String instituicaoEnsino;
	private String curso;
	private LocalDate terminoGraduacao;
	private Remuneracao remuneracao;
	private Programa nomeTurma;
	private Candidato candidato;
	private Long idRemunaracao;
	private Long idProcessoSeletivo;
	private Long idCandidato;
	private Long idPrograma;

	public CadastroParticipanteForm() {

	}

	public CadastroParticipanteForm(String cpf, String instituicaoEnsino, String curso, LocalDate terminoGraduacao,
			Long idRemunaracao, Long idProcessoSeletivo, Long idCandidato, Long idPrograma) {
		super();
		this.cpf = cpf;
		this.instituicaoEnsino = instituicaoEnsino;
		this.curso = curso;
		this.terminoGraduacao = terminoGraduacao;
		this.idRemunaracao = idRemunaracao;
		this.idProcessoSeletivo = idProcessoSeletivo;
		this.idCandidato = idCandidato;
		this.idPrograma = idPrograma;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public LocalDate getTerminoGraduacao() {
		return terminoGraduacao;
	}

	public void setTerminoGraduacao(LocalDate terminoGraduacao) {
		this.terminoGraduacao = terminoGraduacao;
	}

	public Remuneracao getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(Remuneracao remuneracao) {
		this.remuneracao = remuneracao;
	}

	public Programa getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(Programa nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Long getIdRemunaracao() {
		return idRemunaracao;
	}

	public void setIdRemunaracao(Long idRemunaracao) {
		this.idRemunaracao = idRemunaracao;
	}

	public Long getIdProcessoSeletivo() {
		return idProcessoSeletivo;
	}

	public void setIdProcessoSeletivo(Long idProcessoSeletivo) {
		this.idProcessoSeletivo = idProcessoSeletivo;
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

	public static Participante converter(CadastroParticipanteForm cadastroParticipanteForm) {
		Participante participante = new Participante();
		participante.setCpf(cadastroParticipanteForm.getCpf());
		participante.setFaculdade(cadastroParticipanteForm.getInstituicaoEnsino());
		participante.setCurso(cadastroParticipanteForm.getCurso());
		participante.setDataFinal(cadastroParticipanteForm.getTerminoGraduacao());
		participante.setRemuneracao(cadastroParticipanteForm.getRemuneracao());
		participante.setPrograma(cadastroParticipanteForm.getNomeTurma());
		participante.setCandidato(cadastroParticipanteForm.getCandidato());
		participante.getPrograma().setProcessoSeletivo(participante.getCandidato().getProcessoSeletivo());

		return participante;
	}

}
