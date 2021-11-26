package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CandidatoCompletoDto {
    private long id;
    private String nome;
    private String telefone;
    private LocalDate dataAgendamento;
    private BigDecimal testeLogico;
    private String notaDisc;
    private String status;
    private String observacao;
    private byte[] disc;
    private byte[] curriculo;
    private String curso;
    private String fonteRecrutamento;
    private ProcessoSeletivo processoSeletivo;

    public CandidatoCompletoDto(){

    }

    public CandidatoCompletoDto(Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.telefone = candidato.getTelefone();
        this.dataAgendamento = candidato.getDataAgendamento();
        this.testeLogico = candidato.getTesteLogico();
        this.notaDisc = candidato.getNotaDisc();
        this.status = candidato.getStatus();
        this.observacao = candidato.getObservacao();
        this.disc = candidato.getDisc();
        this.curriculo = candidato.getCurriculo();
        this.curso = candidato.getCurso();
        this.fonteRecrutamento = candidato.getFonteRecrutamento();
        this.processoSeletivo = candidato.getProcessoSeletivo();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public byte[] getDisc() {
        return disc;
    }

    public void setDisc(byte[] disc) {
        this.disc = disc;
    }

    public byte[] getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(byte[] curriculo) {
        this.curriculo = curriculo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFonteRecrutamento() {
        return fonteRecrutamento;
    }

    public void setFonteRecrutamento(String fonteRecrutamento) {
        this.fonteRecrutamento = fonteRecrutamento;
    }

    public ProcessoSeletivo getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }

}