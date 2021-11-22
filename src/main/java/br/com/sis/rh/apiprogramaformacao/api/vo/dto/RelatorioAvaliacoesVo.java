package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;

/**
 * Classe que serve como Vo para levar as
 * informações para a tela de relatórios
 * das avaliações dos participantes
 */

public class RelatorioAvaliacoesVo {

	private BigDecimal notaMediaAvaliacaoTecnica;
	private BigDecimal notaMediaAvaliacaoComportamental;
	private BigDecimal notaMediaAvaliacaoPraticasAgeis;
	private BigDecimal notaMediaAvaliacaoLideranca;
	private BigDecimal notaMediaAvaliacaoNegocio;
	private Integer ultimoCicloRegistrado;
	private String programaDeFormacao;
	private String turma;
	
	public RelatorioAvaliacoesVo() {}

	public RelatorioAvaliacoesVo(BigDecimal notaMediaAvaliacaoTecnica, BigDecimal notaMediaAvaliacaoComportamental,
			BigDecimal notaMediaAvaliacaoPraticasAgeis, BigDecimal notaMediaAvaliacaoLideranca,
			BigDecimal notaMediaAvaliacaoNegocio, Integer ultimoCicloRegistrado,
			String programaDeFormacao, String turma) {
		this.notaMediaAvaliacaoTecnica = notaMediaAvaliacaoTecnica;
		this.notaMediaAvaliacaoComportamental = notaMediaAvaliacaoComportamental;
		this.notaMediaAvaliacaoPraticasAgeis = notaMediaAvaliacaoPraticasAgeis;
		this.notaMediaAvaliacaoLideranca = notaMediaAvaliacaoLideranca;
		this.notaMediaAvaliacaoNegocio = notaMediaAvaliacaoNegocio;
		this.ultimoCicloRegistrado = ultimoCicloRegistrado;
		this.programaDeFormacao = programaDeFormacao;
		this.turma = turma;
	}

	public BigDecimal getNotaMediaAvaliacaoTecnica() {
		return notaMediaAvaliacaoTecnica;
	}

	public void setNotaMediaAvaliacaoTecnica(BigDecimal notaMediaAvaliacaoTecnica) {
		this.notaMediaAvaliacaoTecnica = notaMediaAvaliacaoTecnica;
	}

	public BigDecimal getNotaMediaAvaliacaoComportamental() {
		return notaMediaAvaliacaoComportamental;
	}

	public void setNotaMediaAvaliacaoComportamental(BigDecimal notaMediaAvaliacaoComportamental) {
		this.notaMediaAvaliacaoComportamental = notaMediaAvaliacaoComportamental;
	}

	public BigDecimal getNotaMediaAvaliacaoPraticasAgeis() {
		return notaMediaAvaliacaoPraticasAgeis;
	}

	public void setNotaMediaAvaliacaoPraticasAgeis(BigDecimal notaMediaAvaliacaoPraticasAgeis) {
		this.notaMediaAvaliacaoPraticasAgeis = notaMediaAvaliacaoPraticasAgeis;
	}

	public BigDecimal getNotaMediaAvaliacaoLideranca() {
		return notaMediaAvaliacaoLideranca;
	}

	public void setNotaMediaAvaliacaoLideranca(BigDecimal notaMediaAvaliacaoLideranca) {
		this.notaMediaAvaliacaoLideranca = notaMediaAvaliacaoLideranca;
	}

	public BigDecimal getNotaMediaAvaliacaoNegocio() {
		return notaMediaAvaliacaoNegocio;
	}

	public void setNotaMediaAvaliacaoNegocio(BigDecimal notaMediaAvaliacaoNegocio) {
		this.notaMediaAvaliacaoNegocio = notaMediaAvaliacaoNegocio;
	}

	public Integer getUltimoCicloRegistrado() {
		return ultimoCicloRegistrado;
	}

	public void setUltimoCicloRegistrado(Integer ultimoCicloRegistrado) {
		this.ultimoCicloRegistrado = ultimoCicloRegistrado;
	}

	public String getProgramaDeFormacao() {
		return programaDeFormacao;
	}

	public void setProgramaDeFormacao(String programaDeFormacao) {
		this.programaDeFormacao = programaDeFormacao;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
}
