package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import java.time.LocalDate;


public class CandidatoDto {

	private Long id;
	private String nome;
	private String telefone;
	private LocalDate dataAgendamento;
	
	public CandidatoDto(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.telefone = candidato.getTelefone();
		this.dataAgendamento = candidato.getDataAgendamento();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	

}
