package br.com.sis.rh.apiprogramaformacao.api.model;

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

	@Column(length = 255, nullable = false)
	private String telefone;

	private String status;

	public Instrutor(String cpfInstrutor, String telefone, String status) {
		this.cpfInstrutor = cpfInstrutor;
		this.telefone = telefone;
		this.status = status;
	}
	
	public Instrutor() {
		
	}

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

	

}
