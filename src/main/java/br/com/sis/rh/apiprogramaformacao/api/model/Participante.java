package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TB_PARTICIPANTE")
@Getter
@Setter
public class Participante {

	@Id
	@Column(name = "cpf_participante", length = 12)
	private String cpfParticipante;
	@ManyToOne
	@JoinColumn(name = "codigo_programa_fk", referencedColumnName = "id", nullable = false)
	private Programa programa;
	@OneToOne
	@JoinColumn(name = "codigo_candidato_fk", referencedColumnName = "id", nullable = false)
	private Candidato cadidato;
	@ManyToOne
	@JoinColumn(name = "codigo_remun_programa_fk", referencedColumnName = "id", nullable = false)
	private RemuneracaoPrograma remuneracaoPrograma;
	@Column(name = "nmFaculdade", length = 50)
	private String faculdade;
	@Column(name = "nmCurso", length = 50)
	private String curso;
	@Column(name = "data_fim_graduacao")
	private LocalDate dataFinal;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
//	@Column(name = "TCE")
//	private File tce;
}
