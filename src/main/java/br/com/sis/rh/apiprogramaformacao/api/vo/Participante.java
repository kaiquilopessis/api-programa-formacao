package br.com.sis.rh.apiprogramaformacao.api.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARTICIPANTE")
public class Participante {

	@Id
	@Column(name = "CPF_PARTICIPANTE")
	private String cpf;

	@Column(name = "NOME_PARTICIPANTE")
	private String nome;

	@Column(name = "status")
	private Boolean status;

	public Participante() {

	}

	public Participante(String cpf, String nome, Boolean status) {
		this.cpf = cpf;
		this.nome = nome;
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
