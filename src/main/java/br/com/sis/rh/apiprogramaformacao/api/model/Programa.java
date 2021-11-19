package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author dkalbiak
 * 
 *         Esta classe faz a ligação com a Tabela Programa contida na database
 *         programadeformacao
 */
@Entity(name = "TB_PROGRAMA")
// Gerador getters
@Getter
// Gerador setters
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome_turma")
	private String nomeTurma;

	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@Column(name = "data_fim")
	private LocalDate dataFim;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Participante> participante;

	@Enumerated(EnumType.STRING)
	private StatusFormacao status;

	@OneToOne
	@JoinColumn(name = "processo_seletivo_fk")
	private ProcessoSeletivo processoSeletivo;
}