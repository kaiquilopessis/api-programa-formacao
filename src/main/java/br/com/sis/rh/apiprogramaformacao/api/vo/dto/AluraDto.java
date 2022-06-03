package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;

public class AluraDto {

	private Long codigoAlura;
	private Integer qtdHoras;
	private LocalDate dataRegistro;
	private int hrMinSemana;

	public AluraDto(Alura alura) {
		this.codigoAlura = alura.getCodigoAlura();
		this.qtdHoras = alura.getQtdHoras();
		this.dataRegistro = alura.getDataRegistro();
		this.hrMinSemana = alura.getHrMinSemana();
	}

	public static List<AluraDto> converter(List<Alura> alura) {
		return alura.stream().map(AluraDto::new).collect(Collectors.toList());
	}

	public Long getCodigoAlura() {
		return codigoAlura;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public int getHrMinSemana() {
		return hrMinSemana;
	}

}
