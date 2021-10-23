package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARTICIPANTE")
public class Participante {

	@Id
	private String cpf_participante;
}
