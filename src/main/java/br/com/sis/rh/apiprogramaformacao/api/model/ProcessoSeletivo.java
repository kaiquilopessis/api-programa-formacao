package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
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
}
