package br.com.sis.rh.apiprogramaformacao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARTICIPANTE")
public class Participante {

	@Id
	@Column(name = "cpf_participante", length = 12)
	private String cpfParticipante;
	@OneToOne
	@JoinColumn(name = "codigo_programa_fk", referencedColumnName = "id", nullable = false)
	private Programa programa;
	@OneToOne
	@JoinColumn(name = "codigo_candidato_fk", referencedColumnName = "id", nullable = false)
	private Candidato cadidato;
	@Column(name = "nome_participante", length = 50)
	private String nome;
	@Column(name = "nmCargo", length = 30)
	private String cargo;
	@Column(name = "nmFaculdade", length = 50)
	private String faculdade;
	@Column(name = "nmCurso", length = 50)
	private String curso;
	@Column(name = "data_fim_graduacao")
	private LocalDate dataFinal;
	@Column(name = "status")
	private long status;
	//Falta o TCE e Foto_participante
}
