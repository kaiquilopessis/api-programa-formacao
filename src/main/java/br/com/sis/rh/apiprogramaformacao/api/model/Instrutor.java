package br.com.sis.rh.apiprogramaformacao.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusInstrutor;

@Entity(name = "TB_INSTRUTOR")
public class Instrutor {

	@Id
	@Column(name = "cpf_instrutor")
	private String cpf;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "nome_instrutor")
	private String nome;
	@OneToMany(fetch = FetchType.LAZY)
	private List<RemuneracaoInstrutor> remuneracaoInstrutor;

	private String status;

	public Instrutor() {
	}

	public Instrutor(String cpf, String telefone, String nome, String status) {
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RemuneracaoInstrutor> getRemuneracaoInstrutor() {
		return remuneracaoInstrutor;
	}

	public void setRemuneracaoInstrutor(List<RemuneracaoInstrutor> remuneracaoInstrutor) {
		this.remuneracaoInstrutor = remuneracaoInstrutor;
	}

}
