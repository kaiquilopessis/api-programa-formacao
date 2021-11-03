package br.com.sis.rh.apiprogramaformacao.api.model;

/**
 * Esta classe faz a ligação com a Tabela Programa contida na database programadeformacao
 */

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "TB_PROGRAMA")
@Data
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	@Column(name = "data_fim")
	private LocalDate dataFim;
	@Column(name = "vlr_hora_instrutor")
	private Double valorHora;
	@Column(name = "qtd_hr_instrutor")
	private Double QTDHora;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Participante> participante;

}
