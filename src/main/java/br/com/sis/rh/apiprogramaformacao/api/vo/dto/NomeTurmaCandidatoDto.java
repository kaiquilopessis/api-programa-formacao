package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;

public class NomeTurmaCandidatoDto {

	private String turmas;
	private Long id;

	public NomeTurmaCandidatoDto(Programa programa) {
		this.turmas = programa.getNomeTurma();
		this.id= programa.getId();
	}

	public String getTurmas() {
		return turmas;
	}

	public void setTurmas(String turmas) {
		this.turmas = turmas;
	}
	
	public static List<NomeTurmaCandidatoDto> converter (List<Programa> programas) {
		return programas.stream().map(NomeTurmaCandidatoDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
