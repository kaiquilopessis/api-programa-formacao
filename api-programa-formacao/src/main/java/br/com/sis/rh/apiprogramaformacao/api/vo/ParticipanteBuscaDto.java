package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class ParticipanteBuscaDto {
	
	private String nome;
	private String cpf;
	private String formacao;
	
	public ParticipanteBuscaDto(Participante participante) {
		this.nome = participante.getNome();
		this.cpf = participante.getCpf();
		this.formacao = participante.getFormacao().getNome();
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public static List<ParticipanteBuscaDto> converter (List<Participante> participantes){
		return participantes.stream().map(ParticipanteBuscaDto::new).collect(Collectors.toList());
	}

}
