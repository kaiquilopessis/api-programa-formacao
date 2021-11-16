package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramaBuscaVo {
    private Long id;
    private String nome;
    private String turma;
    private String status;

    public ProgramaBuscaVo(Programa programa){
        this.id = programa.getId();
        this.nome = programa.getProcessoSeletivo().getNome();
        this.turma = programa.getNomeTurma();
        this.status = programa.getStatus();
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

    public static ProgramaBuscaVo converter(Programa programa){
        return new ProgramaBuscaVo(programa);
    }

    public static List<ProgramaBuscaVo> converterParaLista(List<Programa> programas){
//        List<ProgramaBuscaVo> programasVos = new ArrayList<>();
//
//        programas.forEach(programa -> {
//            programasVos.add(new ProgramaBuscaVo(programa));
//        });
//
//        return programasVos;
    	return programas.stream().map(ProgramaBuscaVo::new).collect(Collectors.toList());
    }

}
