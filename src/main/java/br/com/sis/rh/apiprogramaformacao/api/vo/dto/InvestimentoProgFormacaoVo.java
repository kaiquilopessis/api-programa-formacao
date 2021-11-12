package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

/**
 * 
 * @author dkalbiak
 * 
 *         Nesta classe contém os objetos de valores da aplicação faz ligação
 *         com a vue do front preenchendo os valor dos cards na tela
 *         investimento
 * 
 */

//Generates getters for all fields Lombok

public class InvestimentoProgFormacaoVo {

	private Double investParticipantes;
	private Double investInstrutores;
	private Double investTotal;
	private Double investParticipantesPeriodoSelecionado;
	private Double investInstrutoresPeriodoSelecionado;
	private Double investTotalPeriodoSelecionado;

	private String formacao;
	private String turma;
	public Double getInvestParticipantes() {
		return investParticipantes;
	}
	public void setInvestParticipantes(Double investParticipantes) {
		this.investParticipantes = investParticipantes;
	}
	public Double getInvestInstrutores() {
		return investInstrutores;
	}
	public void setInvestInstrutores(Double investInstrutores) {
		this.investInstrutores = investInstrutores;
	}
	public Double getInvestTotal() {
		return investTotal;
	}
	public void setInvestTotal(Double investTotal) {
		this.investTotal = investTotal;
	}
	public Double getInvestParticipantesPeriodoSelecionado() {
		return investParticipantesPeriodoSelecionado;
	}
	public void setInvestParticipantesPeriodoSelecionado(Double investParticipantesPeriodoSelecionado) {
		this.investParticipantesPeriodoSelecionado = investParticipantesPeriodoSelecionado;
	}
	public Double getInvestInstrutoresPeriodoSelecionado() {
		return investInstrutoresPeriodoSelecionado;
	}
	public void setInvestInstrutoresPeriodoSelecionado(Double investInstrutoresPeriodoSelecionado) {
		this.investInstrutoresPeriodoSelecionado = investInstrutoresPeriodoSelecionado;
	}
	public Double getInvestTotalPeriodoSelecionado() {
		return investTotalPeriodoSelecionado;
	}
	public void setInvestTotalPeriodoSelecionado(Double investTotalPeriodoSelecionado) {
		this.investTotalPeriodoSelecionado = investTotalPeriodoSelecionado;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	
}