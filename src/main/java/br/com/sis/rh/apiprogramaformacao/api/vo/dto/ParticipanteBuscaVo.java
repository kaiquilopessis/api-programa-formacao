package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipanteBuscaVo {
    private String cpf;
    private String nome;
    private String programa;
    private String turmaPrograma;
    private String status;

    public ParticipanteBuscaVo(Participante participante){
        this.cpf = participante.getCpf();
        this.programa = participante.getPrograma().getProcessoSeletivo().getNome();
        this.nome = participante.getCandidato().getNome();
        this.turmaPrograma = participante.getPrograma().getNomeTurma();
        this.status = participante.getStatus();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setTurmaPrograma(String turmaPrograma) {
        this.turmaPrograma = turmaPrograma;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getPrograma() {
        return programa;
    }

    public String getStatus() {
        return status;
    }

    public String getTurmaPrograma() {
        return turmaPrograma;
    }

    public static ParticipanteBuscaVo converter(Participante participante){
        return new ParticipanteBuscaVo(participante);
    }

    public static List<ParticipanteBuscaVo> converterLista(List<Participante> participantes){
        return participantes.stream().map(ParticipanteBuscaVo::new).collect(Collectors.toList());
    }
}
