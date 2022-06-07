package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;

public class ParticipanteBuscaDto {

	private String nome;
	private String cpf;
	private String programa;
	private StatusAtivo statusAtivo;

	public ParticipanteBuscaDto(Participante participante) {
		this.nome = participante.getCandidato().getNome();
		this.cpf = participante.getCpf();
		this.programa = participante.getPrograma().getProcessoSeletivo().getNome();
		this.statusAtivo = participante.getStatus();
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

	public StatusAtivo getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(StatusAtivo statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public static List<ParticipanteBuscaDto> converter(List<Participante> participantes) {
		return participantes.stream().map(ParticipanteBuscaDto::new).collect(Collectors.toList());
	}

}
