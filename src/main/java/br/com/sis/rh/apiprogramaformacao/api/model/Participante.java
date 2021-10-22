package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PARTICIPANTE")
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cpf_participante", nullable = false, length = 12)
	private String cpfParticipante;

	@ManyToOne
	@JoinColumn(name = "codigo_programa_fk", referencedColumnName = "id", nullable = false)
	private Programa codigoPrograma;

	@ManyToOne
	@JoinColumn(name = "codigo_candidato_fk", referencedColumnName = "id", nullable = false)
	private Candidato codigoCandidato;

	@ManyToOne
	@JoinColumn(name = "codigo_remun_programa_fk", referencedColumnName = "id", nullable = false)
	private Programa codigoRemunPrograma;

	/*
	@ManyToOne
	private Participante nomeParticipante;
	 */

	@Column(length = 50, name = "nmFaculdade")
	private String nmFaculdade;

	/*
	@Column(length = 50, name = "nmCurso")
	private String nmCurso;
	 */

	@Column(name = "data_fim_graduacao")
	private LocalDate dataFimGraduacao;

	@Column(name = "TCE")
	private String tce;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;

	/*
	@Column(nullable = false, name = "foto_participante")
	private String fotoParticipante;
	 */

}