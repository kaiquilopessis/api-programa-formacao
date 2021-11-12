package br.com.sis.rh.apiprogramaformacao.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "TB_INSTRUTOR")
@Data
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
	
	public Instrutor() {}

	public Instrutor(String cpf, String telefone, String nome) {
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
	}
}
