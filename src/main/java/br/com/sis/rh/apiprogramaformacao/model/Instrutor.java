package br.com.sis.rh.apiprogramaformacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INSTRUTOR")
public class Instrutor {

	@Id
	@Column(name = "cpf_instrutor")
	private String cpfInstrutor;
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "telefone", length = 255, nullable = false)
	private String telefone;
	@Column(name = "email_corp", length = 100, nullable = false)
	private String email;
	@Column(name = "status")
	private long status;
	@Column(name = "cod_remun_programa")
	private long codRemuneracaoPrograma;
}
