package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_REMUNERACAO_INSTRUTOR")
public class RemuneracaoInstrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "data_lancamento")
	private LocalDate dataLancamento;
	@Column(name = "qtd_hora")
	private Integer qtdHora;
	@Column(name = "vlr_hora")
	private BigDecimal valorHora;
	@ManyToOne
	@JoinColumn(name = "codigo_instrutor_fk")
	private Instrutor instrutor;

	public RemuneracaoInstrutor() {
	}

	public RemuneracaoInstrutor(Long id, LocalDate dataLancamento, Integer qtdHora, BigDecimal valorHora,
			Instrutor instrutor) {
		this.id = id;
		this.dataLancamento = dataLancamento;
		this.qtdHora = qtdHora;
		this.valorHora = valorHora;
		this.instrutor = instrutor;
	}

	public RemuneracaoInstrutor(LocalDate dataLancamento, BigDecimal valorHora,Integer qtdHora,  Instrutor instrutor) {
		this.dataLancamento = dataLancamento;
		this.qtdHora = qtdHora;
		this.valorHora = valorHora;
		this.instrutor = instrutor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(Integer qtdHora) {
		this.qtdHora = qtdHora;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

}
