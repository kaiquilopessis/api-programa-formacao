package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

public class ProgramaAtualizaForm {
	
	private Long id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String instrutor;
	private String turma;
	
	public static Programa atualizar(Programa programa, Instrutor instrutor, ProgramaAtualizaForm programaAtualizaForm) {
		programa.setNomeTurma(programaAtualizaForm.getTurma());
		programa.setDataInicio(programaAtualizaForm.getDataInicio());
		programa.setDataFim(programaAtualizaForm.getDataFim());
		programa.getProcessoSeletivo().setInstrutor(instrutor);
		return programa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	

}
