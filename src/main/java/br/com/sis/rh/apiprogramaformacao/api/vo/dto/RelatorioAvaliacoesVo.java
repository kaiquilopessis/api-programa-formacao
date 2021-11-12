package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Data;

/**
 * Classe que serve como Vo para levar as
 * informações para a tela de relatórios
 * das avaliações dos participantes
 */

@Data
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
}
