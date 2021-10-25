package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class RemuneraçãoProgramaDto {

    private BigDecimal bolsaAux;

    public RemuneraçãoProgramaDto(RemuneracaoPrograma remuneracaoPrograma){
        this.bolsaAux = remuneracaoPrograma.getBolsa();
    }
}
