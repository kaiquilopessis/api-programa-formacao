package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

/**
 * Classe que serve como Vo para levar as
 * informações para a tela de relatórios
 * das avaliações dos participantes
 */

public class RelatorioAvaliacoesVo {

	private Double notaMediaAvaliacaoTecnica;
	private Double notaMediaAvaliacaoComportamental;
	private Double notaMediaAvaliacaoPraticasAgeis;
	private Double notaMediaAvaliacaoLideranca;
	private Double notaMediaAvaliacaoNegocio;
	private Integer ultimoCicloRegistrado;
	private String programaDeFormacao;
	private String turma;
	
	public RelatorioAvaliacoesVo() {}

	public RelatorioAvaliacoesVo(Double notaMediaAvaliacaoTecnica, Double notaMediaAvaliacaoComportamental,
			Double notaMediaAvaliacaoPraticasAgeis, Double notaMediaAvaliacaoLideranca,
			Double notaMediaAvaliacaoNegocio, Integer ultimoCicloRegistrado,
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

	public Double getNotaMediaAvaliacaoTecnica() {
		return notaMediaAvaliacaoTecnica;
	}

	public void setNotaMediaAvaliacaoTecnica(Double notaMediaAvaliacaoTecnica) {
		this.notaMediaAvaliacaoTecnica = notaMediaAvaliacaoTecnica;
	}

	public Double getNotaMediaAvaliacaoComportamental() {
		return notaMediaAvaliacaoComportamental;
	}

	public void setNotaMediaAvaliacaoComportamental(Double notaMediaAvaliacaoComportamental) {
		this.notaMediaAvaliacaoComportamental = notaMediaAvaliacaoComportamental;
	}

	public Double getNotaMediaAvaliacaoPraticasAgeis() {
		return notaMediaAvaliacaoPraticasAgeis;
	}

	public void setNotaMediaAvaliacaoPraticasAgeis(Double notaMediaAvaliacaoPraticasAgeis) {
		this.notaMediaAvaliacaoPraticasAgeis = notaMediaAvaliacaoPraticasAgeis;
	}

	public Double getNotaMediaAvaliacaoLideranca() {
		return notaMediaAvaliacaoLideranca;
	}

	public void setNotaMediaAvaliacaoLideranca(Double notaMediaAvaliacaoLideranca) {
		this.notaMediaAvaliacaoLideranca = notaMediaAvaliacaoLideranca;
	}

	public Double getNotaMediaAvaliacaoNegocio() {
		return notaMediaAvaliacaoNegocio;
	}

	public void setNotaMediaAvaliacaoNegocio(Double notaMediaAvaliacaoNegocio) {
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
