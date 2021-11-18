package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_INSTRUTOR")
public class Instrutor {

	@Id
	@Column(name = "cpf_instrutor")
	private String cpfInstrutor;
	@Column( length = 255, nullable = false)
	private String telefone;
	private String status;
	@Column(name = "nome_instrutor")
	private String nome;
	@Column(name = "email_corp")
	private String emailCorp;

	public Instrutor(String cpfInstrutor, String telefone, String status, String nome, String email) {
		this.cpfInstrutor = cpfInstrutor;
		this.telefone = telefone;
		this.status = status;
		this.nome = nome;
		this.emailCorp = email;
	}

	public Instrutor(){}

	public String getCpfInstrutor() {
		return cpfInstrutor;
	}
	public void setCpfInstrutor(String cpfInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailCorp() {
		return emailCorp;
	}
	public void setEmailCorp(String emailCorp) {
		this.emailCorp = emailCorp;
	}
}
