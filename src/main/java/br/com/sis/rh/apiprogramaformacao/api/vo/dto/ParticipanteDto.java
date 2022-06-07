package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;

public class ParticipanteDto {

	private String cpf_participante;
	private String status_efetivo;
	private String status_ativo;

	public ParticipanteDto(Participante participante) {
		this.cpf_participante = participante.getCpf();
		this.status_efetivo = participante.getStatusEfetivado().toString();
		this.status_ativo = participante.getStatus().toString();
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

	public String getStatus_efetivo() {
		return status_efetivo;
	}

	public void setStatus_efetivo(String status_efetivo) {
		this.status_efetivo = status_efetivo;
	}

	public String getStatus_ativo() {
		return status_ativo;
	}

	public void setStatus_ativo(String status_ativo) {
		this.status_ativo = status_ativo;
	}


}
