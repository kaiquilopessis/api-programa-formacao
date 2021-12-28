package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sis.rh.apiprogramaformacao.api.model.AluraCompare;

public class ApiAluraDto {

	@JsonProperty("email")
	private String email;

	@JsonProperty("idCurso")
	private Integer idCurso;

	@JsonProperty("cargaHoraria")
	private Integer cargaHoraria;

	public String getEmail() {
		return email;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public ApiAluraDto() {
	}

	public ApiAluraDto(String email, Integer idCurso, Integer cargaHoraria) {
		this.email = email;
		this.idCurso = idCurso;
		this.cargaHoraria = cargaHoraria;
	}

}
