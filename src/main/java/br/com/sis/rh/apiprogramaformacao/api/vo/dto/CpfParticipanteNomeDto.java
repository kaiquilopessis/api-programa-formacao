package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;

import java.util.List;
import java.util.stream.Collectors;


@Entity
public class CpfParticipanteNomeDto {

	@Id
	@Column(name = "cpf_participante")
	private String cpfParticipante;
	@Column(name = "nome")
	private String nomeCandidato;

	public CpfParticipanteNomeDto(Participante participante) {
		this.cpfParticipante = participante.getCpf();
		this.nomeCandidato = participante.getCandidato().getNome();
	}

	public CpfParticipanteNomeDto(){

	}
	
	
	public CpfParticipanteNomeDto(String cpfParticipante, String nomeCandidato) {
		this.cpfParticipante = cpfParticipante;
		this.nomeCandidato = nomeCandidato;
	}


	public static List<CpfParticipanteNomeDto> converter(List<Participante> listaParticipantes) {
		return listaParticipantes.stream().map(CpfParticipanteNomeDto::new).collect(Collectors.toList());
	}

	public String getCpfParticipante() {
		return cpfParticipante;
	}

	public void setCpfParticipante(String cpfParticipante) {
		this.cpfParticipante = cpfParticipante;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

}
