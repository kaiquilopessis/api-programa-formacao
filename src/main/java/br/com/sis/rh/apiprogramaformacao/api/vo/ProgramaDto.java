package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProgramaDto {
	
	private Long id;
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private StatusFormacao status;

	public ProgramaDto(Programa programa) {
		this.id = programa.getId();
		this.nome = programa.getNome();
		this.status = programa.getStatus();
	}

	public static List<ProgramaDto> converter(List<Programa> programa) {
		return programa.stream().map(ProgramaDto::new).collect(Collectors.toList());
	}

}

