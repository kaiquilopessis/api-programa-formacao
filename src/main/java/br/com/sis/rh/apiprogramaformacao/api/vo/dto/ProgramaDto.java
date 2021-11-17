package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;
import lombok.Setter;

public class ProgramaDto {

	private Long id;
	private String nome;

	@Enumerated(EnumType.STRING)
	private StatusFormacao status;

	public ProgramaDto(Programa programa) {
		this.id = programa.getId();
		this.nome = programa.getProcessoSeletivo().getNome();
		this.status = programa.getStatus();
	}

	public static List<ProgramaDto> converter(List<Programa> programa) {
		return programa.stream().map(ProgramaDto::new).collect(Collectors.toList());
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

	public StatusFormacao getStatus() {
		return status;
	}

	public void setStatus(StatusFormacao status) {
		this.status = status;
	}

}
