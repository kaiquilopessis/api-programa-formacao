package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "TB_PROCESSO_SELETIVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoSeletivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "qtd_aprendiz")
    private Integer qtdAprendiz;
    @Column(name = "qtd_trainee")
    private Integer qtdTrainee;
    @Column(name = "qtd_estagiario")
    private Integer qtdEstagiario;
    @Column(name = "nome")
    private String nomePrograma;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusProcessoSeletivo statusProcessoSeletivo;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    @Column(name = "data_fim")
    private LocalDate dataFim;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Instrutor> instrutores;
}
