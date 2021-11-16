package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

public class AtualizaParticipanteForm {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String fonteRecrutamento;
	private BigDecimal testeLogico;
	private String nmFaculdade;
	private String curso;
	private LocalDate dataFimGraduacao;
	private String cargo;
	private String turma;
	private String observacao;
	
	public Participante atualizar(String cpf, ParticipanteRepository participanteRepository, ProgramaRepository programaRepository) {
		Participante participante = participanteRepository.getById(cpf);
		Programa programa = programaRepository.findByNome(turma);
		
		participante.getCandidato().getNome();
		participante.getCpf();
		participante.getCandidato().getTelefone();
		participante.getCandidato().setFonteRecrutamento(this.fonteRecrutamento);
		participante.getCandidato().setTesteLogico(this.testeLogico);
		participante.setFaculdade(this.nmFaculdade);
		participante.setCurso(this.curso);
		participante.setDataFinal(this.dataFimGraduacao);
		participante.getRemuneracaoPrograma().setCargo(this.cargo);
		participante.setPrograma(programa);
		participante.getCandidato().setObservacao(this.observacao);
		return participante;
	}

	
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

	public BigDecimal getTesteLogico() {
		return testeLogico;
	}

	public void setTesteLogico(BigDecimal testeLogico) {
		this.testeLogico = testeLogico;
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
	
	
}
