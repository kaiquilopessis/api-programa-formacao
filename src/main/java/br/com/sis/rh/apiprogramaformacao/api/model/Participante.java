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
	private Candidato candidato;
	@ManyToOne
	@JoinColumn(name = "fk_codigo_remun", referencedColumnName = "id", nullable = false)
	private RemuneracaoPrograma remuneracaoPrograma;
	@Column(name = "nmFaculdade", length = 50)
	private String faculdade;
	@Column(name = "nmCurso", length = 50)
	private String curso;
	@Column(name = "data_fim_graduacao")
	private LocalDate dataFinal;
	@Column(name = "status_ativo")
	private String status;
	@Column(name = "TCE")
	private String tce;
	@Column(name = "status_efetivado")
	private String statusEfetivado;

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

	public Candidato getCandidato() {
		return candidato;
	}
	public void setCadidato(Candidato candidato) {
		this.candidato = candidato;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusEfetivado() {
		return statusEfetivado;
	}

	public void setStatusEfetivado(String statusEfetivado) {
		this.statusEfetivado = statusEfetivado;
	}

	public String getTce() {
		return tce;
	}

	public void setTce(String tce) {
		this.tce = tce;
	}
	
	
}
