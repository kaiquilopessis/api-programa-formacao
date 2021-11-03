package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta classe faz a ligação com a Tabela Programa contida na database programadeformacao
 */

@Entity(name = "TB_PROGRAMA")
@Getter
@Setter
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	private String nome_turma;
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
	
	@Enumerated(EnumType.STRING)
	private StatusFormacao status;

	public Programa() {
	}

	public Programa(Long id, String nome, StatusFormacao status, String nome_turma, LocalDate dataFim) {
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.nome_turma = nome_turma;
		this.dataFim = dataFim;
	}
}
