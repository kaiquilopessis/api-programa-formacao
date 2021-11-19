package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivado;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusParticipante;

public class ParticipanteDto {

	private String cpf_participante;

	@Enumerated(EnumType.STRING)
	private StatusEfetivado status_efetivo;

	@Enumerated(EnumType.STRING)
	private StatusParticipante status_ativo;

	public ParticipanteDto(Participante participante) {
		this.cpf_participante = participante.getCpf();
		this.status_efetivo = participante.getStatusEfetivado();
		this.status_ativo = participante.getStatus();
	}

	public static List<ParticipanteDto> converter(List<Participante> participantes) {
		return participantes.stream().map(ParticipanteDto::new).collect(Collectors.toList());
	}

	public String getCpf_participante() {
		return cpf_participante;
	}

	public void setCpf_participante(String cpf_participante) {
		this.cpf_participante = cpf_participante;
	}

	public StatusEfetivado getStatus_efetivo() {
		return status_efetivo;
	}

	public void setStatus_efetivo(StatusEfetivado status_efetivo) {
		this.status_efetivo = status_efetivo;
	}

	public StatusParticipante getStatus_ativo() {
		return status_ativo;
	}

	public void setStatus_ativo(StatusParticipante status_ativo) {
		this.status_ativo = status_ativo;
	}

}
