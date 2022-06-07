package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;

public class RemuneracaoProgramaDto {

	private Long id;
	private String cargo;

	public RemuneracaoProgramaDto(Remuneracao remuneracao) {
		this.id = remuneracao.getId();
		this.cargo = remuneracao.getCargo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public static List<RemuneracaoProgramaDto> converter(List<Remuneracao> remuneracaoPrograma) {
		return remuneracaoPrograma.stream().map(RemuneracaoProgramaDto :: new).collect(Collectors.toList());
	}
}
