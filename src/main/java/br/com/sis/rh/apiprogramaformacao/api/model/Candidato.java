package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidatoParticipante;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
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
	private Long id;
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
	@Column(name = "status", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private StatusCandidatoParticipante statusCandidatoParticipante;
	@Column(name = "observacao", length = 8000)
	private String observacao;
	@Column(name = "DISC")
	private byte[] disc;
	@Column(name = "curriculo")
	private File curriculo;
	@Column(name = "curso")
	private String curso;
	@Column(name = "fonte_recrutamento")
	private String fonteRecrutamento;
}
