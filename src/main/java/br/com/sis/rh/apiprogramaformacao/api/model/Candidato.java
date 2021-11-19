package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "TB_CANDIDATO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nomeCandidato;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;
    @Column(name = "teste_logico")
    private Double testeLogico;
    @Column(name = "nota_DISC")
    private String notaDisc;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusCandidato statusCandidato;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "curso")
    private String curso;
    @Column(name = "fonte_recrutamento")
    private String fonteRecrutamento;
    @ManyToOne
    @JoinColumn(name = "processo_seletivo_fk")
    private ProcessoSeletivo processoSeletivo;

}
