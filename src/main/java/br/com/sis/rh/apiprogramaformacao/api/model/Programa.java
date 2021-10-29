package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProgramaUsuario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

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
	@Enumerated(EnumType.STRING)
	private StatusProgramaUsuario status;
	@Column(name = "qtd_aprendiz")
	private Integer qtdAprendiz;
	@Column(name = "qtd_estagiario")
	private Integer qtdEstagiario;
	@Column(name = "qtd_trainee")
	private Integer qtdTrainee;
	@Column(name = "vlr_hora_instrutor")
	private BigDecimal valorHoraInstrutor;
	@Column(name = "qtd_hora_instrutor")
	private BigDecimal qtd_hr_instrutor;
}
