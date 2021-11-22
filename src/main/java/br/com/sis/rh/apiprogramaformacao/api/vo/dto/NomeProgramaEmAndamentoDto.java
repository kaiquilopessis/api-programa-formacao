package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;

public class NomeProgramaEmAndamentoDto {

	private String nomePrograma;

	public NomeProgramaEmAndamentoDto(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

	public NomeProgramaEmAndamentoDto(ProcessoSeletivo processoSeletivo) {
		this.nomePrograma = processoSeletivo.getNome();
	}

	public static List<NomeProgramaEmAndamentoDto> converter(List<ProcessoSeletivo> processoSeletivos) {
		return processoSeletivos.stream().map(NomeProgramaEmAndamentoDto::new).collect(Collectors.toList());
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

}
