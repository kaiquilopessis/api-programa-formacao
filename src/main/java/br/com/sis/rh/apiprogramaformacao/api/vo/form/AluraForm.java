package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class AluraForm {

	private Integer qtdHoras;
	private Integer mesAvaliado;
	private Integer semanaAvaliada;
	private String dataRegistro;
	private Integer hrMinSemana;

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public Integer getMesAvaliado() {
		return mesAvaliado;
	}

	public void setMesAvaliado(Integer mesAvaliado) {
		this.mesAvaliado = mesAvaliado;
	}

	public Integer getSemanaAvaliada() {
		return semanaAvaliada;
	}

	public void setSemanaAvaliada(Integer semanaAvaliada) {
		this.semanaAvaliada = semanaAvaliada;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Integer getHrMinSemana() {
		return hrMinSemana;
	}

	public void setHrMinSemana(Integer hrMinSemana) {
		this.hrMinSemana = hrMinSemana;
	}

	public Alura converter(Participante participante) {
		LocalDate data = LocalDate.parse(this.dataRegistro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Alura(participante, qtdHoras, mesAvaliado, semanaAvaliada, data, hrMinSemana);
	}

}
