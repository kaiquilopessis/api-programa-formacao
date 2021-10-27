package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

public class FormacaoBuscaDto {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public FormacaoBuscaDto(Programa programa) {
		this.nome = programa.getNome();
	}
	
	public static List<FormacaoBuscaDto> converter (List<Programa> formacao){
		return formacao.stream().map(FormacaoBuscaDto::new).collect(Collectors.toList());
	}

}