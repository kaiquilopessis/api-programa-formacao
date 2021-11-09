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
	private Float notaTecnica;

	@Column(name = "NOTA_PRATICAS_AGEIS")
	private Float notaPraticasAgeis;

	@Column(name = "NOTA_LIDERANCA")
	private Float notaLideranca;

	@Column(name = "NOTA_NEGOCIO")
	private Float notaNegocios;

	@OneToOne
	@JoinColumn(name = "NOTA_COMPORTAMENTAL_FK")
	private AvaliacaoDesempenho avaliacaoDesempenho;

	public Avaliacoes(Participante participante, Float notaTecnica, Float notaPraticasAgeis, Float notaLideranca,
			Float notaNegocios, AvaliacaoDesempenho avaliacaoDesempenho) {

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

	public Float getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Float notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public Float getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(Float notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public Float getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(Float notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public Float getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(Float notaNegocios) {
		this.notaNegocios = notaNegocios;
	}

	public AvaliacaoDesempenho getAvaliacaoDesempenho() {
		return avaliacaoDesempenho;
	}

	public void setAvaliacaoDesempenho(AvaliacaoDesempenho avaliacaoDesempenho) {
		this.avaliacaoDesempenho = avaliacaoDesempenho;
	}

}
