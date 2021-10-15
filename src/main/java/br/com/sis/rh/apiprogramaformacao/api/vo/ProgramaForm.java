package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.time.LocalDate;

public class ProgramaForm {
    private String nome;
    private LocalDate inicio;
    private LocalDate termino;
    private Long id;
    private String turma;

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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
}
