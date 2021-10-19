package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROGRAMA")
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name = "cpf_instrutor", referencedColumnName = "cpf_instrutor", nullable = false)
	private Instrutor instrutor;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	@Column(name = "nome_turma", nullable = false, length = 50)
	private String nomeTurma;
	@Column(name = "status", nullable = false)
	private long status;
	@Column(name = "qtd_aprendiz")
	private long qtdAprendiz;
	@Column(name = "qtd_estagiario")
	private long qtdEstagiario;
	@Column(name = "qtd_trainee")
	private long qtdTrainee;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}

	public long getQtdAprendiz() {
		return qtdAprendiz;
	}
	public void setQtdAprendiz(long qtdAprendiz) {
		this.qtdAprendiz = qtdAprendiz;
	}

	public long getQtdEstagiario() {
		return qtdEstagiario;
	}
	public void setQtdEstagiario(long qtdEstagiario) {
		this.qtdEstagiario = qtdEstagiario;
	}

	public long getQtdTrainee() {
		return qtdTrainee;
	}
	public void setQtdTrainee(long qtdTrainee) {
		this.qtdTrainee = qtdTrainee;
	}
}
