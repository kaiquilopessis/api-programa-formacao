package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


public class ParametrosFiltroFolhaForm {

    private String parametroNomeParticipante;
    private String parametroNomeFormacao;
    private String parametroNomeTurma;
    private BigDecimal parametroBolsaAux;

    public String getParametroNomeParticipante() {
        return parametroNomeParticipante;
    }

    public void setParametroNomeParticipante(String parametroNomeParticipante) {
        this.parametroNomeParticipante = parametroNomeParticipante;
    }

    public String getParametroNomeFormacao() {
        return parametroNomeFormacao;
    }

    public void setParametroNomeFormacao(String parametroNomeFormacao) {
        this.parametroNomeFormacao = parametroNomeFormacao;
    }

    public String getParametroNomeTurma() {
        return parametroNomeTurma;
    }

    public void setParametroNomeTurma(String parametroNomeTurma) {
        this.parametroNomeTurma = parametroNomeTurma;
    }

    public BigDecimal getParametroBolsaAux() {
        return parametroBolsaAux;
    }

    public void setParametroBolsaAux(BigDecimal parametroBolsaAux) {
        this.parametroBolsaAux = parametroBolsaAux;
    }
}
