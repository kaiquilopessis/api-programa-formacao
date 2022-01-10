package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import io.swagger.annotations.ApiModel;

public class ListaCandidatoDto {

	private Long id;
	private String nome;
	private String status;

	public ListaCandidatoDto(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.status = candidato.getStatus();
	}

	public static List<ListaCandidatoDto> toListaCandidatoDto(List<Candidato> candidato) {
		return candidato.stream().map(ListaCandidatoDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
