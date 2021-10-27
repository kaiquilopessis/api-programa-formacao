package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_REMUNERACAO")
public class RemuneracaoPrograma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cargo;
	@Column(name = "bolsa_aux")
	private BigDecimal bolsa;
	private BigDecimal beneficios;
	private BigDecimal convenio;
	@Column(name = "hr_extra")
	private BigDecimal horaExtra;
	@Column(name = "beneficio_legislacao")
	private BigDecimal beneficioLegislacao;
	
	@Column(name = "remun_exporadica")
	private BigDecimal remunExporadica;
	
	@Column(name = "remun_extra")
	private BigDecimal remunExtra;
	
	private BigDecimal alura;

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

	public BigDecimal getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(BigDecimal beneficios) {
		this.beneficios = beneficios;
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

	public BigDecimal getRemunExporadica() {
		return remunExporadica;
	}
	public void setRemunExporadica(BigDecimal remunExporadica) {
		this.remunExporadica = remunExporadica;
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