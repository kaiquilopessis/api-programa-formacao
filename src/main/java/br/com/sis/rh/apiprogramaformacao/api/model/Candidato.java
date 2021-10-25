package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_CANDITADO")
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
}
