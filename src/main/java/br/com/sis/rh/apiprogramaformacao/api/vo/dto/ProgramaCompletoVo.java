package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.mock.MockData;
import br.com.sis.rh.apiprogramaformacao.api.mock.MockDatasource;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramaCompletoVo {
    private Long id;
    private String nome;
    private String turma;
    private String status;
    private LocalDate inicio;
    private LocalDate termino;
    private String nomeCoordenador;
    private MockDatasource mockDatasource = new MockDatasource();

    public ProgramaCompletoVo(Programa programa){
        this.id = programa.getId();
        this.nome = programa.getNome();
        this.turma = programa.getNomeTurma();
        this.status = String.valueOf(programa.getStatus());
        this.inicio = programa.getDataInicio();
        this.termino = programa.getDataFim();

        MockData instrutor = mockDatasource.getInstrutorPorCpf(programa.getInstrutor().getCpf());
        this.nomeCoordenador = instrutor.getNome();
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTurma() {
        return turma;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public static ProgramaCompletoVo converter(Programa programa){
        return new ProgramaCompletoVo(programa);
    }

    public static List<ProgramaCompletoVo> converterParaLista(List<Programa> programas){
        List<ProgramaCompletoVo> programasVos = new ArrayList<>();

        programas.forEach(programa -> {
            programasVos.add(new ProgramaCompletoVo(programa));
        });

        return programasVos;
    }

}
