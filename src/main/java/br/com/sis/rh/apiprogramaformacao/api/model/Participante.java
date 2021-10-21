package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.Status_Ativo;
import br.com.sis.rh.apiprogramaformacao.core.enums.Status_Efetivo;
import lombok.Getter;

@Entity
@Table(name = "TB_PARTICIPANTE")
@Getter
public class Participante {

	@Id
	private String cpf_participante;

	@Enumerated(EnumType.STRING)
	private Status_Efetivo status_efetivado;

	@Enumerated(EnumType.STRING)
	private Status_Ativo status_ativo;

	public Participante() {
	}

	public Participante(String cpf_participante,
			Status_Efetivo status_efetivado, Status_Ativo status_ativo) {
		this.cpf_participante = cpf_participante;
		this.status_efetivado = status_efetivado;
		this.status_ativo = status_ativo;
	}

}
