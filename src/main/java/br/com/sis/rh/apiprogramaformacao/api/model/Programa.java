package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TB_PROGRAMA")
@Getter
@Setter
public class Programa {

	@Id
	private Long id;
	private String nome;
	private String nome_turma;
	private LocalDate data_fim;
	
	@Enumerated(EnumType.STRING)
	private StatusFormacao status;

	public Programa() {
	}

	public Programa(Long id, String nome, StatusFormacao status, String nome_turma, LocalDate data_fim) {
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.nome_turma = nome_turma;
		this.data_fim = data_fim;
	}

}
