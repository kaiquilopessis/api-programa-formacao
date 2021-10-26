package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ParametrosFiltroForm {

    private String parametroNomeParticipante;
    private String parametroNomeFormacao;
    private String parametroNomeTurma;
    private BigDecimal parametroBolsaAux;

}
