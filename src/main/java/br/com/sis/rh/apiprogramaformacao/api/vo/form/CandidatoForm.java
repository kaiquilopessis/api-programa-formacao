package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidato;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CandidatoForm {

    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private String observacao;
    private String status;
    private BigDecimal testeLogico;
    private String notaDisc;
    private String curriculo;
    private String disc;
    private Long idProcessoSeletivo;

    public Candidato converter (ProcessoSeletivoRepository repository){

        ProcessoSeletivo processoSeletivo = repository.getById(idProcessoSeletivo);

        return new Candidato(nome, telefone, dataAgendamento, testeLogico, notaDisc, status, observacao, curriculo, disc, curso, fonteRecrutamento, processoSeletivo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFonteRecrutamento() {
        return fonteRecrutamento;
    }

    public void setFonteRecrutamento(String fonteRecrutamento) {
        this.fonteRecrutamento = fonteRecrutamento;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTesteLogico() {
        return testeLogico;
    }

    public void setTesteLogico(BigDecimal testeLogico) {
        this.testeLogico = testeLogico;
    }

    public String getNotaDisc() {
        return notaDisc;
    }

    public void setNotaDisc(String notaDisc) {
        this.notaDisc = notaDisc;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public Long getIdProcessoSeletivo() {
        return idProcessoSeletivo;
    }

    public void setIdProcessoSeletivo(Long idProcessoSeletivo) {
        this.idProcessoSeletivo = idProcessoSeletivo;
    }
}
