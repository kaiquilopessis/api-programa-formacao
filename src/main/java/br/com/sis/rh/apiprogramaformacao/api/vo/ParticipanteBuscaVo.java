package br.com.sis.rh.apiprogramaformacao.api.vo;

import br.com.sis.rh.apiprogramaformacao.api.mock.MockData;
import br.com.sis.rh.apiprogramaformacao.api.mock.MockDatasource;
import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteBuscaVo {
    private String cpf;
    private String nome;
    private String programa;
    private String status;
    private MockDatasource mockDatasource = new MockDatasource();

    public ParticipanteBuscaVo(Participante participante){
        this.cpf = participante.getCpf();
        this.programa = participante.getPrograma().getNome();
        this.status = participante.getStatus();
    }

    public String getId() {
        return cpf;
    }

    public String getNome() {
        MockData participanteMock = mockDatasource.getParticipantePorCpf(this.cpf);

        return participanteMock.getNome();
    }

    public String getPrograma() {
        return programa;
    }

    public String getStatus() {
        return status;
    }

    public static ParticipanteBuscaVo converter(Participante participante){
        return new ParticipanteBuscaVo(participante);
    }

    public static List<ParticipanteBuscaVo> converterLista(List<Participante> participantes){
        List<ParticipanteBuscaVo> participantesVo = new ArrayList<>();

        participantes.forEach(participante -> {
            participantesVo.add(new ParticipanteBuscaVo(participante));
        });

        return participantesVo;
    }
}
