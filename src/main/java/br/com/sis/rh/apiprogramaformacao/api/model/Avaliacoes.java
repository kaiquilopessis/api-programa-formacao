package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TB_NOTAS_AVALIACOES")
public class Avaliacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PARTICIPANTE_FK")
	private Participante participante;

	@Column(name = "NOTA_TECNICA")
	private Double notaTecnica;

	@Column(name = "NOTA_PRATICAS_AGEIS")
	private Double notaPraticasAgeis;

	@Column(name = "NOTA_LIDERANCA")
	private Double notaLideranca;

	@Column(name = "NOTA_NEGOCIO")
	private Double notaNegocios;

	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "NOTA_COMPORTAMENTAL_FK")
	private AvaliacaoDesempenho avaliacaoDesempenho;

	public Avaliacoes(Participante participante, Double notaTecnica, Double notaPraticasAgeis, Double notaLideranca,
			Double notaNegocios, AvaliacaoDesempenho avaliacaoDesempenho) {

		this.participante = participante;
		this.notaTecnica = notaTecnica;
		this.notaPraticasAgeis = notaPraticasAgeis;
		this.notaLideranca = notaLideranca;
		this.notaNegocios = notaNegocios;
		this.avaliacaoDesempenho = avaliacaoDesempenho;
	}

	public Avaliacoes() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Double getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Double notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public Double getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(Double notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public Double getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(Double notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public Double getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(Double notaNegocios) {
		this.notaNegocios = notaNegocios;
	}

	public AvaliacaoDesempenho getAvaliacaoDesempenho() {
		return avaliacaoDesempenho;
	}

	public void setAvaliacaoDesempenho(AvaliacaoDesempenho avaliacaoDesempenho) {
		this.avaliacaoDesempenho = avaliacaoDesempenho;
	}

}
