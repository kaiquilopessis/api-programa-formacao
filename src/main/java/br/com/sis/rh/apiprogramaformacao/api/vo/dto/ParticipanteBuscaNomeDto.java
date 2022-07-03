package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;

public class ParticipanteBuscaNomeDto {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ParticipanteBuscaNomeDto(Participante participante) {
		this.nome = participante.getCandidato().getNome();
	}

}
