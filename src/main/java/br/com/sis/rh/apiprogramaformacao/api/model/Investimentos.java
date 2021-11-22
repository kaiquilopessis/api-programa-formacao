package br.com.sis.rh.apiprogramaformacao.api.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_INVESTIMENTOS")
@NoArgsConstructor
public class Investimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "cpf_participante_fk")
    private Participante participante;
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;
    @Column(name = "remuneracao")
    private BigDecimal remuneracao;
    @Column(name = "encargos")
    private BigDecimal encargos;
    @Column(name = "beneficios")
    private BigDecimal beneficios;
    @Column(name = "descricao")
    private String descricao;

    public Investimentos(Participante participante, LocalDate dataFormatada, BigDecimal remuneracaoFormatada, BigDecimal encargoFormatado, BigDecimal beneficiosFormatado, String descricao) {
        this.participante = participante;
        this.dataLancamento = dataFormatada;
        this.remuneracao = remuneracaoFormatada;
        this.encargos = encargoFormatado;
        this.beneficios = beneficiosFormatado;
        this.descricao = descricao;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public BigDecimal getEncargos() {
		return encargos;
	}

	public void setEncargos(BigDecimal encargos) {
		this.encargos = encargos;
	}

	public BigDecimal getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(BigDecimal beneficios) {
		this.beneficios = beneficios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
