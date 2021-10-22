package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidatoParticipante;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ListaCandidatoDto {

    private Long id;
    private String nome;
    private StatusCandidatoParticipante status;

    public ListaCandidatoDto (Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.status = candidato.getStatusCandidatoParticipante();
    }

    public static List<ListaCandidatoDto> toListaCandidatoDto(List<Candidato> candidato){
        return candidato.stream().map(ListaCandidatoDto::new).collect(Collectors.toList());
    }
}
