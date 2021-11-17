package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProgramaUsuario;

@Entity
@Table(name = "TB_PROGRAMA")
public class Programa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	@Column(name = "nome_turma", nullable = false, length = 50)
	private String nomeTurma;
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusFormacao status;
	@OneToOne
	@JoinColumn(name = "processo_seletivo_fk", referencedColumnName = "id", nullable = false)
	private ProcessoSeletivo processoSeletivo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public StatusFormacao getStatus() {
		return status;
	}

	public void setStatus(StatusFormacao status) {
		this.status = status;
	}

	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}

	public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
	}

}
