package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_REMUNERACAO_PROGRAMA")
@Getter
@Setter
public class RemuneracaoPrograma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	@Column(name = "val_hora_instrutor")
	private BigDecimal valorHoraInstrutor;
}
