package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteProgramaDto {

    @Column(name = "nomeParticipante")
    private String nomeParticipante;
    @Column(name = "nomePrograma")
    private String nomePrograma;



}
