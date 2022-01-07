package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;


public class AtualizaRemuneracaoForm {

    private String cargo;
    private BigDecimal bolsa;
    private BigDecimal beneficio;
    private BigDecimal convenio;
    private BigDecimal horaExtra;
    private BigDecimal beneficioLegislacao;
    private BigDecimal remunEsporadica;
    private BigDecimal remunExtra;
    private BigDecimal alura;

    public Remuneracao atualizar(Long id, RemuneracaoRepository remuneracaoRepository){

        Remuneracao remuneracao = remuneracaoRepository.getById(id);
        remuneracao.setCargo(this.cargo);
        remuneracao.setBolsa(this.bolsa);
        remuneracao.setBeneficio(this.beneficio);
        remuneracao.setConvenio(this.convenio);
        remuneracao.setHoraExtra(this.horaExtra);
        remuneracao.setBeneficioLegislacao(this.beneficioLegislacao);
        remuneracao.setRemunEsporadica(this.remunEsporadica);
        remuneracao.setRemunExtra(this.remunExtra);
        remuneracao.setAlura(this.alura);
        return remuneracao;
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
