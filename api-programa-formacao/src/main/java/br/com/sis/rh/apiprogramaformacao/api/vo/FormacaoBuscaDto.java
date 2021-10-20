package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacao;

public class FormacaoBuscaDto {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public FormacaoBuscaDto(Formacao formacao) {
		this.nome = formacao.getNome();
	}
	
	public static List<FormacaoBuscaDto> converter (List<Formacao> formacao){
		return formacao.stream().map(FormacaoBuscaDto::new).collect(Collectors.toList());
	}

}
