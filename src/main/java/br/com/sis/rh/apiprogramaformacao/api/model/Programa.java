package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROGRAMA")
@Getter
@Setter
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "cpf_instrutor", referencedColumnName = "cpf_instrutor", nullable = false)
	private Instrutor instrutor;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	@Column(name = "nome_turma", nullable = false, length = 50)
	private String nomeTurma;
	@Column(name = "status", nullable = false)
	private long status;
	@Column(name = "qtd_aprendiz")
	private long qtdAprendiz;
	@Column(name = "qtd_estagiario")
	private long qtdEstagiario;
	@Column(name = "qtd_trainee")
	private long qtdTrainee;

}
