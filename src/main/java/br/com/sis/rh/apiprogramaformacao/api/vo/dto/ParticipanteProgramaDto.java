package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipanteProgramaDto {

    private String nomeParticipante;
    private String nomePrograma;
}
