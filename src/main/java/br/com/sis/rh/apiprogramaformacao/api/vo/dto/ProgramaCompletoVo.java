package br.com.sis.rh.apiprogramaformacao.api.vo.dto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;

public class ProgramaCompletoVo {
    private Long id;
    private String nome;
    private String turma;
    private String status;
    private LocalDate inicio;
    private LocalDate termino;
    private String nomeCoordenador;

    public ProgramaCompletoVo(Programa programa){
        this.id = programa.getId();
        this.nome = programa.getProcessoSeletivo().getNome();
        this.turma = programa.getNomeTurma();
        this.status = programa.getStatus();
        this.inicio = programa.getDataInicio();
        this.termino = programa.getDataFim();
        this.nomeCoordenador = programa.getProcessoSeletivo().getInstrutor().getNome();
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }

    public static ProgramaCompletoVo converter(Programa programa){
        return new ProgramaCompletoVo(programa);
    }

    public static List<ProgramaCompletoVo> converterParaLista(List<Programa> programas){

        return programas.stream().map(ProgramaCompletoVo::new).collect(Collectors.toList());
    }

}
