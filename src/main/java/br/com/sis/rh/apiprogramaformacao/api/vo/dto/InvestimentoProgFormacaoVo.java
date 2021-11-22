package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;

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

	private BigDecimal investParticipantes;
	private BigDecimal investInstrutores;
	private BigDecimal investTotal;
	private BigDecimal investParticipantesPeriodoSelecionado;
	private BigDecimal investInstrutoresPeriodoSelecionado;
	private BigDecimal investTotalPeriodoSelecionado;

	private String formacao;
	private String turma;
	
	public BigDecimal getInvestParticipantes() {
		return investParticipantes;
	}
	public void setInvestParticipantes(BigDecimal investParticipantes) {
		this.investParticipantes = investParticipantes;
	}
	public BigDecimal getInvestInstrutores() {
		return investInstrutores;
	}
	public void setInvestInstrutores(BigDecimal investInstrutores) {
		this.investInstrutores = investInstrutores;
	}
	public BigDecimal getInvestTotal() {
		return investTotal;
	}
	public void setInvestTotal(BigDecimal investTotal) {
		this.investTotal = investTotal;
	}
	public BigDecimal getInvestParticipantesPeriodoSelecionado() {
		return investParticipantesPeriodoSelecionado;
	}
	public void setInvestParticipantesPeriodoSelecionado(BigDecimal investParticipantesPeriodoSelecionado) {
		this.investParticipantesPeriodoSelecionado = investParticipantesPeriodoSelecionado;
	}
	public BigDecimal getInvestInstrutoresPeriodoSelecionado() {
		return investInstrutoresPeriodoSelecionado;
	}
	public void setInvestInstrutoresPeriodoSelecionado(BigDecimal investInstrutoresPeriodoSelecionado) {
		this.investInstrutoresPeriodoSelecionado = investInstrutoresPeriodoSelecionado;
	}
	public BigDecimal getInvestTotalPeriodoSelecionado() {
		return investTotalPeriodoSelecionado;
	}
	public void setInvestTotalPeriodoSelecionado(BigDecimal investTotalPeriodoSelecionado) {
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