package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PROCESSO_SELETIVO")
public class ProcessoSeletivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cpf_instrutor", referencedColumnName = "cpf_instrutor", nullable = false)
    private Instrutor instrutor;
    @Column(name = "qtd_aprendiz")
    private Long qtdAprendiz;
    @Column(name = "qtd_trainee")
    private Long qtdTrainee;
    @Column(name = "qtd_estagiario")
    private Long qtdEstagiario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private String status;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    @Column(name = "data_fim")
    private LocalDate dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Long getQtdAprendiz() {
        return qtdAprendiz;
    }

    public void setQtdAprendiz(Long qtdAprendiz) {
        this.qtdAprendiz = qtdAprendiz;
    }

    public Long getQtdTrainee() {
        return qtdTrainee;
    }

    public void setQtdTrainee(Long qtdTrainee) {
        this.qtdTrainee = qtdTrainee;
    }

    public Long getQtdEstagiario() {
        return qtdEstagiario;
    }

    public void setQtdEstagiario(Long qtdEstagiario) {
        this.qtdEstagiario = qtdEstagiario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
