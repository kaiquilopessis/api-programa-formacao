package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Classe/Entidade que representa a tabela TB_ALURA da base de dados,
 * os métodos getter e setter estão implementados pelo Lombok utilizando
 * a anotação @Data
 */

@Entity(name = "TB_ALURA")
@Data
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

}