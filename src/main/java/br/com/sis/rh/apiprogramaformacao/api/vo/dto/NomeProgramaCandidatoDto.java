package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;

public class NomeProgramaCandidatoDto {

	private String nome;
	private Long id;

	public NomeProgramaCandidatoDto(ProcessoSeletivo processoSeletivo) {
		this.nome = processoSeletivo.getNome();
		this.id = processoSeletivo.getId();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
