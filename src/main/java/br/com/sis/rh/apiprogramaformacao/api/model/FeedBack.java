package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FEEDBACK")
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DT_FEEDBACK")
	private LocalDate data;

	@Column(name = "ANOTACOES")
	private String anotacoes;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PARTICIPANTE_FK")
	private Participante participante;

	@Column(name = "DISC")
	@Lob
	private byte[] disc;

	public FeedBack(LocalDate data, String anotacoes, Participante participante, byte[] disc) {
		this.data = data;
		this.anotacoes = anotacoes;
		this.participante = participante;
		this.disc = disc;
	}

	public FeedBack() {

	}

	public byte[] getDisc() {
		return disc;
	}

	public void setDisc(byte[] disc) {
		this.disc = disc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
