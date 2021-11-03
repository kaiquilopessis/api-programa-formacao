package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import lombok.Getter;

@Entity(name = "TB_PARTICIPANTE")
@Getter
public class Participante {

	@Id
	private String cpf_participante;

	@Enumerated(EnumType.STRING)
	private StatusEfetivo status_efetivado;

	@Enumerated(EnumType.STRING)
	private StatusAtivo status_ativo;

	public Participante() {
	}

	public Participante(String cpf_participante,
			StatusEfetivo status_efetivado, StatusAtivo status_ativo) {
		this.cpf_participante = cpf_participante;
		this.status_efetivado = status_efetivado;
		this.status_ativo = status_ativo;
	}

   }
