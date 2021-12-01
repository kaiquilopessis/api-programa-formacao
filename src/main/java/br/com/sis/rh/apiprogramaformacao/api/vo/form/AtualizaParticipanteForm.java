package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

public class AtualizaParticipanteForm {

	private String nome;
	private String cpf;
	private String telefone;
	private String fonteRecrutamento;
	private String nmFaculdade;
	private String curso;
	private LocalDate dataFimGraduacao;
	private String cargo;
	private String turma;
	private String observacao;
	private String email;
	private String nomeTurma;
	private String nomePrograma;

//	public Participante atualizar(String cpf, ParticipanteRepository participanteRepository,
//			ProgramaRepository programaRepository, ProcessoSeletivoRepository processoSeletivoRepository) {
//
//		Participante participante = participanteRepository.getById(cpf);
//
//		participante.getCandidato().setNome(this.nome);
//		participante.getCpf();
//		participante.getCandidato().getTelefone();
//		participante.getCandidato().setFonteRecrutamento(this.fonteRecrutamento);
//		participante.setFaculdade(this.nmFaculdade);
//		participante.setCurso(this.curso);
//		participante.setDataFinal(this.dataFimGraduacao);
//		participante.getRemuneracaoPrograma().setCargo(this.cargo);
//		participante.setPrograma(programa);
//		participante.getCandidato().setObservacao(this.observacao);
//		participante.setEmail(this.email);
//		participante.getPrograma().setProcessoSeletivo(processoSeletivo);
//
//		return participante;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFonteRecrutamento() {
		return fonteRecrutamento;
	}

	public void setFonteRecrutamento(String fonteRecrutamento) {
		this.fonteRecrutamento = fonteRecrutamento;
	}

	public String getNmFaculdade() {
		return nmFaculdade;
	}

	public void setNmFaculdade(String nmFaculdade) {
		this.nmFaculdade = nmFaculdade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public LocalDate getDataFimGraduacao() {
		return dataFimGraduacao;
	}

	public void setDataFimGraduacao(LocalDate dataFimGraduacao) {
		this.dataFimGraduacao = dataFimGraduacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

}
