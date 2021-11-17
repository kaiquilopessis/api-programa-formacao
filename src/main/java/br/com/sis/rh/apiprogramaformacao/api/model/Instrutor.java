package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_INSTRUTOR")
@Getter
@Setter
public class Instrutor {

	@Id
	@Column(name = "cpf_instrutor")
	private String cpfInstrutor;
	@Column(name = "telefone", length = 255, nullable = false)
	private String telefone;
	@Column(name = "status")
	private long status;
	@Column(name = "nome_instrutor", length = 50, nullable = false)
	private String nomeInstrutor;
	@Column(name = "email_corp")
	private String emailCorp;
}
