package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class SalarioInstrutorDto {
    private List<BigDecimal> salarioFinal;
}
