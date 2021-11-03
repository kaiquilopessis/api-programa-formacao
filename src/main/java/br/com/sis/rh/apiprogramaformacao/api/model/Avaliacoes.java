package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TB_NOTAS_AVALIACOES")
public class Avaliacoes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nota_tecnica")
	private Double notaTecnica;
	@Column(name = "nota_comportamental")
	private Double notaComportamental;
	@Column(name = "nota_praticas_ageis")
	private Double notaPraticasAgeis;
	@Column(name = "nota_lideranca")
	private Double notaLideranca;
	@Column(name = "nota_negocio")
	private Double notaNegocio;
	@ManyToOne
	@JoinColumn(name = "codigo_participante_fk")
	private Participante participante;
	
	public Avaliacoes() {}

	public Avaliacoes(Long id, Double nota_tecnica, Double nota_comportamental,
			Double nota_praticas_ageis, Double nota_lideranca, Double nota_negocio) {
		this.id = id;
		this.notaTecnica = nota_tecnica;
		this.notaComportamental = nota_comportamental;
		this.notaPraticasAgeis = nota_praticas_ageis;
		this.notaLideranca = nota_lideranca;
		this.notaNegocio = nota_negocio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNota_tecnica() {
		return notaTecnica;
	}

	public void setNota_tecnica(Double nota_tecnica) {
		this.notaTecnica = nota_tecnica;
	}

	public Double getNota_comportamental() {
		return notaComportamental;
	}

	public void setNota_comportamental(Double nota_comportamental) {
		this.notaComportamental = nota_comportamental;
	}

	public Double getNota_praticas_ageis() {
		return notaPraticasAgeis;
	}

	public void setNota_praticas_ageis(Double nota_praticas_ageis) {
		this.notaPraticasAgeis = nota_praticas_ageis;
	}

	public Double getNota_lideranca() {
		return notaLideranca;
	}

	public void setNota_lideranca(Double nota_lideranca) {
		this.notaLideranca = nota_lideranca;
	}

	public Double getNota_negocio() {
		return notaNegocio;
	}

	public void setNota_negocio(Double nota_negocio) {
		this.notaNegocio = nota_negocio;
	}
	
	@Override
	public String toString() {
		return "Id= " + this.id + ", Nota = " + this.notaTecnica;
	}
}
