package br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;


@Entity
@Table(name="TB_ALURA")
public class Alura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long codigoAlura;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PARTICIPANTE_FK")
	private Participante participante;

	@Column(name = "QTD_HORAS")
	private Integer qtdHoras;

	@Column(name = "DATA_REGISTRO")
	private LocalDate dataRegistro;

	@Column(name = "HR_MIN_SEMANA")
	private Integer hrMinSemana;

	public Alura( Participante participante, Integer qtdHoras, LocalDate dataRegistro, Integer hrMinSemana) {
		
		this.participante = participante;
		this.qtdHoras = qtdHoras;
		this.dataRegistro = dataRegistro;
		this.hrMinSemana = hrMinSemana;
	}
	
	public Alura() {
		
	}
	

	public Long getCodigoAlura() {
		return codigoAlura;
	}

	public void setCodigoAlura(Long codigoAlura) {
		this.codigoAlura = codigoAlura;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Integer getHrMinSemana() {
		return hrMinSemana;
	}

	public void setHrMinSemana(Integer hrMinSemana) {
		this.hrMinSemana = hrMinSemana;
	}

	
}
