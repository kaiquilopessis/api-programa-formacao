package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;

@Entity
@Table(name = "TB_PROGRAMA")
@Getter
public class Programa {

	@Id
	private Long id;
	private String nome;

	@Enumerated(EnumType.STRING)
	private StatusFormacao status;

	public Programa() {
	}

	public Programa(Long id, String nome, StatusFormacao status) {
		this.id = id;
		this.nome = nome;
		this.status = status;
	}

}
