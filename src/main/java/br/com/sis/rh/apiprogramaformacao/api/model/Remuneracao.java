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
@Getter
@Setter
@NoArgsConstructor
public class Remuneracao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "cargo", length = 30)
	private String cargo;
	@Column(name = "bolsa_aux")
	private BigDecimal bolsa;
	@Column(name = "beneficios")
	private BigDecimal beneficio;
	@Column(name = "convenio")
	private BigDecimal convenio;
	@Column(name = "hr_extra")
	private BigDecimal horaExtra;
	@Column(name = "beneficio_legislacao")
	private BigDecimal beneficioLegislacao;
	@Column(name = "remun_esporadica")
	private BigDecimal remunEsporadica;
	@Column(name = "remun_extra")
	private BigDecimal remunExtra;
	@Column(name = "alura")
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
}
