package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TB_CANDIDATO")
@Getter
@Setter
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
//	@Column(name = "DISC")
//	private String disc;
//	@Column(name = "curriculo")
//	private String curriculo;
	@Column(name = "curso")
	private String curso;
	@Column(name = "fonte_recrutamento")
	private String fonteRecrutamento;
	@ManyToOne
	@JoinColumn(name = "processo_seletivo_fk", referencedColumnName = "id")
	private ProcessoSeletivo processoSeletivo;
}
