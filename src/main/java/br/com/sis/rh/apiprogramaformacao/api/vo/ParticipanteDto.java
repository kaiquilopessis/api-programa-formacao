package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParticipanteDto {

	private String cpf_participante;

	@Enumerated(EnumType.STRING)
	private StatusEfetivo status_efetivo;

	@Enumerated(EnumType.STRING)
	private StatusAtivo status_ativo;

	public ParticipanteDto(Participante participante) {
//		this.cpf_participante = participante.getCpf_participante();
//		this.status_efetivo = participante.getStatus_efetivado();
//		this.status_ativo = participante.getStatus_ativo();
	}

	public static List<ParticipanteDto> converter(List<Participante> participantes) {
		return participantes.stream().map(ParticipanteDto::new).collect(Collectors.toList());
	}

}
