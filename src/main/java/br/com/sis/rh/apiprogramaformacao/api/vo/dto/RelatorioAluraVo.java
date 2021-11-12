package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Data;

/**
 * Classe que serve como Vo para levar as
 * informações para a tela de relatórios
 * da Alura
 */

@Data
public class RelatorioAluraVo {

	private Integer mediaDeHorasDosParticipantes;
	private Integer maiorQuantidadeDeHorasDosParticipantes;
	private Integer menorQuantidadeDeHorasDosParticipantes;
	private String dataUltimoRegistro;
	private String nomeFuncionarioComMaiorQuantidadeHoras;
	private String cargoFuncionarioComMaiorQuantidadeHoras;
	private String nomeFuncionarioComMenorQuantidadeHoras;
	private String cargoFuncionarioComMenorQuantidadeHoras;
	private String programaDeFormacao;
	private String turma;

	public RelatorioAluraVo() {}
	
	public RelatorioAluraVo(Integer mediaDeHorasDosParticipantes, Integer maiorQuantidadeDeHorasDosParticipantes,
			Integer menorQuantidadeDeHorasDosParticipantes, String dataUltimoRegistro,
			String nomeFuncionarioComMaiorQuantidadeHoras, String cargoFuncionarioComMaiorQuantidadeHoras,
			String nomeFuncionarioComMenorQuantidadeHoras, String cargoFuncionarioComMenorQuantidadeHoras,
			String programaDeFormacao, String turma) {

		this.mediaDeHorasDosParticipantes = mediaDeHorasDosParticipantes;
		this.maiorQuantidadeDeHorasDosParticipantes = maiorQuantidadeDeHorasDosParticipantes;
		this.menorQuantidadeDeHorasDosParticipantes = menorQuantidadeDeHorasDosParticipantes;
		this.dataUltimoRegistro = dataUltimoRegistro;
		this.nomeFuncionarioComMaiorQuantidadeHoras = nomeFuncionarioComMaiorQuantidadeHoras;
		this.cargoFuncionarioComMaiorQuantidadeHoras = cargoFuncionarioComMaiorQuantidadeHoras;
		this.nomeFuncionarioComMenorQuantidadeHoras = nomeFuncionarioComMenorQuantidadeHoras;
		this.cargoFuncionarioComMenorQuantidadeHoras = cargoFuncionarioComMenorQuantidadeHoras;
		this.programaDeFormacao = programaDeFormacao;
		this.turma = turma;
	}
}
