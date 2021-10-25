package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "TB_PROGRAMA")
@Getter @Setter
public class Programa {

	@Id
	private Long id;
	private String nome;
	private String cpf_Instrutor;
}
