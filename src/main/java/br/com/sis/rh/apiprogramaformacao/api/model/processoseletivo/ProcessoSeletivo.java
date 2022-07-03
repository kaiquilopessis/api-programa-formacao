package br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo;

import javax.persistence.*;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Instrutor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_PROCESSO_SELETIVO")
public class ProcessoSeletivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cpf_instrutor_fk", referencedColumnName = "cpf_instrutor", nullable = false)
    private Instrutor instrutor;
    @Column(name = "qtd_aprendiz")
    private Integer qtdAprendiz;
    @Column(name = "qtd_trainee")
    private Integer qtdTrainee;
    @Column(name = "qtd_estagiario")
    private Integer qtdEstagiario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private String status;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    @Column(name = "data_fim")
    private LocalDate dataFim;
    @Column (name = "processo_vinculado")
    private Integer processoVinculado;
    @Column (name = "nome_turma")
    private String nomeTurma;

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

	public Integer getProcessoVinculado() {
		return processoVinculado;
	}

	public void setProcessoVinculado(Integer processoVinculado) {
		this.processoVinculado = processoVinculado;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
    
}
