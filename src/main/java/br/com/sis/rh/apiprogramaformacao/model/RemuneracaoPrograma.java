package br.com.sis.rh.apiprogramaformacao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_REMUNERACAO_PROGRAMA")
public class RemuneracaoPrograma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany
	@JoinColumn(name = "codigo_participante_fk", referencedColumnName = "cpf_participante", nullable = false)
	private Participante participacao;
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
