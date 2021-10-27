package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

public class ProgramaForm {
    private String nome;
    private LocalDate inicio;
    private LocalDate termino;
    private String coordenador;
    private String turma;
    
    public ProgramaForm(Programa programa) {
    	this.coordenador = programa.getInstrutor().toString();
    	this.nome = programa.getNome();
    	this.inicio = programa.getDataInicio();
    	this.termino = programa.getDataFim();
    	this.turma = programa.getNomeTurma();
    	
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }
    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public String getCoordenador() {
        return coordenador;
    }
    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public static ProgramaForm converter(Programa programa) {
    	return new ProgramaForm(programa);
    }
    
    public static List<ProgramaForm> converteLista(List<Programa> programas){
    	List<ProgramaForm> programasForm = new ArrayList<>();    	
    	programas.forEach(programa ->{
    		programasForm.add(new ProgramaForm(programa));
    	});
    	
    	return programasForm;
    }
}
