package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TB_PARTICIPANTE")
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
	private long status;
	@Column(name = "TCE")
	private String tce;

	public String getCpfParticipante() {
		return cpfParticipante;
	}
	public void setCpfParticipante(String cpfParticipante) {
		this.cpfParticipante = cpfParticipante;
	}

	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Candidato getCadidato() {
		return cadidato;
	}
	public void setCadidato(Candidato cadidato) {
		this.cadidato = cadidato;
	}

	public RemuneracaoPrograma getRemuneracaoPrograma() {
		return remuneracaoPrograma;
	}
	public void setRemuneracaoPrograma(RemuneracaoPrograma remuneracaoPrograma) {
		this.remuneracaoPrograma = remuneracaoPrograma;
	}

	public String getFaculdade() {
		return faculdade;
	}
	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}

	public String getTce() {
		return tce;
	}
	public void setTce(String tce) {
		this.tce = tce;
	}
}
