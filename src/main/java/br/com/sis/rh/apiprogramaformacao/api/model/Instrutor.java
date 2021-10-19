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

	@ManyToOne
	@JoinColumn(name = "codigo_remun_programa_fk", referencedColumnName = "id", nullable = false)
	private RemuneracaoPrograma remuneracao;

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

	public RemuneracaoPrograma getRemuneracao() {
		return remuneracao;
	}
	public void setRemuneracao(RemuneracaoPrograma remuneracao) {
		this.remuneracao = remuneracao;
	}
}
