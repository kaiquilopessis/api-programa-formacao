package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_INSTRUTOR")
public class Instrutor {

	@Id
	@Column(name = "cpf_instrutor", length = 12)
	private String cpfInstrutor;
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "telefone", length = 255, nullable = false)
	private String telefone;
	@Column(name = "email_corp", length = 100, nullable = false)
	private String email;
	@Column(name = "status")
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "cod_remun_programa", referencedColumnName = "id", nullable = false)
	private Integer remuneracaoPrograma;
	
	
	public String getCpfInstrutor() {
		return cpfInstrutor;
	}
	public void setCpfInstrutor(String cpfInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRemuneracaoPrograma() {
		return remuneracaoPrograma;
	}
	public void setRemuneracaoPrograma(Integer remuneracaoPrograma) {
		this.remuneracaoPrograma = remuneracaoPrograma;
	}
	
	
}
