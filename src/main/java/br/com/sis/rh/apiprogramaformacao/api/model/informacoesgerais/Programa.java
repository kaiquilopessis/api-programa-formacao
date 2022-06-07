package br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;


@Entity
@Table(name = "TB_PROGRAMA")
public class Programa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "processo_seletivo_fk", referencedColumnName = "id", nullable = false)
	private ProcessoSeletivo processoSeletivo;
	
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	
	@Column(name = "nome_turma", nullable = false, length = 50)
	private String nomeTurma;
	
	@Column(name = "status", nullable = false)
	private String status;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}

	public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
