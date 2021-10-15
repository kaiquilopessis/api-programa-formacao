package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;

public class ParticipanteDto {

	private Long id;
	private String nomeParticipante;
	private String programaFormacao;

	@Enumerated(EnumType.STRING)
	private StatusEfetivo efetivo;

	@Enumerated(EnumType.STRING)
	private StatusAtivo ativo;

	public ParticipanteDto(Participante participante) {
		this.id = participante.getId();
		this.nomeParticipante = participante.getNomeParticipante();
		this.programaFormacao = participante.getProgramaFormacao();
		this.efetivo = participante.getEfetivo();
		this.ativo = participante.getAtivo();
	}

	public Long getId() {
		return id;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public String getProgramaFormacao() {
		return programaFormacao;
	}

	public StatusEfetivo getEfetivo() {
		return efetivo;
	}

	public StatusAtivo getAtivo() {
		return ativo;
	}

	public static List<ParticipanteDto> converter(List<Participante> participantes) {
		return participantes.stream().map(ParticipanteDto::new).collect(Collectors.toList());
	}

}
