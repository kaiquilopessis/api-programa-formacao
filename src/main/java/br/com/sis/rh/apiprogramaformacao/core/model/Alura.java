package br.com.sis.rh.apiprogramaformacao.core.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "TB_ALURA")
@Getter
@Setter
public class Alura {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "qtd_horas")
	private Integer qtdHoras;
	@Column(name = "mes_avaliado")
	private Integer mesAvaliado;
	@Column(name = "semana_avaliada")
	private Integer semanaAvaliada;
	@Column(name = "data_registro")
	private LocalDate dataRegistro;
	@Column(name = "hr_min_semana")
	private Integer hrMinSemana;
	@ManyToOne
	@JoinColumn(name = "codigo_participante_fk")
	private Participante participante;
	
	public Alura() {}

	public Alura(Long id, Integer qtdHoras, Integer mesAvaliado,
			Integer semanaAvaliada, LocalDate dataRegistro, Integer hrMinSemana) {
		this.id = id;
		this.qtdHoras = qtdHoras;
		this.mesAvaliado = mesAvaliado;
		this.semanaAvaliada = semanaAvaliada;
		this.dataRegistro = dataRegistro;
		this.hrMinSemana = hrMinSemana;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(Integer qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public Integer getMesAvaliado() {
		return mesAvaliado;
	}

	public void setMesAvaliado(Integer mesAvaliado) {
		this.mesAvaliado = mesAvaliado;
	}

	public Integer getSemanaAvaliada() {
		return semanaAvaliada;
	}

	public void setSemanaAvaliada(Integer semanaAvaliada) {
		this.semanaAvaliada = semanaAvaliada;
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

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + ", Qtd horas: " + this.qtdHoras + ", Mês: " + this.mesAvaliado
				+ ", Semana: " + this.semanaAvaliada + ", Data Registro: " + this.dataRegistro + ", Min Horas: " + this.hrMinSemana;
	}
}