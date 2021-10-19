package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_NOTAS_AVALIACOES")
public class Avaliacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name = "CODIGO_PARTICIPANTE")
	private Long codigoParticipante;
	
	@Column(name="NOTA_TECNICA")
	private Float notaTecnica;
	
	@Column(name="NOTA_COMPORTAMENTAL")
	private Float notaComportamental;
	
	@Column(name="NOTA_PATRICAS_AGEIS")
	private Float notaPraticasAgeis;
	
	@Column(name="NOTA_LIDERANCA")
	private Float notaLideranca;
	
	@Column(name="NOTA_NEGOCIOS")
	private Float notaNegocios;


	
	

	public Avaliacoes(Long id, Long codigoParticipante, Float notaTecnica, Float notaComportamental,
			Float notaPraticasAgeis, Float notaLideranca, Float notaNegocios) {
		this.id = id;
		this.codigoParticipante = codigoParticipante;
		this.notaTecnica = notaTecnica;
		this.notaComportamental = notaComportamental;
		this.notaPraticasAgeis = notaPraticasAgeis;
		this.notaLideranca = notaLideranca;
		this.notaNegocios = notaNegocios;
	}
	
	public Avaliacoes() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoParticipante() {
		return codigoParticipante;
	}

	public void setCodigoParticipante(Long codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}

	public Float getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Float notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public Float getNotaComportamental() {
		return notaComportamental;
	}

	public void setNotaComportamental(Float notaComportamental) {
		this.notaComportamental = notaComportamental;
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
	
}
