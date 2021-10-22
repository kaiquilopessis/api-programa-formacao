package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ParticipanteDto {

    private Long id;
    private String cpfParticipante;
    private Programa codigoRemunPrograma;

    public ParticipanteDto(Participante participante) {
        this.id = participante.getId();
        this.cpfParticipante = participante.getCpfParticipante();
        this.codigoRemunPrograma = participante.getCodigoRemunPrograma();
    }
}
