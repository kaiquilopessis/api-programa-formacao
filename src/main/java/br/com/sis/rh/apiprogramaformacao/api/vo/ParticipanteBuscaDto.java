package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class ParticipanteBuscaDto {

	private String nome;
	private String cpf;
	private String programa;

	public ParticipanteBuscaDto(Participante participante) {
		this.nome = participante.getCandidato().getNome();
		this.cpf = participante.getCpf();
		this.programa = participante.getPrograma().getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public static List<ParticipanteBuscaDto> converter(List<Participante> participantes) {
		return participantes.stream().map(ParticipanteBuscaDto::new).collect(Collectors.toList());
	}

}
