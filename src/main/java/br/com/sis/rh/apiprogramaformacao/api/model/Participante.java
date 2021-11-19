package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author dkalbiak Esta classe faz a ligação com a Tabela Participantes contida
 *         na database programadeformacao
 */
@Entity(name = "TB_PARTICIPANTE")
// Generates getters for all fields Lombok
@Data
public class Participante {

	@Id
	@Column(name = "cpf_participante")
	private String cpf;

	@Column(name = "nm_faculdade")
	private String nomeFaculdade;

	@Column(name = "nm_curso")
	private String nomeCurso;

	@Column(name = "data_fim_graduacao")
	private LocalDate dataFimGraduacao;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Alura> alura;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Avaliacoes> avaliacoes;

	@ManyToOne
	@JoinColumn(name = "codigo_programa_fk")
	private Programa programa;

	@ManyToOne
	@JoinColumn(name = "FK_codigo_remun")
	private Remuneracao remuneracao;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Conclusao> conclusao;

	@Enumerated(EnumType.STRING)
	private StatusEfetivo statusEfetivado;

	@Enumerated(EnumType.STRING)
	private StatusAtivo statusAtivo;

	@OneToOne
	@JoinColumn(name = "codigo_candidato_fk")
	private Candidato candidato;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Investimento> investimentos;

	public Participante() {
	}

	public Participante(String cpf, String nomeFaculdade, String nomeCurso, LocalDate dataFimGraduacao,
						List<Alura> alura, StatusEfetivo statusEfetivado, StatusAtivo statusAtivo, Remuneracao remuneracao) {
		this.cpf = cpf;
		this.nomeFaculdade = nomeFaculdade;
		this.nomeCurso = nomeCurso;
		this.dataFimGraduacao = dataFimGraduacao;
		this.alura = alura;
		this.statusEfetivado = statusEfetivado;
		this.statusAtivo = statusAtivo;
		this.remuneracao = remuneracao;
	}

	@Override
	public String toString() {
		return "CPF: " + this.cpf;
	}
}