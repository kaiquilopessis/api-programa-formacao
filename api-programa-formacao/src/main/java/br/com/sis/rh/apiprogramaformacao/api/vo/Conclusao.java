package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONCLUSAO")
public class Conclusao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "CODIGO_PARTICIPANTE")
	private Long codigoParticipante;

	@Column(name = "reajuste_salario")
	private Boolean reajusteSalario;

	@Column(name = "data_alteracao")
	private LocalDateTime dataAltarecao;

	@Column(name = "valor_salario_atual")
	private BigDecimal valorSalarioAtual;

	@Column(name = "comprovante_rematricula")
	private String comprovanteRematricula;

	public Conclusao() {

	}

	public Conclusao(Long id, Long codigoParticipante, Boolean reajusteSalario, LocalDateTime dataAltarecao,
			BigDecimal valorSalarioAtual, String comprovanteRematricula) {
		super();
		this.id = id;
		this.codigoParticipante = codigoParticipante;
		this.reajusteSalario = reajusteSalario;
		this.dataAltarecao = dataAltarecao;
		this.valorSalarioAtual = valorSalarioAtual;
		this.comprovanteRematricula = comprovanteRematricula;
	}

	public LocalDateTime getDataAltarecao() {
		return dataAltarecao;
	}

	public void setDataAltarecao(LocalDateTime dataAltarecao) {
		this.dataAltarecao = dataAltarecao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoParticipante() {
		return codigoParticipante;
	}

	public void setCodigoParticipante(Long codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}

	public Boolean getReajusteSalario() {
		return reajusteSalario;
	}

	public void setReajusteSalario(Boolean reajusteSalario) {
		this.reajusteSalario = reajusteSalario;
	}

	public BigDecimal getValorSalarioAtual() {
		return valorSalarioAtual;
	}

	public void setValorSalarioAtual(BigDecimal valorSalarioAtual) {
		this.valorSalarioAtual = valorSalarioAtual;
	}

	public String getComprovanteRematricula() {
		return comprovanteRematricula;
	}

	public void setComprovanteRematricula(String comprovanteRematricula) {
		this.comprovanteRematricula = comprovanteRematricula;
	}
}
