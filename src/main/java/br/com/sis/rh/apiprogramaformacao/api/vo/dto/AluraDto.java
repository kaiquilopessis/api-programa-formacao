package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;

public class AluraDto {


	private Long codigoAlura;
	private Integer qtdHoras;
	private int mesAvaliado;
	private int semanaAvaliada;
	private LocalDate dataRegistro;
	private int hrMinSemana;



	public AluraDto(Alura alura) {
		this.codigoAlura = alura.getCodigoAlura();
		this.qtdHoras = alura.getQtdHoras();
		this.mesAvaliado = alura.getMesAvaliado();
		this.semanaAvaliada = alura.getSemanaAvaliada();
		this.dataRegistro = alura.getDataRegistro();
		this.hrMinSemana = alura.getHrMinSemana();

	}
	public Long getCodigoAlura() {
		return codigoAlura;
	}
	public void setCodigoAlura(Long codigoAlura) {
		this.codigoAlura = codigoAlura;
	}
	public Integer getQtdHoras() {
		return qtdHoras;
	}
	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}
	public int getMesAvaliado() {
		return mesAvaliado;
	}
	public void setMesAvaliado(int mesAvaliado) {
		this.mesAvaliado = mesAvaliado;
	}
	public int getSemanaAvaliada() {
		return semanaAvaliada;
	}
	public void setSemanaAvaliada(int semanaAvaliada) {
		this.semanaAvaliada = semanaAvaliada;
	}
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public int getHrMinSemana() {
		return hrMinSemana;
	}
	public void setHrMinSemana(int hrMinSemana) {
		this.hrMinSemana = hrMinSemana;
	}

	public static List<AluraDto> converter(List<Alura> alura) {
		return alura.stream().map(AluraDto::new).collect(Collectors.toList());
	}

}
