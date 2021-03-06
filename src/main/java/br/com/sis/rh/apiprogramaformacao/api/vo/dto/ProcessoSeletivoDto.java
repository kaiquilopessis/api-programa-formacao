package br.com.sis.rh.apiprogramaformacao.api.vo.dto;


import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;

public class ProcessoSeletivoDto {

    private Long id;
    private String nome;
    private Integer qtdAprendiz;
    private Integer qtdTrainee;
    private Integer qtdEstagiario;
    private String status;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String nomeInstrutor;
    private String nomeTurma;

    public ProcessoSeletivoDto(ProcessoSeletivo processoSeletivo){
        this.id = processoSeletivo.getId();
        this.nome = processoSeletivo.getNome();
        this.qtdAprendiz = processoSeletivo.getQtdAprendiz();
        this.qtdEstagiario = processoSeletivo.getQtdEstagiario();
        this.qtdTrainee = processoSeletivo.getQtdTrainee();
        this.status = processoSeletivo.getStatus();
        this.dataFim = processoSeletivo.getDataFim();
        this.dataInicio = processoSeletivo.getDataInicio();
        this.nomeInstrutor = processoSeletivo.getInstrutor().getNome();
        this.nomeTurma = processoSeletivo.getNomeTurma();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAprendiz() {
        return qtdAprendiz;
    }

    public void setQtdAprendiz(Integer qtdAprendiz) {
        this.qtdAprendiz = qtdAprendiz;
    }

    public Integer getQtdTrainee() {
        return qtdTrainee;
    }

    public void setQtdTrainee(Integer qtdTrainee) {
        this.qtdTrainee = qtdTrainee;
    }

    public Integer getQtdEstagiario() {
        return qtdEstagiario;
    }

    public void setQtdEstagiario(Integer qtdEstagiario) {
        this.qtdEstagiario = qtdEstagiario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNomeTurma() {
		return nomeTurma;
	}
    
    
}
