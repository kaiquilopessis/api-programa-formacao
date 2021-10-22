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
	private int status;

	public Instrutor(String cpfInstrutor, String telefone, int status) {
		this.cpfInstrutor = cpfInstrutor;
		this.telefone = telefone;
		this.status = status;
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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
