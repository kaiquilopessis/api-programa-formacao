package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FEEDBACK")
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="DAT_FEEDBACK")
	private LocalDate data;
	
	@Column(name="ANOTACOES")
	private String anotacoes;
	
	@Column(name="CODIGO_PARTICIPANTE")
	private Long idParticipante;
	
	
	
	
	
	
	public FeedBack(Long id, LocalDate data, String anotacoes, Long idParticipante) {
		this.id = id;
		this.data = data;
		this.anotacoes = anotacoes;
		this.idParticipante = idParticipante;
	}


	public FeedBack() {
		
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


	public Long getIdParticipante() {
		return idParticipante;
	}


	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}



	
}
