package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class ParticipanteBuscaVo {
    private String cpf;
    private String nome;
    private String programa;
    private String turmaPrograma;
    private String status;

    public ParticipanteBuscaVo(Participante participante){
        this.cpf = participante.getCpf();
        this.programa = participante.getPrograma().getProcessoSeletivo().getNome();
        this.turmaPrograma = participante.getPrograma().getNomeTurma();
        this.status = participante.getStatus().toString();
        this.nome = participante.getCandidato().getNome();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return this.nome;
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
//        List<ParticipanteBuscaVo> participantesVo = new ArrayList<>();
//
//        participantes.forEach(participante -> {
//            participantesVo.add(new ParticipanteBuscaVo(participante));
//        });
//
//        return participantesVo;
    	return participantes.stream().map(ParticipanteBuscaVo::new).collect(Collectors.toList());
    }
}
