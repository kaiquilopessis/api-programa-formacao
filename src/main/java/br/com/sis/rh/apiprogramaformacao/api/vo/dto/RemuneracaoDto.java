package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class RemuneracaoDto {

    private String cargo;
    private BigDecimal bolsa;
    private BigDecimal beneficio;
    private BigDecimal convenio;
    private BigDecimal horaExtra;
    private BigDecimal beneficioLegislacao;
    private BigDecimal remunEsporadica;
    private BigDecimal remunExtra;
    private BigDecimal alura;

    public RemuneracaoDto(Remuneracao remuneracao){
        this.cargo = remuneracao.getCargo();
        this.bolsa = remuneracao.getBolsa();
        this.horaExtra = remuneracao.getHoraExtra();
        this.beneficioLegislacao = remuneracao.getBeneficioLegislacao();
        this.remunEsporadica = remuneracao.getRemunEsporadica();
        this.remunExtra = remuneracao.getRemunExtra();
        this.alura = remuneracao.getAlura();
        this.beneficio = remuneracao.getBeneficio();
        this.convenio = remuneracao.getConvenio();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getBolsa() {
        return bolsa;
    }

    public void setBolsa(BigDecimal bolsa) {
        this.bolsa = bolsa;
    }

    public BigDecimal getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(BigDecimal beneficio) {
        this.beneficio = beneficio;
    }

    public BigDecimal getConvenio() {
        return convenio;
    }

    public void setConvenio(BigDecimal convenio) {
        this.convenio = convenio;
    }

    public BigDecimal getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(BigDecimal horaExtra) {
        this.horaExtra = horaExtra;
    }

    public BigDecimal getBeneficioLegislacao() {
        return beneficioLegislacao;
    }

    public void setBeneficioLegislacao(BigDecimal beneficioLegislacao) {
        this.beneficioLegislacao = beneficioLegislacao;
    }

    public BigDecimal getRemunEsporadica() {
        return remunEsporadica;
    }

    public void setRemunEsporadica(BigDecimal remunEsporadica) {
        this.remunEsporadica = remunEsporadica;
    }

    public BigDecimal getRemunExtra() {
        return remunExtra;
    }

    public void setRemunExtra(BigDecimal remunExtra) {
        this.remunExtra = remunExtra;
    }

    public BigDecimal getAlura() {
        return alura;
    }

    public void setAlura(BigDecimal alura) {
        this.alura = alura;
    }
}
