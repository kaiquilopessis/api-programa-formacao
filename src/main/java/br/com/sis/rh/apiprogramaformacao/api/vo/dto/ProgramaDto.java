package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;
import lombok.Setter;

public class ProgramaDto {

	private String nome;

	public ProgramaDto(ProcessoSeletivo processoSeletivo) {
		this.nome = processoSeletivo.getNome();
	}


	public ProgramaDto(String nome) {
		this.nome = nome;
	}


	public static List<ProgramaDto> converter(List<ProcessoSeletivo> processoSeletivos){
		return processoSeletivos.stream().map(ProgramaDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
