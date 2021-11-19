package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CandidatoDto {
    private Long id;
    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private String status;
    private BigDecimal testeLogico;
    private String notaDisc;
    private String observacao;
    private String processoSeletivo;
    private Long processoSeletivoId;

    public CandidatoDto(Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.fonteRecrutamento = candidato.getFonteRecrutamento();
        this.telefone = candidato.getTelefone();
        this.dataAgendamento = candidato.getDataAgendamento();
        this.curso = candidato.getCurso();
        this.status = candidato.getStatus();
        this.testeLogico = candidato.getTesteLogico();
        this.observacao = candidato.getObservacao();
        this.notaDisc = candidato.getNotaDisc();
        this.processoSeletivo = candidato.getProcessoSeletivo().getNome();
        this.processoSeletivoId = candidato.getProcessoSeletivo().getId();

    }

    public CandidatoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(String processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }

    public Long getProcessoSeletivoId() {
        return processoSeletivoId;
    }

    public void setProcessoSeletivoId(Long processoSeletivoId) {
        this.processoSeletivoId = processoSeletivoId;
    }

}
