package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;

public class ProcessoSeletivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer qtdAprendiz;
	private Integer qtdTrainee;
	private Integer qtdEstagiario;
	@Enumerated(EnumType.STRING)
	private StatusProcessoSeletivo status;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	public ProcessoSeletivo(String nome, Integer qtdAprendiz, Integer qtdTrainee, Integer qtdEstagiario,
			StatusProcessoSeletivo status, LocalDate dataInicio, LocalDate dataFim) {
		this.nome = nome;
		this.qtdAprendiz = qtdAprendiz;
		this.qtdTrainee = qtdTrainee;
		this.qtdEstagiario = qtdEstagiario;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public ProcessoSeletivo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdAprendiz() {
		return qtdAprendiz;
	}

	public void setQtdAprendiz(Integer qtdAprendiz) {
		this.qtdAprendiz = qtdAprendiz;
	}

	public Integer getQtdTrainee() {
		return qtdTrainee;
	}

	public void setQtdTrainee(Integer qtdTrainee) {
		this.qtdTrainee = qtdTrainee;
	}

	public Integer getQtdEstagiario() {
		return qtdEstagiario;
	}

	public void setQtdEstagiario(Integer qtdEstagiario) {
		this.qtdEstagiario = qtdEstagiario;
	}

	public StatusProcessoSeletivo getStatus() {
		return status;
	}

	public void setStatus(StatusProcessoSeletivo status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

}
