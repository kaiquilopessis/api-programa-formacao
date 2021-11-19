package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramaDto {

	private String nomePrograma;

	public ProgramaDto(ProcessoSeletivo processoSeletivo) {
		this.nomePrograma = processoSeletivo.getNomePrograma();
	}

	public static List<ProgramaDto> converter(List<ProcessoSeletivo> processoSeletivos){
		return processoSeletivos.stream().map(ProgramaDto::new).collect(Collectors.toList());
	}
}

