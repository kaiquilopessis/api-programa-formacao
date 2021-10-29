package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TB_CANDIDATO")
@Getter
@Setter
@NoArgsConstructor
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@Column(name = "telefone", nullable = false, length = 255)
	private String telefone;
	@Column(name = "data_agendamento")
	private LocalDate dataAgendamento;
	@Column(name = "curriculo")
	private byte[] curriculo;
	@Column(name = "teste_logico", nullable = false)
	private BigDecimal testeLogico;
	@Column(name = "DISC")
	private byte[] disc;
	@Column(name = "nota_disc", length = 15, nullable = false)
	private String notaDisc;
	@Column(name = "status", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private StatusCandidato statusCandidato;
	@Column(name = "observacao", length = 8000)
	private String observacao;
	@Column(name = "curso")
	private String curso;
	@Column(name = "fonte_recrutamento")
	private String fonteRecrutamento;
}
