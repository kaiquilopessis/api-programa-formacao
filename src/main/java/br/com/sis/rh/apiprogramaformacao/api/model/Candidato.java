package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CANDIDATO")
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "telefone", nullable = false, length = 255)
	private String telefone;
	
	@Column(name = "data_agendamento", nullable = false)
	private LocalDate dataAgendamento;
	
	@Column(name = "teste_logico", nullable = false)
	private BigDecimal testeLogico;
	
	@Column(name = "nota_disc", length = 15, nullable = false)
	private String notaDisc;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "observacao", length = 8000)
	private String observacao;
	
	@Column(name = "DISC")
	private String disc;
	
	@Column(name = "curriculo")
	private String curriculo;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public BigDecimal getTesteLogico() {
		return testeLogico;
	}

	public void setTesteLogico(BigDecimal testeLogico) {
		this.testeLogico = testeLogico;
	}

	public String getNotaDisc() {
		return notaDisc;
	}

	public void setNotaDisc(String notaDisc) {
		this.notaDisc = notaDisc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	
	
}
