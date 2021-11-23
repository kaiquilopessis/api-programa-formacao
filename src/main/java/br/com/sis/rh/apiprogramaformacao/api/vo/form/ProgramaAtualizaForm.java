package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

public class ProgramaAtualizaForm {
	
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String cpfInstrutor;
	private String turma;
	
	public Programa atualizar(Long id, ProgramaRepository programaRepository, InstrutorRepository instrutorRepository ) {
		Programa programa = programaRepository.getById(id);
		Instrutor instrutor = instrutorRepository.getById(this.cpfInstrutor);
		
		programa.setNomeTurma(this.turma);
		programa.setDataInicio(this.dataInicio);
		programa.setDataFim(this.dataFim);
		programa.getProcessoSeletivo().setInstrutor(instrutor);
		programaRepository.save(programa);
		return programa;
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
	
	public String getCpfInstrutor() {
		return cpfInstrutor;
	}

	public void setCpfInstrutor(String cpfInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
	}

	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	

}
