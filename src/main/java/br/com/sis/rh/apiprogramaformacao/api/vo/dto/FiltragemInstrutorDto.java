package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FiltragemInstrutorDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpf_instrutor")
    private String cpfInstrutor;
    @Column(name = "nome_instrutor")
    private String nomeInstrutor;
    @Column(name = "nome")
    private String nomeFormacao;
    @Column(name = "nome_turma")
    private String nomeTurma;
    @Column(name = "data_fim")
    private LocalDate dataFim;
    @Column(name = "qtd_hora")
    private Integer qtdHora;
    @Column(name = "vlr_hora")
    private BigDecimal vlrHora;
}
