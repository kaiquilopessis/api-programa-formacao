package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class ParticipanteExibeDto {
	private String nome;
	private String cpf;
	private String telefone;
	private String fonteRecrutamento;
	private BigDecimal testeLogico;
	private String nmFaculdade;
	private String curso;
	private LocalDate dataFimGraduacao;
	private String cargo;
	private BigDecimal bolsa;
	private String turma;
	private String nomeInstrutor;
	private LocalDate iniPrograma;
	private LocalDate fimPrograma;
	private String observacao;
	
	
	public ParticipanteExibeDto() {
	}


	public ParticipanteExibeDto(Participante participante) {
		this.nome = participante.getCandidato().getNome();
		this.cpf = participante.getCpf();
		this.telefone = participante.getCandidato().getTelefone();
		this.fonteRecrutamento = participante.getCandidato().getFonteRecrutamento();
		this.testeLogico = participante.getCandidato().getTesteLogico();
		this.nmFaculdade = participante.getFaculdade();
		this.curso = participante.getCandidato().getCurso();
		this.dataFimGraduacao = participante.getDataFinal();
		this.cargo = participante.getRemuneracaoPrograma().getCargo();
		this.bolsa = participante.getRemuneracaoPrograma().getBolsa();
		this.turma = participante.getPrograma().getNomeTurma();
		this.nomeInstrutor = participante.getPrograma().getProcessoSeletivo().getNome();
		this.iniPrograma = participante.getPrograma().getDataInicio();
		this.fimPrograma = participante.getPrograma().getDataFim();
		this.observacao = participante.getCandidato().getObservacao();
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
	
	

	public BigDecimal getBolsa() {
		return bolsa;
	}


	public void setBolsa(BigDecimal bolsa) {
		this.bolsa = bolsa;
	}


	public String getTurma() {
		return turma;
	}


	public void setTurma(String turma) {
		this.turma = turma;
	}


	public String getNomeInstrutor() {
		return nomeInstrutor;
	}


	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}


	public LocalDate getIniPrograma() {
		return iniPrograma;
	}


	public void setIniPrograma(LocalDate iniPrograma) {
		this.iniPrograma = iniPrograma;
	}


	public LocalDate getFimPrograma() {
		return fimPrograma;
	}


	public void setFimPrograma(LocalDate fimPrograma) {
		this.fimPrograma = fimPrograma;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
