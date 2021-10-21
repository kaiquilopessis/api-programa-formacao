package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParticipanteDto {

    private String cpfParticipante;
    private Programa programa;
    private String faculdade;
    private RemuneracaoPrograma remuneracaoPrograma;


    public ParticipanteDto(Participante participante) {
        this.cpfParticipante = participante.getCpfParticipante();
        this.programa = participante.getPrograma();
        this.faculdade = participante.getFaculdade();
        this.remuneracaoPrograma = participante.getRemuneracaoPrograma();
    }

}
