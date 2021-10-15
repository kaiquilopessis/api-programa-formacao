package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacoes;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;

public class FormacoesDto {
	
	private Long id;
	private String nomeFormacao;
	
	@Enumerated(EnumType.STRING)
	private StatusFormacao statusFormacao;

	public FormacoesDto(Formacoes formacoes) {
		this.id = formacoes.getId();
		this.nomeFormacao = formacoes.getNomeFormacao();
		this.statusFormacao = formacoes.getStatusFormacao();
	}

	public String getNomeFormacao() {
		return nomeFormacao;
	}

	public void setNomeFormacao(String nomeFormacao) {
		this.nomeFormacao = nomeFormacao;
	}

	public static List<FormacoesDto> converter(List<Formacoes> formacoes) {
		return formacoes.stream().map(FormacoesDto::new).collect(Collectors.toList());
	}

}

