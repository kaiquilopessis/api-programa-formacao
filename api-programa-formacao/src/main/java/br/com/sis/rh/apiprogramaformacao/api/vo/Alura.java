package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALURA")
public class Alura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_ALURA")
	private Long codigoAlura;

	@JoinColumn(name = "CODIGO_PARTICIPANTE")
	private Long codigoParticipante;

	@Column(name = "QTD_HORAS")
	private Integer qtdHoras;

	@Column(name = "MES_AVALIADO")
	private int mesAvaliado;

	@Column(name = "SEMANA_AVALIADA")
	private int semanaAvaliada;

	@Column(name = "DATA_REGISTRO")
	private LocalDateTime dataRegistro;

	@Column(name = "HR_MIN_SEMANA")
	private int hrMinSemana;

	public Alura(Long codigoAlura, Long codigoParticipante, Integer qtdHoras, int mesAvaliado, int semanaAvaliada,
			LocalDateTime dataRegistro, int hrMinSemana) {
		super();
		this.codigoAlura = codigoAlura;
		this.codigoParticipante = codigoParticipante;
		this.qtdHoras = qtdHoras;
		this.mesAvaliado = mesAvaliado;
		this.semanaAvaliada = semanaAvaliada;
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

	public Long getCodigoParticipante() {
		return codigoParticipante;
	}

	public void setCodigoParticipante(Long codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public int getMesAvaliado() {
		return mesAvaliado;
	}

	public void setMesAvaliado(int mesAvaliado) {
		this.mesAvaliado = mesAvaliado;
	}

	public int getSemanaAvaliada() {
		return semanaAvaliada;
	}

	public void setSemanaAvaliada(int semanaAvaliada) {
		this.semanaAvaliada = semanaAvaliada;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public int getHrMinSemana() {
		return hrMinSemana;
	}

	public void setHrMinSemana(int hrMinSemana) {
		this.hrMinSemana = hrMinSemana;
	}
}
