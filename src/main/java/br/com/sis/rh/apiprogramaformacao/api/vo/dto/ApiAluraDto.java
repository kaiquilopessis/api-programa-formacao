package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ApiAluraDto {

	private String email;
	private Integer idCurso;
	private Integer cargaHoraria;
	private String token;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
