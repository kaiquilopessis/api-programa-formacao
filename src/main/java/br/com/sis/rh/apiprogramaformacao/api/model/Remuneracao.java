package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_REMUNERACAO")
public class Remuneracao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "cargo", length = 30)
	private String cargo;
	@Column(name = "bolsa_aux")
	private BigDecimal bolsa;
	@Column(name = "beneficios")
	private BigDecimal beneficio;
	private BigDecimal convenio;
	@Column(name = "hr_extra")
	private BigDecimal horaExtra;
	@Column(name = "beneficio_legislacao")
	private BigDecimal beneficioLegislacao;
	@Column(name = "remun_esporadica")
	private BigDecimal remunEsporadica;
	@Column(name = "remun_extra")
	private BigDecimal remunExtra;
	private BigDecimal alura;

	public Remuneracao(String cargo, BigDecimal bolsa, BigDecimal beneficio, BigDecimal convenio,
					   BigDecimal horaExtra, BigDecimal beneficioLegislacao, BigDecimal remunEsporadica,
					   BigDecimal remunExtra, BigDecimal alura){
		this.cargo = cargo;
		this.bolsa = bolsa;
		this.beneficio = beneficio;
		this.convenio = convenio;
		this.horaExtra = horaExtra;
		this.beneficioLegislacao = beneficioLegislacao;
		this.remunEsporadica = remunEsporadica;
		this.remunExtra = remunExtra;
		this.alura = alura;
	}

	public Remuneracao(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getBolsa() {
		return bolsa;
	}

	public void setBolsa(BigDecimal bolsa) {
		this.bolsa = bolsa;
	}

	public BigDecimal getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(BigDecimal beneficio) {
		this.beneficio = beneficio;
	}

	public BigDecimal getConvenio() {
		return convenio;
	}

	public void setConvenio(BigDecimal convenio) {
		this.convenio = convenio;
	}

	public BigDecimal getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(BigDecimal horaExtra) {
		this.horaExtra = horaExtra;
	}

	public BigDecimal getBeneficioLegislacao() {
		return beneficioLegislacao;
	}

	public void setBeneficioLegislacao(BigDecimal beneficioLegislacao) {
		this.beneficioLegislacao = beneficioLegislacao;
	}

	public BigDecimal getRemunEsporadica() {
		return remunEsporadica;
	}

	public void setRemunExporadica(BigDecimal remunEsporadica) {
		this.remunEsporadica = remunEsporadica;
	}

	public BigDecimal getRemunExtra() {
		return remunExtra;
	}

	public void setRemunExtra(BigDecimal remunExtra) {
		this.remunExtra = remunExtra;
	}

	public BigDecimal getAlura() {
		return alura;
	}

	public void setAlura(BigDecimal alura) {
		this.alura = alura;
	}
}
