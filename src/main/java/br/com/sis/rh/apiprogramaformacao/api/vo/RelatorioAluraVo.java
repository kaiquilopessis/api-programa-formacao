package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.time.LocalDate;

public class RelatorioAluraVo {

	private Integer mediaDeHorasDosParticipantes;
	private Integer maiorQuantidadeDeHorasDosParticipantes;
	private Integer menorQuantidadeDeHorasDosParticipantes;
	private LocalDate dataUltimoRegistro;
	private String nomeFuncionarioComMaiorQuantidadeHoras;
	private String cargoFuncionarioComMaiorQuantidadeHoras;
	private String nomeFuncionarioComMenorQuantidadeHoras;
	private String cargoFuncionarioComMenorQuantidadeHoras;
	private String programaDeFormacao;
	private String turma;

	public RelatorioAluraVo(Integer mediaDeHorasDosParticipantes, Integer maiorQuantidadeDeHorasDosParticipantes,
			Integer menorQuantidadeDeHorasDosParticipantes, LocalDate dataUltimoRegistro,
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

	public Integer getMediaDeHorasDosParticipantes() {
		return mediaDeHorasDosParticipantes;
	}

	public void setMediaDeHorasDosParticipantes(Integer mediaDeHorasDosParticipantes) {
		this.mediaDeHorasDosParticipantes = mediaDeHorasDosParticipantes;
	}

	public Integer getMaiorQuantidadeDeHorasDosParticipantes() {
		return maiorQuantidadeDeHorasDosParticipantes;
	}

	public void setMaiorQuantidadeDeHorasDosParticipantes(Integer maiorQuantidadeDeHorasDosParticipantes) {
		this.maiorQuantidadeDeHorasDosParticipantes = maiorQuantidadeDeHorasDosParticipantes;
	}

	public Integer getMenorQuantidadeDeHorasDosParticipantes() {
		return menorQuantidadeDeHorasDosParticipantes;
	}

	public void setMenorQuantidadeDeHorasDosParticipantes(Integer menorQuantidadeDeHorasDosParticipantes) {
		this.menorQuantidadeDeHorasDosParticipantes = menorQuantidadeDeHorasDosParticipantes;
	}

	public LocalDate getDataUltimoRegistro() {
		return dataUltimoRegistro;
	}

	public void setDataUltimoRegistro(LocalDate dataUltimoRegistro) {
		this.dataUltimoRegistro = dataUltimoRegistro;
	}

	public String getNomeFuncionarioComMaiorQuantidadeHoras() {
		return nomeFuncionarioComMaiorQuantidadeHoras;
	}

	public void setNomeFuncionarioComMaiorQuantidadeHoras(String nomeFuncionarioComMaiorQuantidadeHoras) {
		this.nomeFuncionarioComMaiorQuantidadeHoras = nomeFuncionarioComMaiorQuantidadeHoras;
	}

	public String getCargoFuncionarioComMaiorQuantidadeHoras() {
		return cargoFuncionarioComMaiorQuantidadeHoras;
	}

	public void setCargoFuncionarioComMaiorQuantidadeHoras(String cargoFuncionarioComMaiorQuantidadeHoras) {
		this.cargoFuncionarioComMaiorQuantidadeHoras = cargoFuncionarioComMaiorQuantidadeHoras;
	}

	public String getNomeFuncionarioComMenorQuantidadeHoras() {
		return nomeFuncionarioComMenorQuantidadeHoras;
	}

	public void setNomeFuncionarioComMenorQuantidadeHoras(String nomeFuncionarioComMenorQuantidadeHoras) {
		this.nomeFuncionarioComMenorQuantidadeHoras = nomeFuncionarioComMenorQuantidadeHoras;
	}

	public String getCargoFuncionarioComMenorQuantidadeHoras() {
		return cargoFuncionarioComMenorQuantidadeHoras;
	}

	public void setCargoFuncionarioComMenorQuantidadeHoras(String cargoFuncionarioComMenorQuantidadeHoras) {
		this.cargoFuncionarioComMenorQuantidadeHoras = cargoFuncionarioComMenorQuantidadeHoras;
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
