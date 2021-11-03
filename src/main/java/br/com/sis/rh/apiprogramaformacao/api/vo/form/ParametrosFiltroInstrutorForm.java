package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

public class ParametrosFiltroInstrutorForm {

    private String parametroNomeInstrutor;
    private String parametroNomeFormacao;
    private String parametroNomeTurma;
    private BigDecimal parametroValorHora;

    public String getParametroNomeInstrutor() {
        return parametroNomeInstrutor;
    }

    public void setParametroNomeInstrutor(String parametroNomeInstrutor) {
        this.parametroNomeInstrutor = parametroNomeInstrutor;
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

    public BigDecimal getParametroValorHora() {
        return parametroValorHora;
    }

    public void setParametroValorHora(BigDecimal parametroValorHora) {
        this.parametroValorHora = parametroValorHora;
    }
}
