package br.com.sis.rh.apiprogramaformacao.api.model;

/**
 * Esta classe faz a ligação com a Tabela Participantes contida na database programadeformacao
 */

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "TB_PARTICIPANTE")
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

	@ManyToOne
	@JoinColumn(name = "codigo_programa_fk")
	private Programa programa;

	@ManyToOne
	@JoinColumn(name = "FK_codigo_remun")
	private Remuneracao remuneracao;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Conclusao> conclusao;

}
